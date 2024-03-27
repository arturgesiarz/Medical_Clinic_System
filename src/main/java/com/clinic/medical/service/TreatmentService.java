package com.clinic.medical.service;

import com.clinic.medical.dto.TreatmentRequest;
import com.clinic.medical.exceptions.TreatmentNotFoundException;
import com.clinic.medical.model.Treatment;
import com.clinic.medical.repository.TreatmentRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;

    @Transactional
    public void add(TreatmentRequest treatmentRequest) {
        Treatment treatment = Treatment.builder()
                .treatmentName(treatmentRequest.getTreatmentName())
                .treatmentPrice(treatmentRequest.getTreatmentPrice()).build();

        treatmentRepository.save(treatment);
    }

    @Transactional
    public void delete(Long treatmentID) {
        Treatment treatment = treatmentRepository.findById(treatmentID)
                .orElseThrow(() -> new TreatmentNotFoundException(treatmentID));

        treatmentRepository.delete(treatment);
    }

    public List<Treatment> getAllTreatments() {
        return new ArrayList<>(treatmentRepository.findAll());
    }
    @Transactional
    public void assign(Long patientID, Long treatmentID) {
    }
}
