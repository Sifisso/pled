package mz.pled.mgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "anexo_ocorrencia")
public class AnexoOcorrencia extends AbstractEntity{
	
	@Column(name = "designacao")
	private String designacao;
	

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}
	
}
