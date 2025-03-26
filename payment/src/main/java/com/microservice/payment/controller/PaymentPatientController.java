package com.microservice.payment.controller;

import com.microservice.payment.model.dto.PaymentPatientDTO;
import com.microservice.payment.service.PatientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentPatientController {
    @Autowired
    private PatientPaymentService patientPaymentService;

    @GetMapping("/get-patient")
    public PaymentPatientDTO getPatientPaymentByPatientId(@RequestParam("transId") String transId) {
        return this.patientPaymentService.getPatient(transId);
    }
}
