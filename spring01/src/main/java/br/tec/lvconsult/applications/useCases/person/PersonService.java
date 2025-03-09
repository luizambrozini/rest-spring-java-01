package br.tec.lvconsult.applications.useCases.person;

import br.tec.lvconsult.exceptions.ResourceNotFoundException;
import br.tec.lvconsult.models.Person;
import br.tec.lvconsult.repositories.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRespository personRespository;


    public List<Person> findAll() {
        logger.info("Method findAll called");
        return personRespository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Method findById called with id: " + id);
        return personRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found for id: " + id));
    }

    public Person create(Person person) {
        logger.info("Method create called with person: " + person);
        return personRespository.save(person);
    }

    public Person update(Long id,Person person) {
        logger.info("Method update called with person: " + person.getFirstName());
        Person personToUpdate = findById(id);

        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setAddress(person.getAddress());
        personToUpdate.setGender(person.getGender());

        logger.info("Person updated: " + personToUpdate.getId());
        personRespository.save(personToUpdate);

        return personToUpdate;
    }

    public void delete(Long id) {
        var personToDelete = findById(id);
        logger.info("Method delete called with id: " + id);
        personRespository.delete(personToDelete);
    }
}
