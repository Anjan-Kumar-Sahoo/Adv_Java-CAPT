package com.capT.Payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capT.Payment.entity.Payment;
import com.capT.Payment.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
