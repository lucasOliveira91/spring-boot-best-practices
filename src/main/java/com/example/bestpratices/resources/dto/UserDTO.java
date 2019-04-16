package com.example.bestpratices.resources.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ApiModel(description = "All details about the user")
public class UserDTO {

    @Size(min = 2, message = "Name sould have at least 2 caracters.")
    @ApiModelProperty(notes = "Name sould have at least 2 caracters.")
    private String name;

    @Past
    @ApiModelProperty(notes = "Bith date should be in the past")
    private Date bithday;
}
