package com.clinic.medical.service;
import com.clinic.medical.dto.RegisterRequest;
import com.clinic.medical.exceptions.PatientNotFoundException;
import com.clinic.medical.model.Patient;
import com.clinic.medical.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public void save(RegisterRequest registerRequest) {
        Patient patient = Patient.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .pesel(registerRequest.getPesel())
                .street(registerRequest.getStreet())
                .city(registerRequest.getCity())
                .zipCode(registerRequest.getZipCode())
                .phoneNumber(registerRequest.getPhoneNumber())
                .email(registerRequest.getEmail())
                .created(Instant.now())
                .lastModification(Instant.now()).build();

        patientRepository.save(patient);
    }

    @Transactional
    public void delete(Long patientID) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        patientRepository.delete(patient);
    }

    @Transactional
    public void edit(Long patientID, RegisterRequest editRequest) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        if (!editRequest.getLastName().isEmpty()) {
            patient.setLastName(editRequest.getLastName());
        }
        if (!editRequest.getFirstName().isEmpty()) {
            patient.setFirstName(editRequest.getFirstName());
        }
        if (!editRequest.getStreet().isEmpty()) {
            patient.setStreet(editRequest.getStreet());
        }
        if (!editRequest.getCity().isEmpty()) {
            patient.setCity(editRequest.getCity());
        }
        if (!editRequest.getZipCode().isEmpty()) {
            patient.setZipCode(editRequest.getZipCode());
        }
        if (!editRequest.getPhoneNumber().isEmpty()) {
            patient.setPhoneNumber(editRequest.getPhoneNumber());
        }
        if (!editRequest.getEmail().isEmpty()) {
            patient.setEmail(editRequest.getEmail());
        }
        patient.setLastModification(Instant.now());

    }
}
