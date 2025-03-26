package com.microservice.payment.model.mapper;

import com.microservice.payment.model.dto.AddPaymentDTO;
import com.microservice.payment.model.dto.PaymentDTO;
import com.microservice.payment.model.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    public Payment toEntity(PaymentDTO paymentDTO);

    public PaymentDTO toDTo(Payment entity);

    public AddPaymentDTO toAddPaymentDTO(Payment payment);

    public Payment toAddPaymentEntity(AddPaymentDTO addPaymentDTO);

    public List<Payment> toEntity(List<PaymentDTO> paymentsDTO);

    public List<PaymentDTO> toDTos(List<Payment> entities);

}
