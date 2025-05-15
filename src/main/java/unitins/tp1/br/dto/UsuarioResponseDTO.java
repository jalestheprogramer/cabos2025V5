package unitins.tp1.br.dto;

import unitins.tp1.br.model.Usuario;

public record UsuarioResponseDTO(    
    Long id,
    String nome,
    String username) {

    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        if (usuario == null)
            return null;
        return new UsuarioResponseDTO(
            usuario.getId(), 
            usuario.getUsuarioFisico().getNome(), 
            usuario.getUsername());
    }
    
}
