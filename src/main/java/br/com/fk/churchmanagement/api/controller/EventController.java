package br.com.fk.churchmanagement.api.controller;

import br.com.fk.churchmanagement.api.dto.EventDayPersonDTO;
import br.com.fk.churchmanagement.api.entity.Event;
import br.com.fk.churchmanagement.api.service.EventDayPersonService;
import br.com.fk.churchmanagement.api.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventDayPersonService eventDayPersonService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event userDetails) {
        return eventService.updateEvent(id, userDetails);
    }

    @DeleteMapping
    public String deleteAllEvents() {
        eventService.deleteAllEvents();
        return "All users have been deleted successfully.";
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @PostMapping("/{eventId}/person/{id}")
    public ResponseEntity<Void> saveEventDayPerson(@PathVariable Long eventId, @PathVariable Long id, @RequestBody EventDayPersonDTO eventDayDTO) {
        eventDayDTO.setEventId(eventId);
        eventDayDTO.setPersonId(id);
        eventDayPersonService.saveEventDayPerson(eventDayDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
