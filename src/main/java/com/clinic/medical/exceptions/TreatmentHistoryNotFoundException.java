package com.clinic.medical.exceptions;
public class TreatmentHistoryNotFoundException extends RuntimeException {
    public TreatmentHistoryNotFoundException(Long patientID, Long treatmentID){
        super("History not found by patient with ID: " + patientID + ", and treatment with ID: " + treatmentID);

    }
}
