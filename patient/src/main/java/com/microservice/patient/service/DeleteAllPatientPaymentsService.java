package com.microservice.patient.service;

import com.microservice.patient.proxy.ProxyPayment;
import com.microservice.patient.reposetory.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAllPatientPaymentsService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private ProxyPayment proxyPayment;

    public void deleteAllPatientPaymentsService(Long patientId) {
        this.patientRepo.deleteById(patientId);
        this.proxyPayment.deletePaymentsByPatientId(patientId);

    }
}
