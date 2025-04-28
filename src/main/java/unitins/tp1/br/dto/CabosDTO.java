package unitins.tp1.br.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CabosDTO(

    @NotBlank(message = "O nome deve ser informado.")
    String nome,

    @NotNull(message = "Deve aver um fabricante.")
    Long idfabricante,

    @Min(value = 1, message = "O valor mínimo para a tecnologia é 1.")
    @Size(max = 4, min = 1, message = "O id informado e invalido.")
    Integer idTecnologia,
    
    @Min(value = 1, message = "O valor mínimo para a tamanho é 1.")
    @Size(max = 13, min = 1, message = "O id informado e invalido.")
    Integer idTamanho) {
    
}
