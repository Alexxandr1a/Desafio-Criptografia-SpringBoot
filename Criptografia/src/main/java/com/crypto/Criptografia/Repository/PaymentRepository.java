package com.crypto.Criptografia.Repository;

import com.crypto.Criptografia.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value = "SELECT id, credit_card_token, user_document, payment_value FROM payment", nativeQuery = true)
    List<Object[]> findAllRaw();
    @Query(value = "SELECT id, credit_card_token, user_document, payment_value FROM payment WHERE id = :id", nativeQuery = true)
    Object[] findRawById(@Param("id") Long id);

}
