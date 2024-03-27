package com.clinic.medical.repository;

import com.clinic.medical.model.Address;
import com.clinic.medical.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
