package com.spring.Crudproject.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.management.relation.RelationNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class test {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> solveit(MethodArgumentNotValidException ex){
        Map<String,String> h=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e->{
            h.put(e.getField(), e.getDefaultMessage());
        });

        return h;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> solveit2(DataIntegrityViolationException ex){
        return new ResponseEntity<String>("user already exist", HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> solveit3(NoSuchElementException ex){
        return new ResponseEntity<String>("object not exist !!", HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> solveit3(MethodArgumentTypeMismatchException ex){
        return new ResponseEntity<String>("make sure to put the right path !!", HttpStatus.BAD_REQUEST);
    }
    
    
}
