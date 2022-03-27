package com.ticketApp.ticketApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EventDTO {

    @NotNull(message = "event ID cannot be null")
    private Integer eventID;

    @NotNull(message = "event name cannot be null")
    private String name;

    @NotNull(message = "event location cannot be null")
    private String location;

    private String description;

    @NotNull(message = "event date cannot be null")
    private Date date;

    @NotNull(message = "event start time cannot be null")
    private LocalTime startTime;

    @NotNull
    private byte[] photo;

    private List<TicketDTO> tickets;
}
