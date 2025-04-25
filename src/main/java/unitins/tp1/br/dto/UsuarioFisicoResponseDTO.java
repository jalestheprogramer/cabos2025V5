package unitins.tp1.br.dto;

import unitins.tp1.br.model.UsuarioFisico;

public record UsuarioFisicoResponseDTO(
        Long id,
        String nome,
        String cpf,
        Boolean userAdm) {

    public static UsuarioFisicoResponseDTO valueOf(UsuarioFisico usuarioFisico) {
        if (usuarioFisico == null)
            return null;
        return new UsuarioFisicoResponseDTO(
                usuarioFisico.getId(),
                usuarioFisico.getNome(),
                usuarioFisico.getCpf(),
                usuarioFisico.getUserAdm());
    }
}
