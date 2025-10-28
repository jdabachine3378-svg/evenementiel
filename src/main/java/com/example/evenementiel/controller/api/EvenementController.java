package com.example.evenementiel.controller;

import com.example.evenementiel.model.Evenement;
import com.example.evenementiel.repository.EvenementRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/evenements")
public class EvenementController {

    private final EvenementRepository evenementRepository;

    public EvenementController(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    // ➕ Ajouter un événement
    @PostMapping
    public Evenement createEvenement(@RequestBody Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    // 📋 Lister tous les événements
    @GetMapping
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    // 🔎 Filtrer par ville
    @GetMapping("/ville/{ville}")
    public List<Evenement> getByVille(@PathVariable String ville) {
        return evenementRepository.findByVille(ville);
    }

    // 🔎 Filtrer par type
    @GetMapping("/type/{type}")
    public List<Evenement> getByType(@PathVariable String type) {
        return evenementRepository.findByType(type);
    }

    // 🔎 Filtrer par date (format : yyyy-MM-dd)
    @GetMapping("/date/{date}")
    public List<Evenement> getByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return evenementRepository.findByDate(localDate);
    }
}
