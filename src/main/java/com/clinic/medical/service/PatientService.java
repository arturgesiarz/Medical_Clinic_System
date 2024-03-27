package com.clinic.medical.service;
import com.clinic.medical.dto.RegisterRequest;
import com.clinic.medical.exceptions.PatientNotFoundException;
import com.clinic.medical.model.*;
import com.clinic.medical.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final PatientRepository patientRepository;
    private final VoivodeshipRepository voivodeshipRepository;
    private final TreatmentHistoryRepository treatmentHistoryRepository;

    @Transactional
    public void save(RegisterRequest registerRequest) {
        Patient patient = Patient.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .pesel(registerRequest.getPesel())
                .phoneNumber(registerRequest.getPhoneNumber())
                .email(registerRequest.getEmail()).build();

        Address address = new Address();
        addedAddress(registerRequest, patient, address);

        addressRepository.save(address);
        patientRepository.save(patient);
    }

    private void addedAddress(RegisterRequest registerRequest, Patient patient, Address address) {
        address.setPatient(patient);

        // country added to address
        addedCountryToAddress(registerRequest, address);

        // city added to address
        addedCityToAddress(registerRequest, address);

        // voivodeship added to address
        addedVoivodeshipToAddress(registerRequest, address);

        address.setZipCode(registerRequest.getZipCode());
        address.setStreet(registerRequest.getStreet());
        address.setFlatNumber(registerRequest.getFlatNumber());
    }

    private void addedVoivodeshipToAddress(RegisterRequest registerRequest, Address address) {
        Optional<Voivodeship> voivodeship = voivodeshipRepository.findByVoivodeship(registerRequest.getVoivodeship());
        if (voivodeship.isPresent()) {
            address.setVoivodeship(voivodeship.get());
        } else {
            Voivodeship newVoivodeship = Voivodeship.builder().voivodeship(registerRequest.getVoivodeship()).build();
            voivodeshipRepository.save(newVoivodeship);
            address.setVoivodeship(newVoivodeship);
        }
    }

    private void addedCityToAddress(RegisterRequest registerRequest, Address address) {
        Optional<City> city = cityRepository.findByCity(registerRequest.getCity());
        if (city.isPresent()) {
            address.setCity(city.get());
        } else {
            City newCity = City.builder().city(registerRequest.getCity()).build();
            cityRepository.save(newCity);
            address.setCity(newCity);
        }
    }

    private void addedCountryToAddress(RegisterRequest registerRequest, Address address) {
        Optional<Country> country = countryRepository.findByCountry(registerRequest.getCountry());
        if (country.isPresent()) {
            address.setCountry(country.get());
        } else {
            Country newCountry = Country.builder().country(registerRequest.getCountry()).build();
            countryRepository.save(newCountry);
            address.setCountry(newCountry);
        }
    }

    @Transactional
    public void delete(Long patientID) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        Optional<Address> address = addressRepository.findByPatient(patient);
        Optional<List<TreatmentHistory>> treatmentHistoryList = treatmentHistoryRepository.findByPatient(patient);

        if (treatmentHistoryList.isPresent()) {
            treatmentHistoryRepository.deleteAll(treatmentHistoryList.get());
        }
        if (address.isPresent()) {
            addressRepository.delete(address.get());
        }
        patientRepository.delete(patient);
    }

    @Transactional
    public void edit(Long patientID, RegisterRequest editRequest) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));


        // change in basic information
        if (!editRequest.getLastName().isEmpty()) {
            patient.setLastName(editRequest.getLastName());
        }
        if (!editRequest.getFirstName().isEmpty()) {
            patient.setFirstName(editRequest.getFirstName());
        }
        if (!editRequest.getPhoneNumber().isEmpty()) {
            patient.setPhoneNumber(editRequest.getPhoneNumber());
        }
        if (!editRequest.getEmail().isEmpty()) {
            patient.setEmail(editRequest.getEmail());
        }

        // change address
        Optional<Address> address = addressRepository.findByPatient(patient);
        if (address.isPresent()) {
            addedAddress(editRequest, patient, address.get());
        }

    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientRepository.findAll());
    }

    public Patient getPatientGeneral(Long patientID) {
        return patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));
    }

    public Address getPatientAddress(Long patientID) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        return addressRepository.findByPatient(patient)
                .orElseThrow(RuntimeException::new);
    }

    public List<TreatmentHistory> getPatientTreatmentHistory(Long patientID) {
        Patient patient = patientRepository.findById(patientID)
                .orElseThrow(() -> new PatientNotFoundException(patientID));

        return treatmentHistoryRepository.findByPatient(patient)
                .orElseThrow(() -> new PatientNotFoundException(patientID));
    }
}
