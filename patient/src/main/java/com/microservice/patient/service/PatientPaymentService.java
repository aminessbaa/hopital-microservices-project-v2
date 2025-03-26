package com.microservice.patient.service;

import com.microservice.patient.model.dto.ListPaymentPatientDTO;
import com.microservice.patient.model.dto.PatientDTO;
import com.microservice.patient.model.dto.PaymentDTO;
import com.microservice.patient.model.entity.Patient;

import com.microservice.patient.proxy.ProxyPayment;
import com.microservice.patient.reposetory.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@Slf4j
public class PatientPaymentService{

    @Autowired
    private ProxyPayment proxyPayment;

    @Autowired
    private PatientRepo patientRepo;



    public List<PaymentDTO> getPatientPayments(Long patientId){
        return this.proxyPayment.getPatientPayments(patientId);
    }

    public ListPaymentPatientDTO getAllPatientPaymentsById(Long patientId) {
        Optional<Patient> patient = this.patientRepo.findById(patientId);
        PatientDTO patientDTO = PatientDTO.builder()
                .id(patient.get().getId())
                .patientName(patient.get().getPatientName())
                .patientAge(patient.get().getPatientAge())
                .build();

            List<PaymentDTO> payments = this.proxyPayment.getPatientPayments(patientId);

            return ListPaymentPatientDTO.builder()
                .id(patientDTO.getId())
                .patientName(patientDTO.getPatientName())
                .patientAge(patientDTO.getPatientAge())
                .paymentDTOList(payments)
                .build();

    }
}
