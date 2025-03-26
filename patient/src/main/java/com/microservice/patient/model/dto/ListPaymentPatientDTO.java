package com.microservice.patient.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListPaymentPatientDTO {
    private Long id;
    private String patientName;
    private Integer patientAge;
    private List<PaymentDTO> paymentDTOList;
}
