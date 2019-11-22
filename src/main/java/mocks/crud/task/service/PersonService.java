package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.AdvancedRepository;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonService implements AdvancedRepository {

    /*
    * Не понял, как в этом классе можно использовать addressService?
    */
    private AddressService addressService;

    private CrudRepository<Long, Person> personRepository;

    public PersonService(AddressService addressService, CrudRepository<Long, Person> personRepository) {
        this.addressService = addressService;
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllRelatives(Person person) {
        //todo написать реализацию
        /*
        * В целом можно было сразу вернуть person.getRelatives(),
        * но при изучении класса Person было замечено, что
        * по умолчанию список relatives не задается. Поэтому
        * элементы для него должны добавляться где-то дальше
        * в программе при использовании класса Person.
        * Из этого был сделал вывод, что просто
        * вернуть person.getRelatives() не совсем правильно.
        * Логичным показалось пройтись по всем людям из
        * personRepository, и посмотрить их родственников.
        * Если среди родственников человека окажется person,
        * то данный человек является родственником для person.
        * */
        List<Person> findRelatives = new ArrayList<>();
        List<Person> persons = findAll();
        for (Person tmpPerson: persons){
            List<Person> relatives = tmpPerson.getRelatives();
            for (Person relative: relatives){
                if (relative.getName().equals(person.getName()) &&
                        relative.getAddress().equals(person.getAddress()) &&
                        relative.getAge().equals(person.getAge())){
                    findRelatives.add(tmpPerson);
                }
            }
        }
        return findRelatives;
    }

    @Override
    public Address getAddress(Person person) {
        //todo написать реализацию
        /*
        В данном случаем при создании объекта person,
        мы обязаны указать ему адрес по умолчанию.
        */
        return person.getAddress();
    }

    public void save(Person element) {
        //todo написать реализацию
        personRepository.save(element);
    }

    public Person findById(Long id) {
        //todo написать реализацию
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        //todo написать реализацию
        return personRepository.findAll();
    }

    public Person update(Person element) {
        //todo написать реализацию
        return personRepository.update(element);
    }

    public void delete(Person element) {
        //todo написать реализацию
        personRepository.delete(element);
    }
}
