package com.boathouse.gokul.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.boathouse.gokul.Exception.ResourceNotFoundException;
import com.boathouse.gokul.Mapper.TicketMapper;
import com.boathouse.gokul.Model.Ticket;
import com.boathouse.gokul.Repository.TicketRepository;
import com.boathouse.gokul.Service.TicketService;
import com.boathouse.gokul.dto.BoatTicketDTO;
import com.boathouse.gokul.dto.TicketDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{
    private TicketRepository ticketrepo;

    @Override 
    public TicketDTO createTicket(TicketDTO ticketDTO){
        Ticket ticket = TicketMapper.mapToTicket(ticketDTO);
        Ticket savedTicket = ticketrepo.save(ticket);
        return TicketMapper.mapToTicketDTO(savedTicket);
    }

    @Override
    public List<TicketDTO> getAllTicket(){
        List<Ticket> tickets = ticketrepo.findAll();
        List<TicketDTO> ticketDTOs = new ArrayList<>();
        for(Ticket ticket : tickets){
            ticketDTOs.add(TicketMapper.mapToTicketDTO(ticket));
        }
        return ticketDTOs;
    }

    @Override
    public TicketDTO getTicketById(Long id){
        Ticket ticket = ticketrepo.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Ticket not exist with id : " )
        );
        return TicketMapper.mapToTicketDTO(ticket);
    }

    @Override
    public List<BoatTicketDTO> getTicketData(String type, String date) {
        // Assuming you have a method in the repository to fetch ticket data based on type and value
        return ticketrepo.findTicketAndBoatByTypeAndDate(type, date);
    }
}
