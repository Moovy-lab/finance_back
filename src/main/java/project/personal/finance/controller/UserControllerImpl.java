package project.personal.finance.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import project.personal.finance.dto.UserDTO;
import project.personal.finance.service.UserService;

import java.net.URI;
import java.util.List;


@RestController
public class UserControllerImpl implements UserController{
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * Cette classe permet d'ajouter une nouvelle ressource utilisateurs
     *POST /utilisateurs
     * @author PC2
     */
    @PostMapping("/utilisateurs")
    @Override
    public ResponseEntity<Void> ajouter(@Valid @RequestBody UserDTO userDTO){
        UserDTO userCreated = userService.ajouter(userDTO);

        URI newResourceLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(newResourceLocation).build();
    }


    /**
     * Cette classe permet de modifier une ressource user
     *PUT /utilisateurs/{id}
     * @author PC2
     */
    @PutMapping("/utilisateurs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public UserDTO modifier(@PathVariable("id") Integer id, @Valid @RequestBody UserDTO userDTO) {
        return userService.modifier(userDTO);
    }


    /**
     * Cette classe permet de récupérer toutes les ressources user disponibles en base
     *GET /utilisateurs
     * @author PC2
     */
    @GetMapping("/utilisateurs")
    @Override
    public ResponseEntity<List<UserDTO>> recupererListeDesUtilisateurs() {
        List<UserDTO> userTrouves = userService.recupererListeDesUtilisateurs();

        return ResponseEntity.ok().body(userTrouves);
    }


    /**
     * Cette classe permet de récupérer une ressource user disponibles en base par son ID
     *GET /utilisateurs/{id}
     * @author PC2
     */
    @GetMapping("/utilisateurs/{id}")
    @Override
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Integer id){
        UserDTO userTrouve = userService.findById(id);
        return ResponseEntity.ok().body(userTrouve);
    }
}
