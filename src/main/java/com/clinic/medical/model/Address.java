package com.clinic.medical.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;
    @OneToOne( fetch = EAGER )
    @JoinColumn( name = "patientID", referencedColumnName = "patientID" )
    private Patient patient;

    @ManyToOne( fetch = EAGER )
    @JoinColumn( name = "countryID", referencedColumnName = "countryID" )
    private Country country;

    @ManyToOne( fetch = EAGER )
    @JoinColumn( name = "cityID", referencedColumnName = "cityID" )
    private City city;

    @ManyToOne( fetch = EAGER )
    @JoinColumn( name = "voivodeshipID", referencedColumnName = "voivodeshipID" )
    private Voivodeship voivodeship;

    private String zipCode;
    private String street;
    private Integer flatNumber;

}
