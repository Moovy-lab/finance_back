package project.personal.finance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.personal.finance.dto.PaymentDTO;
import project.personal.finance.entities.Payment;
import project.personal.finance.exception.DataNotFoundException;
import project.personal.finance.mapper.PaymentMapper;
import project.personal.finance.repository.PaymentRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;


    @Override
    public PaymentDTO ajouter(PaymentDTO paymentDTO){

        //Mettre en place une logique conditionnelle : si le montant est inférieur à 0, on lève une exception
//        if (this.getAmount() < 0) {
//            throw new MontantNegativeException("Le montant est inférieur à 0");
//        }

        Payment paymentCreated = paymentRepository.save(paymentMapper.toEntity(paymentDTO));
        return paymentMapper.toDto(paymentCreated);
    }

    @Override
    public PaymentDTO modifier(PaymentDTO paymentDTO){
        Payment paymentModifier = paymentRepository.save(paymentMapper.toEntity(paymentDTO));
        return paymentMapper.toDto(paymentModifier);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PaymentDTO> recupererTousLesPayements(){
        return paymentRepository.findAll().stream().map(payment -> paymentMapper.toDto(payment)).toList();
    }

    @Override
    public PaymentDTO findById(Integer id) {
        return paymentRepository.findById(id).map(paymentMapper::toDto).orElseThrow(()-> new DataNotFoundException("Payement Introuvable"));
    }

    @Override
    @Transactional
    public void supprimer(Integer id) {
         paymentRepository.deletePaymentByid(id);
    }


//    public int getAmount() {
//        return amount;
//    }
}
