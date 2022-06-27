package mz.pled.mgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "provincia_projecto")
public class ProvinciaProjecto extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;
	
	@ManyToOne
	@JoinColumn(name = "projecto_id")
	private Projecto projecto;
	
	@Column(name = "designacao")
	private String designacao;
	

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Projecto getProjecto() {
		return projecto;
	}

	public void setProjecto(Projecto projecto) {
		this.projecto = projecto;
	}

	
}
