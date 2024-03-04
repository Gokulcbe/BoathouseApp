package com.boathouse.gokul.Mapper;

import com.boathouse.gokul.Model.Ticket;
import com.boathouse.gokul.dto.TicketDTO;

public class TicketMapper {
    public static TicketDTO mapToTicketDTO(Ticket ticket){
        return new TicketDTO(
            ticket.getId(),
            ticket.getBoatId(),
            ticket.getType(),
            ticket.getDate(),
            ticket.getAvail()
        );
    }

    public static Ticket mapToTicket(TicketDTO ticketDTO){
        return new Ticket(
            ticketDTO.getId(),
            ticketDTO.getBoatId(),
            ticketDTO.getType(),
            ticketDTO.getDate(),
            ticketDTO.getAvail()
        );
    }
}
