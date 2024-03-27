package com.clinic.medical.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "patientID", referencedColumnName = "patientID" )
    private Patient patient;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "countryID", referencedColumnName = "countryID" )
    private Country country;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "cityID", referencedColumnName = "cityID" )
    private City city;

    @ManyToOne( fetch = LAZY )
    @JoinColumn( name = "voivodeshipID", referencedColumnName = "voivodeshipID" )
    private Voivodeship voivodeship;

    private String zipCode;
    private String street;
    private Integer flatNumber;

}
