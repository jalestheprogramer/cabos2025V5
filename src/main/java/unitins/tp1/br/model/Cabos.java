package unitins.tp1.br.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cabos extends DefaultEntity {

    @Column(length = 60, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tecnologia tecnologia;

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }
}
