package com.totalplay.algorithm.controller;

import java.util.List;
import java.util.ArrayList;
import com.totalplay.algorithm.model.Value;
import org.springframework.http.HttpStatus;
import com.totalplay.algorithm.model.Result;
import javax.servlet.http.HttpServletRequest;
import com.totalplay.algorithm.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Response> readableException(HttpMessageNotReadableException exception, HttpServletRequest request) {

        Result result = new Result();

        Response response = new Response();

        List<Value> values = new ArrayList<>();

        result.setCode("-50");

        result.setDescription("Solicitud incorrecta.");

        response.setResult(result);

        response.setValues(values);

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

}