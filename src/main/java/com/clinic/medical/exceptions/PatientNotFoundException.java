package com.clinic.medical.exceptions;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(Long patientID){
        super("Patient with ID: " + patientID + ", was not found");

    }
}
