package com.totalplay.algorithm.controller;

import com.totalplay.algorithm.model.Request;
import com.totalplay.algorithm.model.Response;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.links.Link;
import org.springframework.web.bind.annotation.*;
import com.totalplay.algorithm.service.AlgorithmService;
import io.swagger.v3.oas.annotations.links.LinkParameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/middleware")
public class AlgorithmController {

    @Autowired
    private AlgorithmService algorithmService;

    @PostMapping("/algorithm/encryption")
    @Operation(summary = "Método de encriptación.",
            description = "Ingresar valores a encriptar.",
            responses = {
                    @ApiResponse(responseCode = "202", description = "Petición realizada con éxito.", links = {
                            @Link(name = "Encriptar.", description = "application/json", operationId = "POST",
                                    parameters = {
                                            @LinkParameter(name = "values", expression = "[{'value' : 'Total'}, {'value' : 'Play'}]")
                                    })
                    }, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "400", description = "Ingresar header.", links = {
                            @Link(name = "Encriptar.", description = "application/json", operationId = "POST",
                                    parameters = {
                                            @LinkParameter(name = "values", expression = "[{'value' : 'Total'}, {'value' : 'Play'}]")
                                    })
                    }, useReturnTypeSchema = true)
            }
    )
    public ResponseEntity<Response> encryption(@RequestHeader(value = "Middleware-Header", required = false) String header, @RequestBody(required = false) Request request){

        return algorithmService.encryption(header, request);

    }

    @PostMapping("/algorithm/decryption")
    @Operation(summary = "Método de desencriptación.",
            description = "Ingresar valores a desencriptar.",
            responses = {
                    @ApiResponse(responseCode = "202", description = "Petición realizada con éxito.", links = {
                            @Link(name = "Desencriptar.", description = "application/json", operationId = "POST",
                                    parameters = {
                                            @LinkParameter(name = "values", expression = "[{'value' : 'Npb3MgT'}, {'value' : 'TWljcm9'}]")
                                    })
                    }, useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "400", description = "Ingresar header.", links = {
                            @Link(name = "Desencriptar.", description = "application/json", operationId = "POST",
                                    parameters = {
                                            @LinkParameter(name = "values", expression = "[{'value' : 'WlkZGxl'}, {'value' : 'zZXJ2aW'}]")
                                    })
                    }, useReturnTypeSchema = true)
            }
    )
    public ResponseEntity<Response> decryption(@RequestHeader(value = "Middleware-Header", required = false) String header, @RequestBody(required = false) Request request){

        return algorithmService.decryption(header, request);

    }


}
