package com.example.hometask43.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.hometask43.model.Film;
import org.springframework.stereotype.Repository;

@Repository
public class FilmRepository {
    private final List<Film> films = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Film> findAll() {
        return new ArrayList<>(films);
    }

    public void save(Film film) {
        if (film.getId() == null) {
            film.setId(counter.incrementAndGet());
            films.add(film);
        }
    }

    public void deleteById(Long id) {
        films.removeIf(f -> f.getId().equals(id));
    }
}