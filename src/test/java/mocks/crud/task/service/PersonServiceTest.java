package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    PersonRepository personRepository = mock(PersonRepository.class);

    AddressService addressService;
    PersonService personService;

    @Before
    public  void init() {
        addressService = new AddressService();
        MockitoAnnotations.initMocks(this);
        personService = new PersonService(addressService, personRepository);
    }

    @Test
    public void findByIdTest(){
        Person person = new Person("person1", 15, new Address((long) 1, "address1"));
        Mockito.doReturn(person).when(personRepository).findById((long) 1);
        assertEquals(person, personService.findById((long) 1));
    }

    @Test
    public void findAllTest(){
        List<Person> testList = new ArrayList<>();
        testList.add(new Person("person1", 15, new Address((long) 1, "address1")));
        testList.add(new Person("person1", 15, new Address((long) 1, "address1")));
        testList.add(new Person("person1", 15, new Address((long) 1, "address1")));
        Mockito.doReturn(testList).when(personRepository).findAll();
        assertEquals(testList, personService.findAll());
    }

    @Test()
    public void deleteTest(){
        Person person = new Person("person1", 15, new Address((long) 1, "address1"));
        personService.delete(person);
        personService.delete(person);
        verify(personRepository, times(2)).delete(person);
    }

    @Test()
    public void saveTest(){
        Person person = new Person("person1", 15, new Address((long) 1, "address1"));
        personService.save(person);
        personService.save(person);
        verify(personRepository, times(2)).save(person);
    }

    @Test()
    public void updateTest(){
        Person person = new Person("person1", 15, new Address((long) 1, "address1"));
        Mockito.doReturn(person).when(personRepository).update(person);
        assertEquals(person, personService.update(person));
    }
}