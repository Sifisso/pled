package mz.pled.mgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "actividade_user")
public class ActividadeUser extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "provincia_actividade_id")
	private ProvinciaActividade provinciaActividade;
	
	@Column(name = "designacao")
	private String designacao;
	

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProvinciaActividade getProvinciaActividade() {
		return provinciaActividade;
	}

	public void setProvinciaActividade(ProvinciaActividade provinciaActividade) {
		this.provinciaActividade = provinciaActividade;
	}
	
}
