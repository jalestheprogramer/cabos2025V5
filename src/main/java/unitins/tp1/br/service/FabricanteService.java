package unitins.tp1.br.service;

import java.util.List;

import unitins.tp1.br.dto.FabricanteDTO;
import unitins.tp1.br.dto.FabricanteResponseDTO;

public interface FabricanteService {

    FabricanteResponseDTO create(FabricanteDTO fabricante);
    void update(long id, FabricanteDTO fabricante);
    void delete(long id);
    FabricanteResponseDTO findById(long id);
    FabricanteResponseDTO findByNome(String nome);
    FabricanteResponseDTO findByCadastro(String cadastroF);
    FabricanteResponseDTO findByCnpj(String cnpj);
    List<FabricanteResponseDTO> findAll();

}
