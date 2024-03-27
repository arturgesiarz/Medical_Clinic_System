package com.clinic.medical.repository;

import com.clinic.medical.model.Address;
import com.clinic.medical.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByPatient(Patient patient);
}
