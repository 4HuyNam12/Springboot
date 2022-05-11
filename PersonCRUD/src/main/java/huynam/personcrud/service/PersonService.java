package huynam.personcrud.service;

import huynam.personcrud.entity.Person;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonService {

    List<Person> getListPersons();

    Person getPersonById(int id);

    void updatePerson(Person person,int id);

    void createPerson(Person person);

    void deleteById(int id);

    List<Person> searchByName(@Param("name")String name);
}
