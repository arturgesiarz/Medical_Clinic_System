package com.clinic.medical.controller;

import com.clinic.medical.model.City;
import com.clinic.medical.model.Country;
import com.clinic.medical.model.Voivodeship;
import com.clinic.medical.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/country/{countryID}")
    public ResponseEntity<Country> getCountry(@PathVariable Long countryID) {
        return ResponseEntity
                .status(OK)
                .body(addressService.getCountry(countryID));
    }

    @GetMapping("/city/{cityID}")
    public ResponseEntity<City> getCity(@PathVariable Long cityID) {
        return ResponseEntity
                .status(OK)
                .body(addressService.getCity(cityID));
    }

    @GetMapping("/voivodeship/{voivodeshipID}")
    public ResponseEntity<Voivodeship> getVoivodeship(@PathVariable Long voivodeshipID) {
        return ResponseEntity
                .status(OK)
                .body(addressService.getVoivodeship(voivodeshipID));
    }
}
