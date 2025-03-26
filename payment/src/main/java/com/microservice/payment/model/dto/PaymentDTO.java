package com.microservice.payment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private String transId;
    private Double amount;
    private Long patientId;
}
