package project.personal.finance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import project.personal.finance.dto.UserDTO;

import java.util.List;

public interface UserController {

    public ResponseEntity<Void> ajouter(UserDTO userDTO);

    UserDTO modifier(Integer id, UserDTO userDTO);

    ResponseEntity<List<UserDTO>> recupererListeDesUtilisateurs();

    ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id);
}
