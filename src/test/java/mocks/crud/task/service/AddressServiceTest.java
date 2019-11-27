package mocks.crud.task.service;

import mocks.crud.task.exceptions.AddressWasNotFound;
import mocks.crud.task.exceptions.UpdateAddressWasNotFound;
import mocks.crud.task.model.Address;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class AddressServiceTest {

    private AddressService addressService;
    private Address address1;
    private Address address2;
    private Address address3;

    @Before
    public void init(){
        addressService = new AddressService();
        address1 = new Address((long) 1, "address1");
        address2 = new Address((long) 2, "address2");
        address3 = new Address((long) 3, "address3");
        addressService.save(address1);
        addressService.save(address2);
        addressService.save(address3);
    }

    @Test
    public void saveAndFindAllTest(){
        Address address4 = new Address((long) 4, "address4");
        Address address5 = new Address((long) 5, "address5");
        Address address6 = new Address((long) 6, "address6");

        addressService.save(address4);
        addressService.save(address5);
        addressService.save(address6);

        assertThat(addressService.getAddresses(), hasItems(address1, address2, address3, address4, address5, address6));
    }

    @Test
    public void  findByIdTest(){
        Address address = addressService.findById((long) 1);
        assertEquals("address1", address.getAddress());
        address = addressService.findById((long) 3);
        assertEquals("address3", address.getAddress());
        address = addressService.findById((long) 2);
        assertEquals("address2", address.getAddress());
    }

    @Test(expected = AddressWasNotFound.class)
    public void  findByIdTestException1(){
        Address address = addressService.findById((long) 4);
    }

    @Test(expected = AddressWasNotFound.class)
    public void  findByIdTestException2(){
        Address address = addressService.findById((long) 0);
    }

    @Test
    public void updateCentralElementTest(){
        Address addressUpdate = new Address((long) 2, "address update");
        addressService.update(addressUpdate);
        assertThat(addressService.getAddresses(), contains(address1, addressUpdate, address3));
    }

    @Test
    public void updateFirstElementTest(){
        Address addressUpdate = new Address((long) 1, "address update");
        addressService.update(addressUpdate);
        assertThat(addressService.getAddresses(), contains( addressUpdate, address2, address3));
    }

    @Test
    public void updateLastElementTest(){
        Address addressUpdate = new Address((long) 3, "address update");
        addressService.update(addressUpdate);
        assertThat(addressService.getAddresses(), contains(address1, address2,  addressUpdate));
    }

    @Test(expected = UpdateAddressWasNotFound.class)
    public void updateNonExistentElementTest1(){
        Address addressUpdate = new Address((long) 4, "address update");
        addressService.update(addressUpdate);
    }

    @Test(expected = UpdateAddressWasNotFound.class)
    public void updateNonExistentElementTest2(){
        Address addressUpdate = new Address((long) 0, "address update");
        addressService.update(addressUpdate);
    }

    @Test
    public void deleteFirstElementTest(){
        Address addressDelete = new Address((long) 1, "address1");
        addressService.delete(addressDelete);
        assertThat(addressService.getAddresses(), contains(address2,  address3));
    }

    @Test
    public void deleteLastElementTest(){
        Address addressDelete = new Address((long) 3, "address3");
        addressService.delete(addressDelete);
        assertThat(addressService.getAddresses(), contains(address1,  address2));
    }

    @Test
    public void deleteNonExistElementTest(){
        Address addressDelete = new Address((long) 4, "address4");
        addressService.delete(addressDelete);
        assertThat(addressService.getAddresses(), contains(address1,  address2, address3));
    }

}