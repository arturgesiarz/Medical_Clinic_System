package com.clinic.medical.service;

import com.clinic.medical.dto.TreatmentRequest;
import com.clinic.medical.model.Treatment;
import com.clinic.medical.repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;

    public void add(TreatmentRequest treatmentRequest) {
        Treatment treatment = Treatment.builder()
                .treatmentName(treatmentRequest.getTreatmentName())
                .treatmentPrice(treatmentRequest.getTreatmentPrice()).build();

        treatmentRepository.save(treatment);
    }

    public void delete(Long patientID) {
    }

    public List<Treatment> getAllTreatments() {
        return null;
    }

    public void assign(Long patientID, Long treatmentID) {
    }
}
