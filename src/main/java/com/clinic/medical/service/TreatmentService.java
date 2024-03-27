package com.clinic.medical.service;

import com.clinic.medical.dto.TreatmentRequest;
import com.clinic.medical.model.Treatment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TreatmentService {
    public void add(TreatmentRequest treatmentRequest) {
    }

    public void delete(Long patientID) {
    }

    public List<Treatment> getAllTreatments() {
        return null;
    }

    public void assign(Long patientID, Long treatmentID) {
    }
}
