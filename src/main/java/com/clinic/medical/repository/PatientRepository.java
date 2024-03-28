package com.clinic.medical.repository;

import com.clinic.medical.model.Country;
import com.clinic.medical.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<List<Patient>> findByFirstNameStartingWith(String firstName);
    Optional<List<Patient>> findByLastNameStartingWith(String lastName);
    Optional<List<Patient>> findByFirstNameAndLastName(String firstName,String lastName);
}
