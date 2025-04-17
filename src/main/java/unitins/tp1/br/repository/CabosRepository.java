package unitins.tp1.br.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.br.model.Cabos;




@ApplicationScoped
public class CabosRepository implements PanacheRepository<Cabos> {
    
    public Cabos findByNome(String nome){
        return find("SELECT m FROM Cabos m WHERE m.nome = ?1 ",nome).firstResult();
    }
    
     public List<Cabos> findByFabricante(Long idFabricante) {
        return find("SELECT m FROM Cabos m WHERE m.fabricante.id = ?1", idFabricante).list();
    }
}
