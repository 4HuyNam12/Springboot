package com.example.jobhunt.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobRequest {
    @NotEmpty(message = "Employer's name cannot be empty")
    private String employerName;

    private String jobTitle;

    private String jobDescription;

    @Min(value = 100, message = "Salary must be above 100$")
    private int salary;
}
