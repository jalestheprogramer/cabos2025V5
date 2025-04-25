package unitins.tp1.br.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import unitins.tp1.br.model.UsuarioFisico;

@ApplicationScoped
public class UsuarioFisicoRepository implements PanacheRepository<UsuarioFisico> {

    public List<UsuarioFisico> findByNome(String nome) {
        return find("nome like = ?1 ", "%" + nome + "%").list();
    }

    public UsuarioFisico findByCpf(String cpf) {
        return find("cpf = ?1", cpf).firstResult();
    }

    public List<UsuarioFisico> findByUserAdm(Boolean userAdm) {
        return find("SELECT e FROM UsuarioFisico e WHERE e.userAdm like ?1 ", userAdm).list();
    }
}