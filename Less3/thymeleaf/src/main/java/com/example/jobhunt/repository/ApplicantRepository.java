package com.example.jobhunt.repository;

import com.example.jobhunt.model.entity.Applicant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class ApplicantRepository {
    private static ConcurrentHashMap<String, Applicant> applicants = new ConcurrentHashMap<>();

    static {
        applicants.put("1", new Applicant("1", "Nguyễn Văn A", 20, "Hà Nội", "html,css,js"));
        applicants.put("2", new Applicant("2", "Nguyễn Văn B", 19, "Hải Phòng", "hihi,hehe"));
        applicants.put("3", new Applicant("3", "Nguyễn Văn C", 18, "Lào Cai", "java,spring boot"));
        applicants.put("4", new Applicant("4", "Nguyễn Thị D", 21, "Quảng Ninh", "react"));
        applicants.put("5", new Applicant("5", "Nguyễn Thị F", 22, "Vũng Tàu", "node.js"));
    }

    public List<Applicant> getListOfApplicants() {
        return applicants.values().stream().collect(Collectors.toList());
    }

    public void addNewApplicant(Applicant newApplicant) {
        applicants.put(newApplicant.getId(), newApplicant);
    }
}
