package com.clinic.medical.repository;

import com.clinic.medical.model.City;
import com.clinic.medical.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByCity(String city);
}
