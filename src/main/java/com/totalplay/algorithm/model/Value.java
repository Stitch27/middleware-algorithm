package com.totalplay.algorithm.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Valor", description = "Parámetro de entrada o salida.", required = true)
public class Value {

    @Schema(title = "Valor", description = "Valor encriptado ó desencriptado.")
    private String value;

}
