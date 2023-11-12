package br.com.fk.churchmanagement.api.service;

import br.com.fk.churchmanagement.api.entity.Event;
import br.com.fk.churchmanagement.api.entity.EventDayPerson;
import br.com.fk.churchmanagement.api.entity.Person;
import br.com.fk.churchmanagement.api.repository.EventDayPersonRepository;
import br.com.fk.churchmanagement.api.repository.EventRepository;
import br.com.fk.churchmanagement.api.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final EventRepository eventRepository;
    private final PersonRepository personRepository;
    private final EventDayPersonRepository dayPersonRepository;

    public Person createPerson(Long eventId, Person user) {
        Optional<Person> optName = personRepository.findByNameIgnoreCase(user.getName());
        if (optName.isPresent()) {
            return null;
        }

        final Optional<Event> optEvent = eventRepository.findById(eventId);

        if (optEvent.isEmpty()) {
            return new Person();
        }

        final Person person = personRepository.save(user);
        final EventDayPerson eventDayPerson = new EventDayPerson();
        eventDayPerson.setPerson(person);
        eventDayPerson.setEvent(optEvent.get());
        eventDayPerson.setEventDay(new Date());

        dayPersonRepository.save(eventDayPerson);
        return person;
    }

    public List<Person> getAllPeople() {
        return personRepository.getAllOrderByName();
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
