package br.com.fk.churchmanagement.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "event_day_person")
public class EventDayPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date eventDay;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Person person;

}
