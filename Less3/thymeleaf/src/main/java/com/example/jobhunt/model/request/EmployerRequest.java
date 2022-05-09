package com.example.jobhunt.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRequest {

    @NotEmpty(message = "Employer's name cannot be empty")
    private String name;


    @NotNull(message = "Employer's address cannot be null")
    private String address;

    @NotEmpty(message = "Employer's phone cannot be empty")
    private String phone;
}
