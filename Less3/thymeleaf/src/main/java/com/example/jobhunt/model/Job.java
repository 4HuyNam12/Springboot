package com.example.jobhunt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String id;
    private String employerName;
    private String jobTitle;
    private String jobDescription;
    private int salary;
}
