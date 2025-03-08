package com.example.demo.confi;
 import com.example.demo.Servse.bundel.LocalBunddlsr;
 import com.example.demo.dto.Expationdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;
@RestControllerAdvice
public class Exceotion  {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Expationdto> handleSystemException(RuntimeException runtimeException) {
        return ResponseEntity.internalServerError().body(LocalBunddlsr.getExpationdto(runtimeException.getMessage()));
    }

//    @ExceptionHandler(SystemException.class)
//    public ResponseEntity<?> handleRuntimeException(SystemException ex) {
//        return ResponseEntity.internalServerError().body(new Expationdto(ex.getMessage(), ex.getMessage()));
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<Expationdto> expationdtos = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            Expationdto expationdto = new Expationdto();
            expationdto.setMessage(fieldError.getDefaultMessage());
            expationdtos.add(expationdto);
        }
        return new ResponseEntity<>(expationdtos, HttpStatus.BAD_REQUEST);
    }

}
