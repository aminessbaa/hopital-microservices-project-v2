package com.microservice.payment.controller;

import com.microservice.payment.model.dto.AddPaymentDTO;
import com.microservice.payment.model.dto.PaymentDTO;
import com.microservice.payment.service.PatientPaymentService;
import com.microservice.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PatientPaymentService patientPaymentService;

    @GetMapping("/get-payment-by-tran")
    public PaymentDTO getPaymentByTranId(@RequestParam("tran_id") String tranId) {
        return this.paymentService.getPayment(tranId);
    }

    @PostMapping("/add-payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO addPaymentDTO) {
        return this.paymentService.savePayment(addPaymentDTO);
    }


    @GetMapping("/get-patient-payments")
    public List<PaymentDTO> getPatientPayments(@RequestParam("patientId") Long patientId) {
        return this.paymentService.getPatientPayments(patientId);
    }

    @DeleteMapping("/delete-payments-by-patient-id")
    public void deletePaymentsByPatientId(@RequestParam Long patientId) {
        this.paymentService.deletePaymentsByPatientId(patientId);
    }

}
