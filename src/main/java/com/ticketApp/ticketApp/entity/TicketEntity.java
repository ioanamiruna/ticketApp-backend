package com.ticketApp.ticketApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "TICKET", schema = "ticket_app")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Integer ticketID;

    @Column(name = "id_event")
    private Integer eventID;

    @Column(name = "price")
    private double price;

    @Column(name = "seat")
    private String seat;

//    @Column(name = "id_user")
//    private Integer userID;
    //TODO
}
