package com.ticketApp.ticketApp.repository;

import com.ticketApp.ticketApp.dto.SearchDTO;
import com.ticketApp.ticketApp.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ticketApp.ticketApp.entity.EventEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

    @Query(value = "select e from EventEntity e " +
            " where e.location=:location and " +
            " e.date between :from and :to ")
    List<EventEntity> getEventsBySearchCriteria(final String location, final Date from, final Date to);
}

