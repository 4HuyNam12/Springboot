package com.example.jobhunt.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    private String id;
    private String name;
    private int age;
    private String address;
    private String skills;
}
