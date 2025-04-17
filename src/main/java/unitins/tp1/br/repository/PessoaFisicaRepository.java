package unitins.tp1.br.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.br.model.PessoaFisica;

@ApplicationScoped
public class PessoaFisicaRepository implements PanacheRepository<PessoaFisica> {
    
    public List<PessoaFisica> findByNome(String nome){
        return find("nome like = ?1 ","%"+nome+"%").list();
    }
    
     public PessoaFisica findByCpf(String cpf) {
        return find("cpf = ?1", cpf).firstResult();
    }
}