package com.example.jobhunt.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employer {
    private String id;
    private String name;
    private String address;
    private String phone;
}
