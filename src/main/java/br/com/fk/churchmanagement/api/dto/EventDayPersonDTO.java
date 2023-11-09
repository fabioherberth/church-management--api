package br.com.fk.churchmanagement.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventDayPersonDTO {

    private Date today;
    private Long eventId;
    private Long personId;

}
