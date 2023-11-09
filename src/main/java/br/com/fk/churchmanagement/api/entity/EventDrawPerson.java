package br.com.fk.churchmanagement.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "event_draw_person")
public class EventDrawPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    @ManyToOne
    private EventDayPerson eventDayPerson;

}
