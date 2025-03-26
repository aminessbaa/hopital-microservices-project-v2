package com.microservice.patient.controller;

import com.microservice.patient.service.DeleteAllPatientPaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAllPatientPaymentsController {
    @Autowired
    private DeleteAllPatientPaymentsService deleteAllPatientPaymentsService;


    @DeleteMapping("/delete-payments-by-patient-id")
    public void deletePaymentsByPatientId(@RequestParam Long patientId) {
        this.deleteAllPatientPaymentsService.deleteAllPatientPaymentsService(patientId);
    }
}
