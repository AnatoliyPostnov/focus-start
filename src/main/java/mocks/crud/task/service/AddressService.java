package mocks.crud.task.service;

import mocks.crud.task.MyExceptions.AddressWasNotFound;
import mocks.crud.task.MyExceptions.DataBaseAlreadyContainsAddressWithSpecifiedId;
import mocks.crud.task.MyExceptions.UpdateAddressWasNotFound;
import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class AddressService implements CrudRepository<Long, Address> {
    private List<Address> addresses;

    public AddressService(){
        addresses = new ArrayList<>();
    }

    @Override
    public void save(Address element) {
        //todo написать реализацию
        for (Address address : addresses){
            if (address.getId().equals(element.getId())){
                throw new DataBaseAlreadyContainsAddressWithSpecifiedId();
            }
        }
        addresses.add(element);
    }

    @Override
    public Address findById(Long id) {
        //todo написать реализацию
        for (Address address : addresses){
            if (address.getId().equals(id)){
                return address;
            }
        }
        throw new AddressWasNotFound();
    }

    @Override
    public List<Address> findAll() {
        //todo написать реализацию
        return addresses;
    }

    @Override
    public Address update(Address element) {
        //todo написать реализацию
        for (int i = 0; i < addresses.size(); ++i){
            if (addresses.get(i).getId().equals(element.getId())){
                Address tmp = addresses.get(i);
                addresses.add(i, element);
                addresses.remove(i + 1);
                return tmp;
            }
        }
        throw new UpdateAddressWasNotFound();
    }

    @Override
    public void delete(Address element) {
        //todo написать реализацию
        for (int i = 0; i < addresses.size(); ++i){
            if (addresses.get(i).getId().equals(element.getId())){
                addresses.remove(addresses.get(i));
            }
        }
    }
}
