package unitins.tp1.br.dto;

import unitins.tp1.br.model.UsuarioJuridico;

public record UsuarioJuridicoResponseDTO(
        Long id,
        String nome,
        String cnpj,
        int numeroParceria) {

    public static UsuarioJuridicoResponseDTO valueOf(UsuarioJuridico usuarioJuridico) {
        if (usuarioJuridico == null)
            return null;
        return new UsuarioJuridicoResponseDTO(
                usuarioJuridico.getId(),
                usuarioJuridico.getNome(),
                usuarioJuridico.getCnpj(),
                usuarioJuridico.getNumeroParceria());
    }
}
