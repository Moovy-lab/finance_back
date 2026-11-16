package project.personal.finance.service;

import project.personal.finance.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO ajouter(PaymentDTO paymentDTO);


    PaymentDTO modifier(PaymentDTO paymentDTO);


    List<PaymentDTO> recupererTousLesPayements();

    PaymentDTO findById(Integer id);

    void supprimer(Integer id);
}
