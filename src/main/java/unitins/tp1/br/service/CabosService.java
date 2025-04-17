package unitins.tp1.br.service;

import java.util.List;

import unitins.tp1.br.dto.CabosDTO;
import unitins.tp1.br.dto.CabosResponseDTO;


public interface CabosService {

    CabosResponseDTO create(CabosDTO cabos);
    void update(long id, CabosDTO cabos);
    void delete(long id);
    CabosResponseDTO findById(long id);
    List<CabosResponseDTO> findByFabricante(Long idfFabricante);
    CabosResponseDTO findByNome(String nome);
    List<CabosResponseDTO>findAll();
    
}
