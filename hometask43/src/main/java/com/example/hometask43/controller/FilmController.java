package com.example.hometask43.controller;

import com.example.hometask43.model.Film;
import com.example.hometask43.repository.FilmRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmController {
    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping
    public String showFilms(Model model) {
        model.addAttribute("films", filmRepository.findAll());
        model.addAttribute("newFilm", new Film());
        return "films";
    }

    @PostMapping
    public String addFilm(@ModelAttribute("newFilm") Film film,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("films", filmRepository.findAll());
            return "films";
        }
        filmRepository.save(film);
        return "redirect:/films";
    }

    @PostMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
        return "redirect:/films";
    }
}