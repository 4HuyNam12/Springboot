package com.example.jobhunt.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ApplicantRequest {
    @NotEmpty(message = "Applicant's name cannot be empty")
    private String name;

    @NotNull(message = "Applicant's age cannot be null")
    @Min(value = 18, message = "Applicant's age must be more than 18")
    private int age;

    @NotNull(message = "Applicant's address cannot be null")
    private String address;
    @NotEmpty(message = "Applicant's skills cannot be empty")
    private String skills;
}
