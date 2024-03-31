package com.clinic.medical.service;

import com.clinic.medical.model.City;
import com.clinic.medical.model.Country;
import com.clinic.medical.model.Voivodeship;
import com.clinic.medical.repository.CityRepository;
import com.clinic.medical.repository.CountryRepository;
import com.clinic.medical.repository.VoivodeshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final VoivodeshipRepository voivodeshipRepository;

    public Country getCountry(Long countryID) {
        return countryRepository.findById(countryID)
                .orElseThrow(RuntimeException::new);
    }

    public City getCity(Long cityID) {
        return cityRepository.findById(cityID)
                .orElseThrow(RuntimeException::new);
    }

    public Voivodeship getVoivodeship(Long voivodeshipID) {
        return voivodeshipRepository.findById(voivodeshipID)
                .orElseThrow(RuntimeException::new);
    }
}
