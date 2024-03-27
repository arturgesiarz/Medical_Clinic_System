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
                .created(Instant.now()).build();

        patientRepository.save(patient);
    }

    @Transactional
    public void delete(Long patientID) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        patientRepository.delete(patient);
    }
}
