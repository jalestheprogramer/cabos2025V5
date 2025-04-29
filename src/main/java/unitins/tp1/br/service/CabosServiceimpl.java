package unitins.tp1.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unitins.tp1.br.dto.CabosDTO;
import unitins.tp1.br.dto.CabosResponseDTO;
import unitins.tp1.br.model.Cabos;
import unitins.tp1.br.model.Fabricante;
import unitins.tp1.br.model.Tamanho;
import unitins.tp1.br.model.Tecnologia;
import unitins.tp1.br.repository.CabosRepository;
import unitins.tp1.br.repository.FabricanteRepository;

@ApplicationScoped
public class CabosServiceimpl implements CabosService {

    @Inject
    CabosRepository cabosRepository;

    @Inject
    FabricanteRepository fabricanteRepository;

    @Override
    @Transactional
    public CabosResponseDTO create(CabosDTO dto) {

        Cabos novoCabos = new Cabos();
        novoCabos.setNome(dto.nome());

        Fabricante fabricante = fabricanteRepository.findById(dto.idfabricante());
        novoCabos.setFabricante(fabricante);

        novoCabos.setTecnologia(Tecnologia.valueOf(dto.idTecnologia()));

        novoCabos.setTamanho(Tamanho.valueOf(dto.idTamanho()));

        cabosRepository.persist(novoCabos);

        return CabosResponseDTO.valueOf(novoCabos);

    }

    @Override
    @Transactional
    public void update(long id, CabosDTO dto) {
        Cabos edicaoCabos = cabosRepository.findById(id);

        if (edicaoCabos == null) {
            throw new IllegalArgumentException("Cabo com ID " + id + " não encontrado.");
        }

        edicaoCabos.setNome(dto.nome());

        Fabricante fabricante = fabricanteRepository.findById(dto.idfabricante());
        
        if (fabricante == null) {
            throw new IllegalArgumentException("Fabricante com ID " + dto.idfabricante() + " não encontrado.");
        }

        edicaoCabos.setFabricante(fabricante);

        edicaoCabos.setTecnologia(Tecnologia.valueOf(dto.idTecnologia()));

        edicaoCabos.setTamanho(Tamanho.valueOf(dto.idTamanho()));
    }

    @Override
    @Transactional
    public void delete(long id) {

        cabosRepository.deleteById(id);

    }

    @Override
    public CabosResponseDTO findById(long id) {

        return CabosResponseDTO.valueOf(cabosRepository.findById(id));
    }

    @Override
    @Transactional
    public List<CabosResponseDTO> findByFabricante(Long idFabricante) {
        return cabosRepository.findByFabricante(idFabricante).stream().map(e -> CabosResponseDTO.valueOf(e)).toList();
    }

    @Override
    public CabosResponseDTO findByNome(String nome) {
        return CabosResponseDTO.valueOf(cabosRepository.findByNome(nome));
    }

    @Override
    public List<CabosResponseDTO> findAll() {

        return cabosRepository.findAll().stream().map(e -> CabosResponseDTO.valueOf(e)).toList();

    }

}
