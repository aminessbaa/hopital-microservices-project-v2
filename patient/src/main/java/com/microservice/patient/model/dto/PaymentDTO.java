package com.microservice.patient.model.dto;

import lombok.*;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private String transId;
    private Double amount;
    private Long patientId;
}
