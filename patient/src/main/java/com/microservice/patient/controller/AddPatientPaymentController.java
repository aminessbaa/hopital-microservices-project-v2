package com.microservice.patient.controller;

import com.microservice.patient.model.dto.AddPatientPaymentDTO;
import com.microservice.patient.model.dto.PatientPaymentDTO;
import com.microservice.patient.service.AddPatientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddPatientPaymentController {

    @Autowired
    private AddPatientPaymentService addPatientPaymentService;

    @PostMapping("/add-patient-payment")
    public PatientPaymentDTO save(@RequestBody AddPatientPaymentDTO dto) {
        return addPatientPaymentService.savePatientPayment(dto);
    }

}
