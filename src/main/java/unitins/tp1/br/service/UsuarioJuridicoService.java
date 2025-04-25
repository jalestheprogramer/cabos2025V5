package unitins.tp1.br.service;

import java.util.List;

import unitins.tp1.br.dto.UsuarioJuridicoDTO;
import unitins.tp1.br.dto.UsuarioJuridicoResponseDTO;



public interface UsuarioJuridicoService {

    UsuarioJuridicoResponseDTO create(UsuarioJuridicoDTO usuarioJuridico);
    void update(long id, UsuarioJuridicoDTO usuarioJuridico);
    void delete(long id);
    UsuarioJuridicoResponseDTO findById(long id);
    List<UsuarioJuridicoResponseDTO> findByNome(String nome);
    UsuarioJuridicoResponseDTO findByNumeroParceria(int numeroParceria);
    UsuarioJuridicoResponseDTO findByCnpj(String cpf);
    List<UsuarioJuridicoResponseDTO> findAll();
    
}
