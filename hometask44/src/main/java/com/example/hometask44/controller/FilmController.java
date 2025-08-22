package com.example.hometask44.controller;

import com.example.hometask44.entity.Film;
import com.example.hometask44.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmRepository filmRepository;

    @GetMapping
    public String showFilms(@RequestParam(value = "search", required = false) String searchTitle,
                            Model model) {

        List<Film> films;
        String searchResult = null;

        if (searchTitle != null && !searchTitle.trim().isEmpty()) {
            Optional<Film> foundFilm = filmRepository.findByTitle(searchTitle.trim());
            if (foundFilm.isPresent()) {
                films = List.of(foundFilm.get());
                searchResult = "Найден 1 фильм";
            } else {
                films = filmRepository.findAll();
                searchResult = "Фильм с названием '" + searchTitle + "' не найден";
            }
        } else {
            films = filmRepository.findAll();
        }

        model.addAttribute("films", films);
        model.addAttribute("newFilm", new Film());
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchResult", searchResult);
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
