package mz.pled.mgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "categoria")
public class Actividade extends AbstractEntity{
	
	
	@Column(name = "designacao")
	private String designacao;
	
	@ManyToOne
	@JoinColumn(name = "projecto_id")
	private Projecto projecto;


	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public Projecto getProjecto() {
		return projecto;
	}

	public void setProjecto(Projecto projecto) {
		this.projecto = projecto;
	}
	
	
}
