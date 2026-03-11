package com.capT.Payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capT.Payment.entity.Payment;
import com.capT.Payment.service.PaymentService;

@RestController
@RequestMapping("/payment/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("save")
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping("find")
    public List<Payment> findAllPayments() {
        return paymentService.findAllPayments();
    }

    @GetMapping("find/{id}")
    public Payment findPaymentById(@PathVariable Long id) {
        return paymentService.findPaymentById(id);
    }
}
