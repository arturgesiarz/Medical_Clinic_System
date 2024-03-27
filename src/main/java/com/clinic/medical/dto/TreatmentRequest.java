package com.clinic.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentRequest {
    private String treatmentName;
    private Long treatmentPrice;
}
