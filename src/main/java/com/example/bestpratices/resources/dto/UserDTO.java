package com.example.bestpratices.resources.dto;

import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserDTO {

    @Size(min = 2, message = "Name sould have at least 2 caracters.")
    private String name;

    @Past
    private Date bithday;
}
