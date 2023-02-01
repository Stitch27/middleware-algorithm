package com.totalplay.algorithm.model;

import lombok.Data;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(title = "Salida General", description = "Valores encriptados ó desencriptados.", required = true)
public class Response {

    @Schema(title = "Resultados", description = "Parametros de resultados.")
    private Result result;
    @Schema(title = "Lista", description = "Valores encriptados ó desencriptados.")
    private List<Value> values;

}
