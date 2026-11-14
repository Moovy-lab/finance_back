package project.personal.finance.service;

import jakarta.validation.Valid;
import project.personal.finance.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO ajouter(@Valid UserDTO userDTO);

    UserDTO modifier(UserDTO userDTO);

    List<UserDTO> recupererListeDesUtilisateurs();

    UserDTO findById(Integer id);
}
