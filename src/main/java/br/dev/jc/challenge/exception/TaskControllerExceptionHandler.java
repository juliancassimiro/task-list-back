package br.dev.jc.challenge.exception;

import br.dev.jc.challenge.controller.TaskController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(assignableTypes = {TaskController.class})
public class TaskControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationExceptions (MethodArgumentNotValidException exception){

        var errors = new ArrayList<String>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            errors.add(error.getDefaultMessage());
        });

        return new ResponseEntity<>(Map.of("errors", errors), HttpStatus.BAD_REQUEST);


    }
}
