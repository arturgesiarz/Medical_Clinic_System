package com.clinic.medical.repository;

import com.clinic.medical.model.City;
import com.clinic.medical.model.Voivodeship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoivodeshipRepository extends JpaRepository<Voivodeship, Long> {
    Optional<Voivodeship> findByVoivodeship(String voivodeship);
}
