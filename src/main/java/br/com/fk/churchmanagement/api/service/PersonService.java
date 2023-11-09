package br.com.fk.churchmanagement.api.service;

import br.com.fk.churchmanagement.api.entity.Person;
import br.com.fk.churchmanagement.api.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person createPerson(Person user) {
        return personRepository.save(user);
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            Person existingUser = person.get();
            existingUser.setName(personDetails.getName());
            existingUser.setTelephone(personDetails.getTelephone());
            existingUser.setIsVisitor(personDetails.getIsVisitor());
            return personRepository.save(existingUser);
        }
        return null;
    }

    public void deleteAllPeople() {
        personRepository.deleteAll();
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}
