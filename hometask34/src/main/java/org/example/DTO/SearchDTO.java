package org.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.entity.enums.Brand;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO {

    Brand brand;
    Integer fromPrice;
    Integer toPrice;
    Integer formMileage;
    Integer toMileage;
    Integer fromYear;
}
