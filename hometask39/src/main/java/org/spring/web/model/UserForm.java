package org.spring.web.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

    @NotBlank(message = "Cannot be blank")
    private String name;

    @NotBlank(message = "Cannot be blank")
    @Email(message = "Wrong email style")
    private String email;

    @NotNull(message = "Cannot be null")
    @Min(value = 18, message = "from 18")
    @Max(value = 100, message = "to 100")
    private Integer age;

}