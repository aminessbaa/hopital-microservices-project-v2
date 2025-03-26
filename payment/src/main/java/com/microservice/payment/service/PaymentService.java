package com.microservice.payment.service;

import com.microservice.payment.model.dto.AddPaymentDTO;
import com.microservice.payment.model.dto.PaymentDTO;
import com.microservice.payment.model.entity.Payment;
import com.microservice.payment.model.mapper.PaymentMapper;
import com.microservice.payment.repo.PaymentRepo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j// Lombok permet de déclarer un logger sans besoin de LoggerFactory
@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private PaymentMapper paymentMapper;



    public PaymentDTO getPayment(String transId) {
        Optional<Payment> payment = this.paymentRepo.findByTransId(transId);

        if (payment.isPresent()) {
            return this.paymentMapper.toDTo(payment.get());
        } else {
            log.warn("Aucun paiement trouvé pour transaction ID: {}", transId);
            return new PaymentDTO(); // Idéalement, lance une exception personnalisée
        }
    }

    public PaymentDTO savePayment(AddPaymentDTO addPaymentDTO) {
        String tran_id= UUID.randomUUID().toString();
        Payment entity = Payment.builder()
                .amount(addPaymentDTO.getAmount())
                .patientId(addPaymentDTO.getPatientId())
                .transId(tran_id)
                .build();
        Payment payment = this.paymentRepo.save(entity);

        return this.paymentMapper.toDTo(payment);
    }

    public List<PaymentDTO>  getPatientPayments(Long patientId){
      List<Payment> payments=this.paymentRepo.findAllByPatientId(patientId);
        return this.paymentMapper.toDTos(payments);
    }

    public void deletePaymentsByPatientId(Long patientId) {
        List<Payment> payments=this.paymentRepo.findAllByPatientId(patientId);
        this.paymentRepo.deleteAll(payments);
    }
}
