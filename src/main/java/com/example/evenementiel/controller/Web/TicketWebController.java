package com.example.evenementiel.controller;

import com.example.evenementiel.model.Ticket;
import com.example.evenementiel.repository.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketWebController {

    private final TicketRepository ticketRepository;

    public TicketWebController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // 🎟️ Afficher tous les tickets
    @GetMapping
    public String afficherTickets(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets"; // correspond au fichier templates/tickets.html
    }
}
