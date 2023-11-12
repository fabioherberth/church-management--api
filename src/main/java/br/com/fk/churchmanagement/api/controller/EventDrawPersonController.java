package br.com.fk.churchmanagement.api.controller;

import br.com.fk.churchmanagement.api.entity.Person;
import br.com.fk.churchmanagement.api.service.EventDrawPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/draw")
@RequiredArgsConstructor
public class EventDrawPersonController {

    private final EventDrawPersonService eventDrawPersonService;

    @GetMapping("/event/{eventId}")
    public Person drawPerson(@PathVariable Long eventId) {
        return eventDrawPersonService.drawPersonEvent(eventId);
    }

}
