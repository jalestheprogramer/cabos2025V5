package unitins.tp1.br.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioJuridicoDTO(
    @NotBlank(message = "O nome deve ser informado.")
    @Size(max = 60, min = 4, message = "Nome invalido")
    String nome,

    @NotNull(message = "Deve aver um cnpj.")
    @Size(max = 11, min = 11, message = "cnpj invalido deve aver 14 caracteres")
    String cnpj,
    
    @NotNull(message = "Deve-se indicar se o codgo de parceria.")
    int numeroParceria) {

    

}
