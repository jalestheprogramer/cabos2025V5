package unitins.tp1.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unitins.tp1.br.dto.UsuarioFisicoDTO;
import unitins.tp1.br.dto.UsuarioFisicoResponseDTO;
import unitins.tp1.br.model.UsuarioFisico;

import unitins.tp1.br.repository.UsuarioFisicoRepository;

@ApplicationScoped
public class UsuarioFisicoServiceimpl implements UsuarioFisicoService {

    @Inject
    UsuarioFisicoRepository usuarioFisicoRepository;

    @Override
    @Transactional
    public UsuarioFisicoResponseDTO create(UsuarioFisicoDTO usuariofisico) {
        UsuarioFisico novoUsuarioFisico = new UsuarioFisico();
        novoUsuarioFisico.setNome(usuariofisico.nome());
        novoUsuarioFisico.setCpf(usuariofisico.cpf());
        novoUsuarioFisico.setUserAdm(usuariofisico.userAdm());

        usuarioFisicoRepository.persist(novoUsuarioFisico);

        return UsuarioFisicoResponseDTO.valueOf(novoUsuarioFisico);
    }

    @Override
    @Transactional
    public void update(long id, UsuarioFisicoDTO usuarioFisico) {
        UsuarioFisico edicaoUsuarioFisico = usuarioFisicoRepository.findById(id);

        edicaoUsuarioFisico.setNome(usuarioFisico.nome());
        edicaoUsuarioFisico.setCpf(usuarioFisico.cpf());
        edicaoUsuarioFisico.setUserAdm(usuarioFisico.userAdm());
    }

    @Override
    @Transactional
    public void delete(long id) {
        usuarioFisicoRepository.deleteById(id);
    }

    @Override
    public UsuarioFisicoResponseDTO findById(long id) {
        return UsuarioFisicoResponseDTO.valueOf(usuarioFisicoRepository.findById(id));
    }

    @Override
    public UsuarioFisicoResponseDTO findByCpf(String cpf) {
        return UsuarioFisicoResponseDTO.valueOf(usuarioFisicoRepository.findByCpf(cpf));
    }

    @Override
    public List<UsuarioFisicoResponseDTO> findByNome(String nome) {
        return usuarioFisicoRepository.findByNome(nome).stream().map(pf -> UsuarioFisicoResponseDTO.valueOf(pf)).toList();
    }

    @Override
    public List<UsuarioFisicoResponseDTO> findByUserAdm(Boolean userAdm) {
        return usuarioFisicoRepository.findByUserAdm(userAdm).stream().map(e -> UsuarioFisicoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<UsuarioFisicoResponseDTO> findAll() {
        return usuarioFisicoRepository.findAll().stream().map(e -> UsuarioFisicoResponseDTO.valueOf(e)).toList();
    }

}
