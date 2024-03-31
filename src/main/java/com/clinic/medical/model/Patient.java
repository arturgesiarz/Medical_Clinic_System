package com.clinic.medical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.EAGER;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientID;
    private String firstName;
    private String lastName;
    private String pesel;
    private String phoneNumber;
    private String email;
}