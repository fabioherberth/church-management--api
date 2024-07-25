package br.com.fk.churchmanagement.api.controller;

import br.com.fk.churchmanagement.api.dto.CountAttendancePersonDTO;
import br.com.fk.churchmanagement.api.service.EventDayPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventDay")
@RequiredArgsConstructor
public class EventDayPersonController {

    private final EventDayPersonService dayPersonService;

    @GetMapping("/peoplePresent")
    public List<String> getTheListOfPeoplePresent() {
        return dayPersonService.getListPeoplePresent();
    }

    @GetMapping("/countingAttendance/person/{personId}")
    public ResponseEntity<CountAttendancePersonDTO> countingAttendance(@PathVariable Long personId) {
        CountAttendancePersonDTO attendancePersonDTO = dayPersonService.countAttendancePerson(personId);
        return new ResponseEntity<>(attendancePersonDTO, HttpStatus.OK);
    }

    @PostMapping("/present")
    public ResponseEntity<Void> savePeopleInDayEvent(@RequestBody List<Long> peopleIds) {
        dayPersonService.savePeople(peopleIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
