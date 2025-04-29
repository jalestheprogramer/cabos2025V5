package unitins.tp1.br.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CabosDTO(

    @NotBlank(message = "O nome deve ser informado.")
    String nome,

    @NotNull(message = "Deve aver um fabricante.")
    Long idfabricante,

    @Min(value = 1, message = "O valor mínimo para a tecnologia é 1.")
    @Max(value = 4, message = "O valor máximo para a tecnologia é 4.")
    Integer idTecnologia,
    
    @Min(value = 1, message = "O valor mínimo para a tamanho é 1.")
    @Max(value = 13, message = "O valor máximo para a tamanho é 13.")
    Integer idTamanho) {
    
}
