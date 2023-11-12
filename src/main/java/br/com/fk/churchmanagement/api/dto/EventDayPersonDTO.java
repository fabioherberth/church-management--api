package br.com.fk.churchmanagement.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDayPersonDTO {

    private Date today;
    private Long eventId;
    private Long personId;

}
