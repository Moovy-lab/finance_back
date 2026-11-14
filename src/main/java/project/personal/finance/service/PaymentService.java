package project.personal.finance.service;

import org.springframework.transaction.annotation.Transactional;
import project.personal.finance.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO ajouter(PaymentDTO paymentDTO);


    PaymentDTO modifier(PaymentDTO paymentDTO);

    @Transactional(readOnly = true)
    List<PaymentDTO> recupererTousLesPayements();

    PaymentDTO findById(Integer id);
}
