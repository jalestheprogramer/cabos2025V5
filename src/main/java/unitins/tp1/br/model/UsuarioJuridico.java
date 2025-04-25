package unitins.tp1.br.model;

import jakarta.persistence.Entity;

@Entity
public class UsuarioJuridico extends PessoaJuridica {

    private int numeroParceria;

    public int getNumeroParceria() {
        return numeroParceria;
    }

    public void setNumeroParceria(int numeroParceria) {
        this.numeroParceria = numeroParceria;
    }

}
