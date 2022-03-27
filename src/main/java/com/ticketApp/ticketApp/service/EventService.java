package com.ticketApp.ticketApp.service;

import com.ticketApp.ticketApp.dto.EventDTO;
import com.ticketApp.ticketApp.dto.SearchDTO;
import com.ticketApp.ticketApp.dto.TicketDTO;
import com.ticketApp.ticketApp.entity.EventEntity;
import com.ticketApp.ticketApp.entity.TicketEntity;
import com.ticketApp.ticketApp.repository.EventRepository;
import com.ticketApp.ticketApp.repository.TicketRepository;
import com.ticketApp.ticketApp.service.adapter.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public List<EventDTO> getAllEvents() {
        return Adapter.convertEventEntitiesToDTOs(eventRepository.findAll());
    }

    public EventDTO getEventByID(Integer eventID){
        EventEntity event = eventRepository.getById(eventID);
        List<TicketEntity> ticketEntities = ticketRepository.getByEventID(eventID);

        EventDTO eventDTO = Adapter.convertEventEntityToDTO(event);
        List<TicketDTO> ticketDTOS = Adapter.convertTicketEntitiesToDTOs(ticketEntities);
        eventDTO.setTickets(ticketDTOS);
        return eventDTO;
    }

    public List<EventDTO> getEventsBySearchCriteria(SearchDTO searchCriteria) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        return Adapter.convertEventEntitiesToDTOs(eventRepository.getEventsBySearchCriteria(searchCriteria.location, formatter.parse(searchCriteria.from), formatter.parse(searchCriteria.to)));
    }

    public EventEntity createEvent(EventEntity event) {
        return eventRepository.save(event);
    }
}
