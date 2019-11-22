package mocks.crud.task.service;


import mocks.crud.task.model.Person;
import mocks.crud.task.repository.CrudRepository;

import java.util.List;

public class PersonRepository implements CrudRepository <Long, Person> {
    @Override
    public void save(Person element) {

    }

    @Override
    public Person findById(Long id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person update(Person element) {
        return null;
    }

    @Override
    public void delete(Person element) {

    }
}
