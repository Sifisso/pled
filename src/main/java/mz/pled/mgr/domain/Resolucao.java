package mz.pled.mgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "provincia")
public class Resolucao extends AbstractEntity{
	
	@Column(name = "designacao")
	private String designacao;
	
	@ManyToOne
	@JoinColumn(name = "anexo_id")
	private AnexoResolucao anexo;
	
	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public AnexoResolucao getAnexo() {
		return anexo;
	}

	public void setAnexo(AnexoResolucao anexo) {
		this.anexo = anexo;
	}

}
