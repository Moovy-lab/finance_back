package project.personal.finance.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.personal.finance.entities.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PaymentDTO {

    private Integer id;

    @NotNull(message = "La date est obligatoire")
    private LocalDateTime date;

    @NotNull(message = "Le montant dépensé est obligatoire")
    private double amount;

    private User utilisateur;
}
