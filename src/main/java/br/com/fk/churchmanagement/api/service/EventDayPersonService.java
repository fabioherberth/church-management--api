package br.com.fk.churchmanagement.api.service;

import br.com.fk.churchmanagement.api.dto.EventDayPersonDTO;
import br.com.fk.churchmanagement.api.entity.Event;
import br.com.fk.churchmanagement.api.entity.EventDayPerson;
import br.com.fk.churchmanagement.api.entity.Person;
import br.com.fk.churchmanagement.api.repository.EventDayPersonRepository;
import br.com.fk.churchmanagement.api.repository.EventRepository;
import br.com.fk.churchmanagement.api.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventDayPersonService {

    private final EventDayPersonRepository dayPersonRepository;
    private final EventRepository eventRepository;
    private final PersonRepository personRepository;

    public void saveEventDayPerson(EventDayPersonDTO eventDayDTO) {

        Optional<Event> eventOpt = eventRepository.findById(eventDayDTO.getEventId());
        if (eventOpt.isEmpty()) {
            throw new RuntimeException("Event not fount.");
        }

        EventDayPerson eventDayPerson = new EventDayPerson();
        eventDayPerson.setEvent(eventOpt.get());

        Optional<Person> personOpt = personRepository.findById(eventDayDTO.getPersonId());
        if (personOpt.isEmpty()) {
            throw new RuntimeException("Person not fount.");
        }

        eventDayPerson.setPerson(personOpt.get());
        eventDayPerson.setEventDay(eventDayDTO.getToday());
        dayPersonRepository.save(eventDayPerson);
    }

}
