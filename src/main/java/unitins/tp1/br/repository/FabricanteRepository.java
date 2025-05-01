package unitins.tp1.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.br.model.Fabricante;

@ApplicationScoped
public class FabricanteRepository implements PanacheRepository<Fabricante> {
    public Fabricante findByCadastro(String cadastroF) {
        return find("SELECT e FROM Fabricante e WHERE e.cadastroF = ?1 ", cadastroF).firstResult();
    }

    public Fabricante findById(long id){
        return find("SELECT e FROM Fabricante e WHERE e.id = ?1 ",id).firstResult();
    }

    public Fabricante findByNome(String nome) {
        return find("SELECT e FROM Fabricante e WHERE e.nome like ?1 ", "%" + nome + "%").firstResult();
    }
}
