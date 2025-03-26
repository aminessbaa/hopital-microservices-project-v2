package com.microservice.patient.service;

import com.microservice.patient.model.dto.AddPatientPaymentDTO;
import com.microservice.patient.model.dto.AddPaymentDTO;
import com.microservice.patient.model.dto.PatientPaymentDTO;
import com.microservice.patient.model.dto.PaymentDTO;
import com.microservice.patient.model.entity.Patient;
import com.microservice.patient.proxy.ProxyPayment;
import com.microservice.patient.reposetory.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddPatientPaymentService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private ProxyPayment proxyPayment;


    public PatientPaymentDTO savePatientPayment(AddPatientPaymentDTO dto) {
//        Patient patient=this.patientPaymentMapper.toPatient(dto);
        Patient patient=Patient.builder()
                .patientName(dto.getPatientName())
                .patientAge(dto.getPatientAge())
                .build();


        Patient saved=this.patientRepo.save(patient);

        if (dto.getPaymentDTOS().size() == 0) {
//
            return PatientPaymentDTO.builder()
                    .id(saved.getId())
                    .patientName(saved.getPatientName())
                    .patientAge(saved.getPatientAge()).build();
        } else {
            List<PaymentDTO> paymentDTOList = dto.getPaymentDTOS().stream()
                    .map(addPaymentDTO -> {
                        AddPaymentDTO paymentWithPatientId = AddPaymentDTO.builder()
                                .patientId(saved.getId())
                                .amount(addPaymentDTO.getAmount())
                                .build();
                        return this.proxyPayment.addPayment(paymentWithPatientId);
                    })
                    .collect(Collectors.toList());

            return PatientPaymentDTO.builder().id(saved.getId()).patientName(saved.getPatientName()).patientAge(saved.getPatientAge())
                        .paymentDTOS(paymentDTOList)
                        .build();
        }

    }
}
