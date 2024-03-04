package com.boathouse.gokul.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.boathouse.gokul.Service.TicketService;
import com.boathouse.gokul.dto.BoatDTO;
import com.boathouse.gokul.dto.BoatTicketDTO;
import com.boathouse.gokul.dto.TicketDTO;

import io.micrometer.core.ipc.http.HttpSender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<TicketDTO> addTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO savedTicket = ticketService.createTicket(ticketDTO);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<TicketDTO>> getAllTicket() {
        List<TicketDTO> ticket = ticketService.getAllTicket();
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable("id") Long id) {
        TicketDTO ticketDTO = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticketDTO);
    }
    
    @GetMapping("/{type}/{date}")
    public ResponseEntity<List<BoatTicketDTO>> getTicketData(@PathVariable String type, @PathVariable String date) {
        
            return ResponseEntity.ok(ticketService.getTicketData(type, date));
        
    }
    
}
