package unitins.tp1.br.service;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unitins.tp1.br.dto.FabricanteDTO;
import unitins.tp1.br.dto.FabricanteResponseDTO;
import unitins.tp1.br.model.Fabricante;
import unitins.tp1.br.repository.CabosRepository;
import unitins.tp1.br.repository.FabricanteRepository;

@ApplicationScoped
public class FabricanteServiceimpl implements FabricanteService {

    @Inject
    FabricanteRepository fabricanteRepository;

    @Inject
    CabosRepository cabosRepository;

    @Override
    @Transactional
    public FabricanteResponseDTO create(FabricanteDTO dto) {
        Fabricante novoFabricante = new Fabricante();
        novoFabricante.setCadastroF(dto.cadastroF());
        novoFabricante.setNome(dto.nome());
        novoFabricante.setCnpj(dto.cnpj());

        
        fabricanteRepository.persist(novoFabricante);

        return FabricanteResponseDTO.valueOf(novoFabricante);
    }

    @Override
    @Transactional
    public void update(long id, FabricanteDTO dto) {

        Fabricante edicaoFabricante = fabricanteRepository.findById(id);

        edicaoFabricante.setCadastroF(dto.cadastroF());
        edicaoFabricante.setNome(dto.nome());
        edicaoFabricante.setCnpj(dto.cnpj());
       
    }

    @Override
    @Transactional
    public void delete(long id) {
        fabricanteRepository.deleteById(id);
    }

    @Override
    @Transactional
    public FabricanteResponseDTO findById(long id) {
        return FabricanteResponseDTO.valueOf(fabricanteRepository.findById(id));
    }

    @Override
    @Transactional
    public FabricanteResponseDTO findByNome(String nome) {
        return FabricanteResponseDTO.valueOf(fabricanteRepository.findByNome(nome));
    }

   @Override
    public FabricanteResponseDTO findByCadastro(String cadastroF) {
        return FabricanteResponseDTO.valueOf(fabricanteRepository.findByCadastro(cadastroF));
    }

    @Override
    public FabricanteResponseDTO findByCnpj(String cnpj) {
        return FabricanteResponseDTO.valueOf(fabricanteRepository.findByCnpj(cnpj));
    }


    @Override
    @Transactional
    public List<FabricanteResponseDTO> findAll() {
        return fabricanteRepository.findAll().stream().map(FabricanteResponseDTO::valueOf).toList();
    }
}
