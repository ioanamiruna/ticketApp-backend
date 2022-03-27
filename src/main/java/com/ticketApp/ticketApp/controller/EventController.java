package com.ticketApp.ticketApp.controller;

import com.ticketApp.ticketApp.dto.EventDTO;
import com.ticketApp.ticketApp.dto.SearchDTO;
import com.ticketApp.ticketApp.dto.TicketDTO;
import com.ticketApp.ticketApp.entity.EventEntity;
import com.ticketApp.ticketApp.entity.TicketEntity;
import com.ticketApp.ticketApp.service.EventService;
import com.ticketApp.ticketApp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public List<EventDTO> getEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventID}")
    public EventDTO getEventByID(@PathVariable final Integer eventID){
        return eventService.getEventByID(eventID);
    }

//    @PostMapping()
//    public EventEntity createEvent(@RequestBody EventEntity event) {
//        return eventService.createEvent(event);
//    }

    @PostMapping()
    public List<EventDTO> search(@RequestBody SearchDTO search) throws ParseException {
        return eventService.getEventsBySearchCriteria(search);
    }
}
