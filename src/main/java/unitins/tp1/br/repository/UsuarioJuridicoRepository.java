package unitins.tp1.br.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.br.model.UsuarioJuridico;

@ApplicationScoped
public class UsuarioJuridicoRepository implements PanacheRepository<UsuarioJuridico> {

    public List<UsuarioJuridico> findByNome(String nome) {
        return find("nome like ?1", "%" + nome + "%").list();
    }

    public UsuarioJuridico findByCnpj(String cnpj) {
        return find("SELECT e FROM UsuarioJuridico e WHERE e.cnpj = ?1 ", cnpj).firstResult();
    }

    public UsuarioJuridico findById(long id) {
        return find("SELECT e FROM UsuarioJuridico e WHERE e.id = ?1 ", id).firstResult();
    }

    public UsuarioJuridico findByNumeroParceria(int numeroParceria) {
        return find("SELECT e FROM UsuarioJuridico e WHERE e.numeroParceria = ?1 ", numeroParceria).firstResult();
    }
}