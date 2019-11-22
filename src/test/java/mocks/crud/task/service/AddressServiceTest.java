package mocks.crud.task.service;

import mocks.crud.task.MyExceptions.AddressWasNotFound;
import mocks.crud.task.MyExceptions.UpdateAddressWasNotFound;
import mocks.crud.task.model.Address;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressServiceTest {

    private AddressService addressService;

    @Before
    public void init(){
        addressService = new AddressService();
        Address address1 = new Address((long) 1, "address1");
        Address address2 = new Address((long) 2, "address2");
        Address address3 = new Address((long) 3, "address3");
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

        String test = "1 address1" + " 2 address2" + " 3 address3" +
                " 4 address4" + " 5 address5" + " 6 address6 ";
        String result = "";

        for (Address address : addressService.findAll()){
            result += address.getId() + " " + address.getAddress() + " ";
        }
        assertEquals(test, result);
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
        String test = "1 address1" + " 2 address update" + " 3 address3 ";
        String result = "";

        for (Address address : addressService.findAll()){
            result += address.getId() + " " + address.getAddress() + " ";
        }
        assertEquals(test, result);
    }

    @Test
    public void updateFirstElementTest(){
        Address addressUpdate = new Address((long) 1, "address update");
        addressService.update(addressUpdate);
        String test = "1 address update" + " 2 address2" + " 3 address3 ";
        String result = "";

        for (Address address : addressService.findAll()){
            result += address.getId() + " " + address.getAddress() + " ";
        }
        assertEquals(test, result);
    }

    @Test
    public void updateLastElementTest(){
        Address addressUpdate = new Address((long) 3, "address update");
        addressService.update(addressUpdate);
        String test = "1 address1" + " 2 address2" + " 3 address update ";
        String result = "";

        for (Address address : addressService.findAll()){
            result += address.getId() + " " + address.getAddress() + " ";
        }
        assertEquals(test, result);
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
        String test = "2 address2" + " 3 address3 ";
        String result = "";

        for (Address address : addressService.findAll()){
            result += address.getId() + " " + address.getAddress() + " ";
        }
        assertEquals(test, result);
    }

    @Test
    public void deleteLastElementTest(){
        Address addressDelete = new Address((long) 3, "address3");
        addressService.delete(addressDelete);
        String test = "1 address1" + " 2 address2 ";
        String result = "";

        for (Address address : addressService.findAll()){
            result += address.getId() + " " + address.getAddress() + " ";
        }
        assertEquals(test, result);
    }

    @Test
    public void deleteNonExistElementTest(){
        Address addressDelete = new Address((long) 4, "address4");
        addressService.delete(addressDelete);
        String test = "1 address1 2 address2 3 address3 ";
        String result = "";

        for (Address address : addressService.findAll()){
            result += address.getId() + " " + address.getAddress() + " ";
        }
        assertEquals(test, result);
    }

}