package unitins.tp1.br.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;




@Entity
public class Fabricante extends PessoaJuridica {

    @Column(length = 100)
    private String cadastroF;

    public String getCadastroF() {
        return cadastroF;
    }

    public void setCadastroF(String cadastroF) {
        this.cadastroF = cadastroF;
    }







   




    
    

    
}
