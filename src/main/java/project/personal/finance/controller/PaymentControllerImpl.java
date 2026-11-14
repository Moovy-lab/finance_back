package project.personal.finance.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import project.personal.finance.dto.PaymentDTO;
import project.personal.finance.service.PaymentService;

import java.net.URI;
import java.util.List;

@RestController
public class PaymentControllerImpl  implements PaymentController{

    private final PaymentService paymentService;

    public PaymentControllerImpl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Cette classe permet d'ajouter une nouvelle ressource payment
     *POST /payments
     * @author PC2
     */
    @PostMapping("/payments")
    @Override
    public ResponseEntity<Void> ajouter(@Valid @RequestBody PaymentDTO paymentDTO){
        PaymentDTO paymentCreated = paymentService.ajouter(paymentDTO);

        URI newResourceLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(paymentCreated.getId())
                .toUri();

        return ResponseEntity.created(newResourceLocation).build();
    }


    /**
     * Cette classe permet de modifier une ressource payments
     *PUT /payments/{id}
     * @author PC2
     */
    @PutMapping("/payments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public PaymentDTO modifier(@PathVariable("id") Integer id, @Valid @RequestBody PaymentDTO paymentDTO) {
        return paymentService.modifier(paymentDTO);
    }


    /**
     * Cette classe permet de récupérer toutes les ressources payments disponibles en base
     *GET /payments
     * @author PC2
     */
    @GetMapping("/payments")
    @Override
    public ResponseEntity<List<PaymentDTO>> recupererTousLesPayements() {
        List<PaymentDTO> paymentTrouves = paymentService.recupererTousLesPayements();

        return ResponseEntity.ok().body(paymentTrouves);
    }


    /**
     * Cette classe permet de récupérer une ressource user disponibles en base par son ID
     *GET /utilisateurs/{id}
     * @author PC2
     */
    @GetMapping("/payments/{id}")
    @Override
    public ResponseEntity<PaymentDTO> findById(@PathVariable("id") Integer id){
        PaymentDTO paymentTrouve = paymentService.findById(id);
        return ResponseEntity.ok().body(paymentTrouve);
    }
}
