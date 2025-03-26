package com.microservice.patient.proxy;


import com.microservice.patient.model.dto.AddPaymentDTO;
import com.microservice.patient.model.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PAYMENT-SERVICE")
public interface ProxyPayment {

    @GetMapping("/payments/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestParam("patientId") Long patientId) ;

    @PostMapping("/payments/add-payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO addPaymentDTO);

    @DeleteMapping("/payments/delete-payments-by-patient-id")
    public void deletePaymentsByPatientId(@RequestParam Long patientId);

}
