package org.spring.web.model;

import lombok.Data;

@Data
public class UserForm {

    private String username;
    private Integer age;
    private String role = "USER";
}