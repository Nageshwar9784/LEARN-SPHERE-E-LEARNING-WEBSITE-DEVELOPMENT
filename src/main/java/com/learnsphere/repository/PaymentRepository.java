package com.learnsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.learnsphere.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Payment findByOrderId(String orderId);
	

}
