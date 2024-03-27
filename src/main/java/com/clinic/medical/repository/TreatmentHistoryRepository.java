package com.clinic.medical.repository;

import com.clinic.medical.model.Address;
import com.clinic.medical.model.Patient;
import com.clinic.medical.model.Treatment;
import com.clinic.medical.model.TreatmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TreatmentHistoryRepository extends JpaRepository<TreatmentHistory, Long> {
    Optional<List<TreatmentHistory>> findByPatient(Patient patient);
    Optional<TreatmentHistory> findByPatientAndTreatment(Patient patient, Treatment treatment);
}
