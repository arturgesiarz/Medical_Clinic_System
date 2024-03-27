package com.clinic.medical.controller;

import com.clinic.medical.dto.RegisterRequest;
import com.clinic.medical.model.Address;
import com.clinic.medical.model.Patient;
import com.clinic.medical.model.TreatmentHistory;
import com.clinic.medical.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<String> addPatient(@RequestBody RegisterRequest registerRequest) {
        patientService.save(registerRequest);
        return new ResponseEntity<>("Patient was added successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/delete/{patientID}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientID) {
        patientService.delete(patientID);
        return new ResponseEntity<>("Patient was deleted successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/edit/{patientID}")
    public ResponseEntity<String> editPatient(@PathVariable Long patientID, @RequestBody RegisterRequest editRequest) {
        patientService.edit(patientID, editRequest);
        return new ResponseEntity<>("Patient was edited successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<Patient>> getAllPatients(){
        return ResponseEntity
                .status(OK)
                .body(patientService.getAllPatients());
    }

    @GetMapping("/show-user-details/{patientID}")
    public ResponseEntity<Patient> getPatientGeneral(@PathVariable Long patientID) {
        return ResponseEntity
                .status(OK)
                .body(patientService.getPatientGeneral(patientID));
    }
    @GetMapping("/show-address-details/{patientID}")
    public ResponseEntity<Address> getPatientAddress(@PathVariable Long patientID) {
        return ResponseEntity
                .status(OK)
                .body(patientService.getPatientAddress(patientID));
    }

    @GetMapping("/show-treatment-history-details/{patientID}")
    public ResponseEntity<List<TreatmentHistory>> getPatientTreatmentHistory(@PathVariable Long patientID) {
        return ResponseEntity
                .status(OK)
                .body(patientService.getPatientTreatmentHistory(patientID));
    }

}