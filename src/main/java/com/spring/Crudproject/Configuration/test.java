package com.spring.Crudproject.Configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
    
}
