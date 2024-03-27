package com.clinic.medical.controller;

import com.clinic.medical.dto.TreatmentRequest;
import com.clinic.medical.model.Treatment;
import com.clinic.medical.service.TreatmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/treatment")
@AllArgsConstructor
public class TreatmentController {
    private final TreatmentService treatmentService;

    @PostMapping("/add")
    public ResponseEntity<String> addTreatment(@RequestBody TreatmentRequest treatmentRequest) {
        treatmentService.add(treatmentRequest);
        return new ResponseEntity<>("Treatment was added successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/delete/{treatmentID}")
    public ResponseEntity<String> deleteTreatment(@PathVariable Long treatmentID) {
        treatmentService.delete(treatmentID);
        return new ResponseEntity<>("Treatment was deleted successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/assign-patient-to-treatment/{patientID}/{treatmentID}")
    public ResponseEntity<String> assignToTreatment(@PathVariable Long patientID, @PathVariable Long treatmentID) {
        treatmentService.assign(patientID, treatmentID);
        return new ResponseEntity<>("The patient has been successfully enrolled!", HttpStatus.CREATED);
    }

    @PostMapping("/took-place-treatment/{patientID}/{treatmentID}")
    public ResponseEntity<String> tookPlaceTreatment(@PathVariable Long patientID, @PathVariable Long treatmentID) {
        treatmentService.tookPlace(patientID, treatmentID);
        return new ResponseEntity<>("The patient has been successfully took placed treatment", HttpStatus.CREATED);
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<Treatment>> getAllTreatments(){
        return ResponseEntity
                .status(OK)
                .body(treatmentService.getAllTreatments());
    }





}
