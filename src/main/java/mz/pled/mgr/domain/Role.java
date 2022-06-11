package mz.pled.mgr.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity implements GrantedAuthority {

    private String role;
    private String designacao;
    private String descricao;

    @ManyToMany(mappedBy="roles")
    private List<User> usuario;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<User> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<User> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.role;
    }
}
