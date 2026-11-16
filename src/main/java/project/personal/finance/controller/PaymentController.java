package project.personal.finance.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.personal.finance.dto.PaymentDTO;
import project.personal.finance.entities.Payment;

import java.util.List;

public interface PaymentController {
    ResponseEntity<Void> ajouter(@Valid @RequestBody PaymentDTO paymentDTO);

    PaymentDTO modifier(@PathVariable("id") Integer id, @Valid @RequestBody PaymentDTO paymentDTO);

    ResponseEntity<List<PaymentDTO>> recupererTousLesPayements();

    ResponseEntity<PaymentDTO> findById(@PathVariable("id") Integer id);

    ResponseEntity<Void> supprimer(@PathVariable("id") Integer id);
}
