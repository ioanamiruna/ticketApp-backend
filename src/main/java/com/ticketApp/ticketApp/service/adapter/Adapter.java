package com.ticketApp.ticketApp.service.adapter;

import com.ticketApp.ticketApp.dto.EventDTO;
import com.ticketApp.ticketApp.dto.TicketDTO;
import com.ticketApp.ticketApp.dto.UserDTO;
import com.ticketApp.ticketApp.entity.EventEntity;
import com.ticketApp.ticketApp.entity.TicketEntity;
import com.ticketApp.ticketApp.entity.UserEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Adapter {
    public static TicketDTO convertTicketEntityToDTO(TicketEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        TicketDTO ticketDTO = modelMapper.map(entity, TicketDTO.class);

        return ticketDTO;
    }

    public static TicketEntity convertTicketDTOToEntity(TicketDTO ticketDTO) {
        ModelMapper modelMapper = new ModelMapper();
        TicketEntity ticket = modelMapper.map(ticketDTO, TicketEntity.class);

        return ticket;
    }

    public static List<TicketDTO> convertTicketEntitiesToDTOs(List<TicketEntity> ticketEntities) {
        return ticketEntities.stream().map(Adapter::convertTicketEntityToDTO).collect(Collectors.toList());
    }

    public static EventDTO convertEventEntityToDTO(EventEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        EventDTO eventDTO = modelMapper.map(entity, EventDTO.class);

        return eventDTO;
    }

    public static EventEntity convertEventDTOToEntity(EventDTO eventDTO) {
        ModelMapper modelMapper = new ModelMapper();
        EventEntity event = modelMapper.map(eventDTO, EventEntity.class);

        return event;
    }

    public static List<EventDTO> convertEventEntitiesToDTOs(List<EventEntity> eventEntities) {
        return eventEntities.stream().map(Adapter::convertEventEntityToDTO).collect(Collectors.toList());
    }

    public static UserDTO convertUserEntityToDTO(UserEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(entity, UserDTO.class);

        return userDTO;
    }
}
