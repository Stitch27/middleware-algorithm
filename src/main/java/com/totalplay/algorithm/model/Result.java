package com.totalplay.algorithm.model;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(title = "Resultados", description = "Parametros de resultados.", required = true)
public class Result {

    @Schema(title = "Código", description = "Código.")
    private String code;
    @Schema(title = "Descripción", description = "Descripción.")
    private String description;

}
