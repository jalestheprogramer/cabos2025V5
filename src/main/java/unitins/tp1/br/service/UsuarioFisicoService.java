package unitins.tp1.br.service;

import java.util.List;

import unitins.tp1.br.dto.UsuarioFisicoDTO;
import unitins.tp1.br.dto.UsuarioFisicoResponseDTO;



public interface UsuarioFisicoService {

    UsuarioFisicoResponseDTO create(UsuarioFisicoDTO usuariofisico);
    void update(long id, UsuarioFisicoDTO usuariofisico);
    void delete(long id);
    UsuarioFisicoResponseDTO findById(long id);
    List<UsuarioFisicoResponseDTO> findByNome(String nome);
    List<UsuarioFisicoResponseDTO> findByUserAdm(Boolean userAdm);
    UsuarioFisicoResponseDTO findByCpf(String cpf);
    List<UsuarioFisicoResponseDTO> findAll();
    
}
