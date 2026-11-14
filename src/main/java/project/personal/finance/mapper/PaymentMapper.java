package project.personal.finance.mapper;


import org.mapstruct.Mapper;
import project.personal.finance.dto.PaymentDTO;
import project.personal.finance.entities.Payment;

@Mapper(componentModel = "Spring")
public interface PaymentMapper {

    public Payment toEntity(PaymentDTO dto);
    public PaymentDTO toDto(Payment payment);
}
