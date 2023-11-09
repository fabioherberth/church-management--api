package br.com.fk.churchmanagement.api.service;

import br.com.fk.churchmanagement.api.entity.Event;
import br.com.fk.churchmanagement.api.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Optional<Event> event = eventRepository.findById(id);

        if (event.isEmpty()) {
            return null;
        }

        Event existingEvent = event.get();
        existingEvent.setName(eventDetails.getName());
        existingEvent.setStartDate(eventDetails.getStartDate());
        existingEvent.setEndDate(eventDetails.getEndDate());
        return eventRepository.save(existingEvent);
    }

    public void deleteAllEvents() {
        eventRepository.deleteAll();
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}
