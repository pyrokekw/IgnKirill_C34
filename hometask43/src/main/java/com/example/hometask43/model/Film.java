package com.example.hometask43.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Film {
    private Long id;

    @NotBlank(message = "{validation.film.title.notblank}")
    @Size(min = 1, max = 100, message = "{validation.film.title.size}")
    private String title;

    @NotNull(message = "{validation.film.year.notnull}")
    @Min(value = 1895, message = "{validation.film.year.min}")
    private Integer year;

    @NotBlank(message = "{validation.film.director.notblank}")
    private String director;

}