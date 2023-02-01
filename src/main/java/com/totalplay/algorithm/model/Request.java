package com.totalplay.algorithm.model;

import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "Entrada General", description = "Valores a encriptar ó desencriptar.", required = true)
public class Request {

    @Schema(title = "Lista", description = "Valores a encriptar ó desencriptar.")
    private List<Value> values;

}
