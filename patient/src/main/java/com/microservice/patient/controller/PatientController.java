package com.microservice.patient.controller;

import com.microservice.patient.model.dto.*;
import com.microservice.patient.proxy.ProxyPayment;
import com.microservice.patient.service.PatientPaymentService;
import com.microservice.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientPaymentService patientPaymentService;

    @Autowired
    private ProxyPayment proxyPayment;

    @PostMapping("/add-patient")
    public AddPatientDTO save(@RequestBody AddPatientDTO dto) {
        return patientService.savePatient(dto);
    }

    @PutMapping("/update-patient")
    public PatientDTO update(@RequestBody UpdatePatientDTO dto) {
        return patientService.updatePatient(dto);
    }

    @DeleteMapping("/delete-patient")
    public void update(@RequestParam Long id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/get-patient")
    public PatientDTO getPatient(@RequestParam Long id) {
        return patientService.getPatient(id);
    }

    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestParam("patientId") Long patientId) {
        return patientPaymentService.getPatientPayments(patientId);
    }


}