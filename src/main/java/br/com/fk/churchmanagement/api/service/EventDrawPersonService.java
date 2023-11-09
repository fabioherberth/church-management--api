package br.com.fk.apimultipleservices.service;

import br.com.fk.apimultipleservices.entity.EventDayPerson;
import br.com.fk.apimultipleservices.entity.EventDrawPerson;
import br.com.fk.apimultipleservices.entity.Person;
import br.com.fk.apimultipleservices.repository.EventDayPersonRepository;
import br.com.fk.apimultipleservices.repository.EventDrawPersonRepository;
import br.com.fk.apimultipleservices.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventDrawPersonService {

    private final EventDrawPersonRepository drawPersonRepository;
    private final EventDayPersonRepository dayPersonRepository;
    private final PersonRepository personRepository;

    public Person drawPersonEvent(Long eventId) {
        Long eventDayPersonId = drawPersonRepository.willDrawPerson(eventId);
        if (Objects.isNull(eventDayPersonId)) {
            return new Person();
        }

        Optional<EventDayPerson> dayPersonyByIdOpt = dayPersonRepository.findById(eventDayPersonId);
        if (dayPersonyByIdOpt.isEmpty()) {
            return new Person();
        }

        EventDayPerson eventDayPerson = dayPersonyByIdOpt.get();
        EventDrawPerson eventDrawPerson = new EventDrawPerson();
        eventDrawPerson.setEventDayPerson(eventDayPerson);
        eventDrawPerson.setPerson(eventDayPerson.getPerson());

        drawPersonRepository.save(eventDrawPerson);

        Optional<Person> personOpt = personRepository.findById(eventDayPerson.getPerson().getId());

        return personOpt.orElse(new Person());
    }
}
