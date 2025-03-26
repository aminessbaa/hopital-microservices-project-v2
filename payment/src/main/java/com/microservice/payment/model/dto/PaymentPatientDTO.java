package com.microservice.payment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPatientDTO {
    private Long id;
    private String transId;
    private Double amount;
    private Long patientId;
    private PatientDTO patientDTO;
}
