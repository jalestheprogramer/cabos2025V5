package unitins.tp1.br.service;

import java.util.List;

import unitins.tp1.br.dto.PessoaFisicaDTO;
import unitins.tp1.br.dto.PessoaFisicaResponseDTO;



public interface PessoaFisicaService {

    PessoaFisicaResponseDTO create(PessoaFisicaDTO pessoafisica);
    void update(long id, PessoaFisicaDTO pessoafisica);
    void delete(long id);
    PessoaFisicaResponseDTO findById(long id);
    List<PessoaFisicaResponseDTO> findByNome(String nome);
    PessoaFisicaResponseDTO findByCpf(String cpf);
    List<PessoaFisicaResponseDTO> findAll();
    
}
