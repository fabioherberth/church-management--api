package br.com.fk.churchmanagement.api.controller;

import br.com.fk.churchmanagement.api.entity.Person;
import br.com.fk.churchmanagement.api.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        Person personCreate = personService.createPerson(1L, person);

        if (Objects.isNull(personCreate)) {
             return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(personCreate);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        return personService.updatePerson(id, personDetails);
    }

    @DeleteMapping
    public String deleteAllPeople() {
        personService.deleteAllPeople();
        return "All People have been deleted successfully.";
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

}