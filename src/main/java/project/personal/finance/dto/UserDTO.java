package project.personal.finance.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 155, message = "Le nom ne doit pas dépasser 155 caractères")
    private String nom;

    @NotBlank(message = "Le prenom est obligatoire")
    @Size(max = 255, message = "Le prenom ne doit pas dépasser 255 caractères")
    private String prenom;
}
