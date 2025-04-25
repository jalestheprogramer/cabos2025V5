package unitins.tp1.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unitins.tp1.br.dto.UsuarioJuridicoDTO;
import unitins.tp1.br.dto.UsuarioJuridicoResponseDTO;
import unitins.tp1.br.model.UsuarioJuridico;

import unitins.tp1.br.repository.UsuarioJuridicoRepository;

@ApplicationScoped
public class UsuarioJuridicoServiceimpl implements UsuarioJuridicoService {

    @Inject
    UsuarioJuridicoRepository usuarioJuridicoRepository;

    @Override
    @Transactional
    public UsuarioJuridicoResponseDTO create(UsuarioJuridicoDTO usuarioJuridico) {
        UsuarioJuridico novoUsuarioJuridico = new UsuarioJuridico();
        novoUsuarioJuridico.setNome(usuarioJuridico.nome());
        novoUsuarioJuridico.setCnpj(usuarioJuridico.cnpj());
        novoUsuarioJuridico.setNumeroParceria(usuarioJuridico.numeroParceria());

        usuarioJuridicoRepository.persist(novoUsuarioJuridico);

        return UsuarioJuridicoResponseDTO.valueOf(novoUsuarioJuridico);
    }

    @Override
    @Transactional
    public void update(long id, UsuarioJuridicoDTO usuarioJuridico) {
        UsuarioJuridico edicaoUsuarioJuridico = usuarioJuridicoRepository.findById(id);

        edicaoUsuarioJuridico.setNome(usuarioJuridico.nome());
        edicaoUsuarioJuridico.setCnpj(usuarioJuridico.cnpj());
        edicaoUsuarioJuridico.setNumeroParceria(usuarioJuridico.numeroParceria());
    }

    @Override
    @Transactional
    public void delete(long id) {
        usuarioJuridicoRepository.deleteById(id);
    }

    @Override
    public UsuarioJuridicoResponseDTO findById(long id) {
        return UsuarioJuridicoResponseDTO.valueOf(usuarioJuridicoRepository.findById(id));
    }

    @Override
    public UsuarioJuridicoResponseDTO findByCnpj(String cnpj) {
        return UsuarioJuridicoResponseDTO.valueOf(usuarioJuridicoRepository.findByCnpj(cnpj));
    }

    @Override
    public List<UsuarioJuridicoResponseDTO> findByNome(String nome) {
        return usuarioJuridicoRepository.findByNome(nome).stream().map(pf -> UsuarioJuridicoResponseDTO.valueOf(pf)).toList();
    }

    @Override
    public UsuarioJuridicoResponseDTO findByNumeroParceria(int numeroParceria) {
        return UsuarioJuridicoResponseDTO.valueOf(usuarioJuridicoRepository.findByNumeroParceria(numeroParceria));
    }

    @Override
    public List<UsuarioJuridicoResponseDTO> findAll() {
        return usuarioJuridicoRepository.findAll().stream().map(e -> UsuarioJuridicoResponseDTO.valueOf(e)).toList();
    }

}
