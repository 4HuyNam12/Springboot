package com.example.jobhunt.repository;

import com.example.jobhunt.model.Employer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class EmployerRepository {
    private static final ConcurrentHashMap<String, Employer> employers = new ConcurrentHashMap<>();

    static {
        employers.put("1", new Employer("1", "TechMaster", "Hà Nội", "0123456789"));
        employers.put("2", new Employer("2", "HaHa", "Đà Nẵng", "0123456459"));
        employers.put("3", new Employer("3", "HiHi", "TP HCM", "0123456231"));
        employers.put("4", new Employer("4", "HeHe", "Hà Nội", "0123473289"));
    }


    public List<Employer> getListOfEmployers() {
        return employers.values().stream().collect(Collectors.toList());
    }

    public void addEmployer(Employer employee) {
        employers.put(employee.getId(), employee);
    }
}
