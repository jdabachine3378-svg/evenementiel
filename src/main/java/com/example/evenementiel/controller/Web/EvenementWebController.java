package com.example.evenementiel.controller;

import com.example.evenementiel.model.Evenement;
import com.example.evenementiel.repository.EvenementRepository;
import com.example.evenementiel.repository.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/evenements")
public class EvenementWebController {

    private final EvenementRepository evenementRepository;
    private final TicketRepository ticketRepository;

    public EvenementWebController(EvenementRepository evenementRepository, TicketRepository ticketRepository) {
        this.evenementRepository = evenementRepository;
        this.ticketRepository = ticketRepository;
    }

    // 🏠 Page principale : affiche tous les événements
    @GetMapping
    public String afficherEvenements(Model model) {
        List<Evenement> evenements = evenementRepository.findAll();

        long totalTickets = ticketRepository.count();
        long confirmes = ticketRepository.findByStatut("confirmé").size();
        double tauxPresence = totalTickets > 0 ? ((double) confirmes / totalTickets) * 100 : 0;

        model.addAttribute("evenements", evenements);
        model.addAttribute("stats", "Taux de présence : " + String.format("%.2f", tauxPresence) + "%");

        return "evenements";
    }

    // 🔎 Filtrage
    @GetMapping("/filtrer")
    public String filtrer(@RequestParam(required = false) String ville,
                          @RequestParam(required = false) String type,
                          @RequestParam(required = false) String date,
                          Model model) {
        List<Evenement> evenements = evenementRepository.findAll();

        if (ville != null && !ville.isEmpty())
            evenements = evenements.stream().filter(e -> e.getVille().equalsIgnoreCase(ville)).toList();

        if (type != null && !type.isEmpty())
            evenements = evenements.stream().filter(e -> e.getType().equalsIgnoreCase(type)).toList();

        if (date != null && !date.isEmpty())
            evenements = evenements.stream().filter(e -> e.getDate().equals(LocalDate.parse(date))).toList();

        model.addAttribute("evenements", evenements);
        model.addAttribute("stats", "Résultats filtrés : " + evenements.size());

        return "evenements";
    }
}
