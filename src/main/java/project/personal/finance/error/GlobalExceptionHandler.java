package project.personal.finance.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import project.personal.finance.exception.ChampNonValideException;
import project.personal.finance.exception.DataNotFoundException;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::"+ ex.getMessage());


        StringBuilder messageErreur = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error
                -> messageErreur.append(error.getDefaultMessage()).append("\n")
        );

        return ResponseEntity.badRequest().body(
                ErrorResponse.builder()
                        .message(messageErreur.toString())
                        .debugMessage(ex.getLocalizedMessage())
                        .errorDate(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFound(DataNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorResponse.builder()
                        .message(ex.getMessage())
                        .debugMessage(ex.getLocalizedMessage())
                        .errorDate(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                ErrorResponse.builder()
                        .message("Une contrainte d'unicité a été violée")
                        .debugMessage(ex.getMostSpecificCause().getMessage())
                        .errorDate(LocalDateTime.now())
                        .status(HttpStatus.CONFLICT)
                        .build());
    }

    @ExceptionHandler(ChampNonValideException.class)
    public ResponseEntity<Object> handleChampNotValidate(ChampNonValideException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .message(ex.getMessage())
                        .debugMessage(ex.getLocalizedMessage())
                        .errorDate(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST)
                        .build());
    }
}
