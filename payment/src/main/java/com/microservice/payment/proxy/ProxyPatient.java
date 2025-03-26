package com.microservice.payment.proxy;

import com.microservice.payment.model.dto.PatientDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PATIENT-SERVICE")

public interface ProxyPatient {
    @GetMapping("/patients/get-patient")
    @CircuitBreaker(name = "patientService",fallbackMethod = "getDefaultPatient")
    public PatientDTO getPatient(@RequestParam Long id);

    default PatientDTO getDefaultPatient(Long id,Exception exception) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(id);
        patientDTO.setPatientName("Not Vailable");
        patientDTO.setPatientAge(0);
        return patientDTO;
    }

}
