package unitins.tp1.br.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioFisicoDTO(
    @NotBlank(message = "O nome deve ser informado.")
    @Size(max = 60, min = 4, message = "Nome invalido")
    String nome,

    @NotNull(message = "Deve aver um CPF.")
    @Size(max = 11, min = 11, message = "CPF invalido deve aver 11 caracteres")
    String cpf,
    
    @NotNull(message = "Deve-se indicar se o usuario e da Adiministração.")
    Boolean userAdm){

    

}
