package com.clinic.medical.service;

import com.clinic.medical.dto.TreatmentRequest;
import com.clinic.medical.exceptions.PatientNotFoundException;
import com.clinic.medical.exceptions.TreatmentHistoryNotFoundException;
import com.clinic.medical.exceptions.TreatmentNotFoundException;
import com.clinic.medical.model.Patient;
import com.clinic.medical.model.Treatment;
import com.clinic.medical.model.TreatmentHistory;
import com.clinic.medical.repository.PatientRepository;
import com.clinic.medical.repository.TreatmentHistoryRepository;
import com.clinic.medical.repository.TreatmentRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final TreatmentHistoryRepository treatmentHistoryRepository;
    private final PatientRepository patientRepository;

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
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        Treatment treatment = treatmentRepository.findById(treatmentID)
                .orElseThrow(() -> new TreatmentNotFoundException(treatmentID));

        TreatmentHistory treatmentHistory = TreatmentHistory.builder()
                .patient(patient)
                .treatment(treatment)
                .treatmentDate(Instant.now())
                .itTookPlace(false).build();

        treatmentHistoryRepository.save(treatmentHistory);
    }

    @Transactional
    public void tookPlace(Long patientID, Long treatmentID) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        Treatment treatment = treatmentRepository.findById(treatmentID)
                .orElseThrow(() -> new TreatmentNotFoundException(treatmentID));

        TreatmentHistory treatmentHistory = treatmentHistoryRepository
                .findByPatientAndTreatment(patient, treatment)
                .orElseThrow(() -> new TreatmentHistoryNotFoundException(patientID, treatmentID));

        treatmentHistory.setItTookPlace(true);
    }
}
