package com.clinic.medical.controller;

import com.clinic.medical.dto.RegisterRequest;
import com.clinic.medical.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete/account/{patientID}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientID) {
        patientService.delete(patientID);
        return new ResponseEntity<>("Patient was deleted successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/edit/account/{patientID}")
    public ResponseEntity<String> editPatient(@PathVariable Long patientID, @RequestBody RegisterRequest editRequest) {
        patientService.edit(patientID, editRequest);
        return new ResponseEntity<>("Patient was edited successfully!", HttpStatus.CREATED);
    }

}
