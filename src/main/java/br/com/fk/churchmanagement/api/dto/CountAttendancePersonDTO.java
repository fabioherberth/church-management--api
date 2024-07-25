package br.com.fk.churchmanagement.api.dto;

import lombok.Getter;

@Getter
public class CountAttendancePersonDTO {
    private final Integer count;

    public CountAttendancePersonDTO(Integer count) {
        this.count = count;
    }
}
