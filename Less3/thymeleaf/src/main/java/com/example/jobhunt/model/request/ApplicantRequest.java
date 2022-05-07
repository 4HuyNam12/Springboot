package com.example.jobhunt.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantRequest {
    private String name;
    private int age;
    private String address;
    private String skills;
}
