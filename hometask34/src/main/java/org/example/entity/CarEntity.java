package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.enums.Brand;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Enumerated(EnumType.STRING)
    Brand brand;
    Integer price;

    Integer mileage;
    Integer year;

    public CarEntity(Brand brand, Integer price, Integer mileage, Integer year) {
        this.brand = brand;
        this.price = price;
        this.mileage = mileage;
        this.year = year;
    }
}
