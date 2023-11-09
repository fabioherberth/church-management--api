package br.com.fk.apimultipleservices.controller;

import br.com.fk.apimultipleservices.entity.Person;
import br.com.fk.apimultipleservices.service.EventDrawPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/draw")
@RequiredArgsConstructor
public class EventDrawPersonController {

    private final EventDrawPersonService eventDrawPersonService;

    @GetMapping("/event/{id}")
    public Person drawPerson(@PathVariable Long id) {
        return eventDrawPersonService.drawPersonEvent(id);
    }

}
