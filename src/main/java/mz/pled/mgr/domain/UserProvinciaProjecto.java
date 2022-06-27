package mz.pled.mgr.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "userprovinciaprojecto")
public class UserProvinciaProjecto extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "provinciaprojecto_id")
    private ProvinciaProjecto provinciaProjecto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ProvinciaProjecto getProvinciaProjecto() {
        return provinciaProjecto;
    }

    public void setProvinciaProjecto(ProvinciaProjecto provinciaProjecto) {
        this.provinciaProjecto = provinciaProjecto;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
