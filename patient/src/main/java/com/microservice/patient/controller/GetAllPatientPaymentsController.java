package com.microservice.patient.controller;

import com.microservice.patient.model.dto.ListPaymentPatientDTO;
import com.microservice.patient.service.PatientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class GetAllPatientPaymentsController {
    @Autowired
    private PatientPaymentService patientPaymentService;


    @GetMapping("/get-all-patient-payments-by-id")
    public ListPaymentPatientDTO getAllPatientPaymentsById(@RequestParam("patientId") Long patientId) {
        return patientPaymentService.getAllPatientPaymentsById(patientId);
    }

}
