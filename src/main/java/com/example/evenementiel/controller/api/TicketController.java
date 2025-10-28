package com.example.evenementiel.controller;

import com.example.evenementiel.model.Ticket;
import com.example.evenementiel.model.TicketKey;
import com.example.evenementiel.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // ➕ Ajouter un ticket
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // 📋 Lister tous les tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // 🔎 Filtrer par statut
    @GetMapping("/statut/{statut}")
    public List<Ticket> getByStatut(@PathVariable String statut) {
        return ticketRepository.findByStatut(statut);
    }
}
