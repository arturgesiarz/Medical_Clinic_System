package com.clinic.medical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TreatmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treatmentHistoryID;
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "patientID", referencedColumnName = "patientID" )
    private Patient patient;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "treatmentID", referencedColumnName = "treatmentID" )
    private Treatment treatment;

    private Instant treatmentDate;
    private boolean itTookPlace;

}