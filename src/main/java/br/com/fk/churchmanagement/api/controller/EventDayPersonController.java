package br.com.fk.churchmanagement.api.controller;

import br.com.fk.churchmanagement.api.service.EventDayPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventDay")
@RequiredArgsConstructor
public class EventDayPersonController {

    private final EventDayPersonService dayPersonService;

    @PostMapping("/present")
    public ResponseEntity<Void> savePeopleInDayEvent(@RequestBody List<Long> peopleIds) {
        dayPersonService.savePeople(peopleIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
