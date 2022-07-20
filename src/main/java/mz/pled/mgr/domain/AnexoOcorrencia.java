package mz.pled.mgr.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "anexo_ocorrencia")
public class AnexoOcorrencia extends AbstractEntity{


	private String docName;
	private String docType;
	private String descricao;


	@ManyToOne
	@JoinColumn(name="ocorrencia_id")
	private Ocorrencia ocorrencia;

	private String fase;

	@Lob
	private byte[] data;

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
