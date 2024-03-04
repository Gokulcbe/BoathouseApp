package com.boathouse.gokul.Service;

import java.util.List;

import com.boathouse.gokul.dto.BoatTicketDTO;
import com.boathouse.gokul.dto.TicketDTO;

public interface TicketService {
    TicketDTO createTicket(TicketDTO ticketDTO);

    List<TicketDTO> getAllTicket();

    TicketDTO getTicketById(Long id);

    List<BoatTicketDTO> getTicketData(String type, String date);
}
