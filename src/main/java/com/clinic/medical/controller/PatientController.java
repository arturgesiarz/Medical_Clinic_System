package com.clinic.medical.controller;

import com.clinic.medical.dto.RegisterRequest;
import com.clinic.medical.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<String> addPatient(@RequestBody RegisterRequest registerRequest) {
        patientService.save(registerRequest);
        return new ResponseEntity<>("Patient was added successfully!", HttpStatus.CREATED);
    }

}
