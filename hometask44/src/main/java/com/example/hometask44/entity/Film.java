package com.example.hometask44.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "films")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    @Column(nullable = false, length = 100)
    private String title;

    @NotNull(message = "Year is required")
    @Min(value = 1895, message = "First film was made in 1895")
    @Column(nullable = false)
    private Integer year;

    @NotBlank(message = "Director is required")
    @Column(nullable = false, length = 100)
    private String director;
}
