package mz.pled.mgr.domain;

import javax.persistence.*;

@Entity
@Table(name = "posto_administrativo")
public class PostoAdministrativo extends AbstractEntity{

    @Column(name = "designacao", nullable = false,length=120,unique=true)
    private String designacao;

    @ManyToOne
    @JoinColumn(name="distrito_id")
    private Distrito distrito;

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
