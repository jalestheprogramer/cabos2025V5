package unitins.tp1.br.service;

import java.util.List;

import unitins.tp1.br.dto.PessoaJuridicaDTO;
import unitins.tp1.br.dto.PessoaJuridicaResponseDTO;



public interface PessoaJuridicaService {

    PessoaJuridicaResponseDTO create(PessoaJuridicaDTO pessoajuridica);
    void update(long id, PessoaJuridicaDTO pessoajuridica);
    void delete(long id);
    PessoaJuridicaResponseDTO findById(long id);
    List<PessoaJuridicaResponseDTO> findByNome(String nome);
    PessoaJuridicaResponseDTO findByCnpj(String cnpj);
    List<PessoaJuridicaResponseDTO> findAll();
    
}
