package huynam.personcrud.service;

import huynam.personcrud.entity.Person;
import huynam.personcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getListPersons() {
        List<Person> listPersons = personRepository.findAll();
        return listPersons;
    }

    @Override
    public Person getPersonById(int id) {
        return personRepository.findById(id).get();
    }

    @Override
    public void updatePerson(Person req, int id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Person existPerson = person.get();
            existPerson.setId(id);
            existPerson.setName(req.getName());
            existPerson.setJob(req.getJob());
            existPerson.setGender(req.isGender());
            existPerson.setBirthDay(req.getBirthDay());
            personRepository.updatePerson(req.getName(), req.getJob(), req.isGender(), req.getBirthDay(), id);
        }
    }

    @Override
    public void createPerson(Person req) {
        Person person = new Person();
        person.setName(req.getName());
        person.setJob(req.getJob());
        person.setGender(req.isGender());
        person.setBirthDay(req.getBirthDay());
        personRepository.save(person);
    }


    @Override
    public void deleteById(int id) {
            personRepository.deleteById(id);
    }

    @Override
    public List<Person> searchByName(String name) {
        List<Person> result = personRepository.searchByName(name);
        return result;
    }


}
