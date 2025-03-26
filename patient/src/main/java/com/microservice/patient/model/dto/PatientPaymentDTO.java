package com.microservice.patient.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientPaymentDTO {
    private Long id;
    private String patientName;
    private Integer patientAge;
    private List<PaymentDTO> paymentDTOS;
}
