package project.personal.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.personal.finance.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    void deletePaymentByid(Integer id);
}
