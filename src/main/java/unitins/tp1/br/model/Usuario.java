package unitins.tp1.br.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity {

    @Column(length = 30, unique = true)
    private String username;

    @Column(length = 88)
    private String senha;
    
    @OneToOne
    @JoinColumn(name = "id_usuariofisico", unique = true)
    private UsuarioFisico usuarioFisico;

    
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

   
    public String getSenha() {
        return senha;
    }

 
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public UsuarioFisico getUsuarioFisico() {
        return usuarioFisico;
    }


    public void setUsuarioFisico(UsuarioFisico usuarioFisico) {
        this.usuarioFisico = usuarioFisico;
    }

    
}  
    

