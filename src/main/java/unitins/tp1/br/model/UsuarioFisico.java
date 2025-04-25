package unitins.tp1.br.model;


import jakarta.persistence.Entity;


@Entity
public class UsuarioFisico extends PessoaFisica  {
    private Boolean userAdm;

    public Boolean getUserAdm() {
        return userAdm;
    }
    public void setUserAdm(Boolean userAdm) {
        this.userAdm = userAdm;
    }

}

