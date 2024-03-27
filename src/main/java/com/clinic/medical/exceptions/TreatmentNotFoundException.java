package com.clinic.medical.exceptions;

public class TreatmentNotFoundException extends RuntimeException {

    public TreatmentNotFoundException(Long treatmentID){
        super("Treatment with ID: " + treatmentID + ", was not found");

    }
}
