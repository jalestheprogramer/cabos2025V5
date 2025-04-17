package unitins.tp1.br.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.br.model.PessoaJuridica;

@ApplicationScoped
public class PessoaJuridicaRepository implements PanacheRepository<PessoaJuridica> {

    public List<PessoaJuridica> findByNome(String nome) {
        return find("nome like = ?1 ", "%" + nome + "%").list();
    }

    public PessoaJuridica findByCpf(String cnpj) {
        return find("cpf = ?1", cnpj).firstResult();
    }
}