package com.clinic.medical.service;
import com.clinic.medical.dto.RegisterRequest;
import com.clinic.medical.exceptions.PatientNotFoundException;
import com.clinic.medical.model.*;
import com.clinic.medical.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final PatientRepository patientRepository;
    private final VoivodeshipRepository voivodeshipRepository;

    @Transactional
    public void save(RegisterRequest registerRequest) {
        Patient patient = Patient.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .pesel(registerRequest.getPesel())
                .phoneNumber(registerRequest.getPhoneNumber())
                .email(registerRequest.getEmail()).build();

        Address address = new Address();

        address.setPatient(patient);

        // country added to address
        Optional<Country> country = countryRepository.findByCountry(registerRequest.getCountry());
        if (country.isPresent()) {
            address.setCountry(country.get());
        } else {
            Country newCountry = Country.builder().country(registerRequest.getCountry()).build();
            countryRepository.save(newCountry);
            address.setCountry(newCountry);
        }

        // city added to address
        Optional<City> city = cityRepository.findByCity(registerRequest.getCity());
        if (city.isPresent()) {
            address.setCity(city.get());
        } else {
            City newCity = City.builder().city(registerRequest.getCity()).build();
            cityRepository.save(newCity);
            address.setCity(newCity);
        }

        // voivodeship added to address
        Optional<Voivodeship> voivodeship = voivodeshipRepository.findByVoivodeship(registerRequest.getVoivodeship());
        if (voivodeship.isPresent()) {
            address.setVoivodeship(voivodeship.get());
        } else {
            Voivodeship newVoivodeship = Voivodeship.builder().voivodeship(registerRequest.getVoivodeship()).build();
            voivodeshipRepository.save(newVoivodeship);
            address.setVoivodeship(newVoivodeship);
        }

        address.setZipCode(registerRequest.getZipCode());
        address.setStreet(registerRequest.getStreet());
        address.setFlatNumber(registerRequest.getFlatNumber());

        addressRepository.save(address);
        patientRepository.save(patient);
    }

    @Transactional
    public void delete(Long patientID) {
//        Patient patient = patientRepository.findById(patientID)
//                .orElseThrow(() -> new PatientNotFoundException(patientID));
//
//        patientRepository.delete(patient);
    }

    @Transactional
    public void edit(Long patientID, RegisterRequest editRequest) {
//        Patient patient = patientRepository.findById(patientID)
//                .orElseThrow(() -> new PatientNotFoundException(patientID));
//
//        if (!editRequest.getLastName().isEmpty()) {
//            patient.setLastName(editRequest.getLastName());
//        }
//        if (!editRequest.getFirstName().isEmpty()) {
//            patient.setFirstName(editRequest.getFirstName());
//        }
//        if (!editRequest.getStreet().isEmpty()) {
//            patient.setStreet(editRequest.getStreet());
//        }
//        if (!editRequest.getCity().isEmpty()) {
//            patient.setCity(editRequest.getCity());
//        }
//        if (!editRequest.getZipCode().isEmpty()) {
//            patient.setZipCode(editRequest.getZipCode());
//        }
//        if (!editRequest.getPhoneNumber().isEmpty()) {
//            patient.setPhoneNumber(editRequest.getPhoneNumber());
//        }
//        if (!editRequest.getEmail().isEmpty()) {
//            patient.setEmail(editRequest.getEmail());
//        }
//        patient.setLastModification(Instant.now());

    }
}
