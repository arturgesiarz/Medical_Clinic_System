package com.clinic.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String pesel;
    private String street;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private String email;
}
