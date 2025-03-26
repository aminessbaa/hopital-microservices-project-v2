package com.microservice.payment.service;

import com.microservice.payment.model.dto.PatientDTO;
import com.microservice.payment.model.dto.PaymentDTO;
import com.microservice.payment.model.dto.PaymentPatientDTO;
import com.microservice.payment.model.entity.Payment;
import com.microservice.payment.proxy.ProxyPatient;
import com.microservice.payment.repo.PaymentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.jayway.jsonpath.Configuration.builder;

@Service
@Slf4j
public class PatientPaymentService {
    @Autowired
    private ProxyPatient proxyPatient;
    @Autowired
    private PaymentRepo paymentRepo;

    public PaymentPatientDTO getPatient(String transId) {
        Optional<Payment> payment=this.paymentRepo.findByTransId(transId);
        PatientDTO patientDTO=proxyPatient.getPatient(payment.get().getPatientId());

        PaymentDTO paymentDTO=PaymentDTO.builder()
                .id(payment.get().getId())
                .transId(payment.get().getTransId())
                .amount(payment.get().getAmount())
                .patientId(payment.get().getPatientId())
                .build();

        log.info(patientDTO.toString());
        log.info(payment.toString());

         return PaymentPatientDTO.builder()
                 .id(patientDTO.getId())
                 .transId(paymentDTO.getTransId())
                 .amount(paymentDTO.getAmount())
                 .patientId(paymentDTO.getPatientId())
                 .patientDTO(patientDTO)
                 .build();

    }
}
