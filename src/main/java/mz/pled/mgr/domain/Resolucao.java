package mz.pled.mgr.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "resolucao")
public class Resolucao extends AbstractEntity{

	@Column(name = "designacao")
	private String designacao;

	@Column(name = "motivo")
	private String motivo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "mediador")
	private String mediador;

	@Column(name = "tipo")
	private String tipo;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "dataresolucao")
	private Date dataResolucao;

	@ManyToOne
	@JoinColumn(name="responsabilidade_id")
	private Responsabilidade responsabilidade;

	@ManyToOne
	@JoinColumn(name="ocorrencia_id")
	private Ocorrencia ocorrencia;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMediador() {
		return mediador;
	}

	public void setMediador(String mediador) {
		this.mediador = mediador;
	}

	public Date getDataResolucao() {
		return dataResolucao;
	}

	public void setDataResolucao(Date dataResolucao) {
		this.dataResolucao = dataResolucao;
	}

	public Responsabilidade getResponsabilidade() {
		return responsabilidade;
	}

	public void setResponsabilidade(Responsabilidade responsabilidade) {
		this.responsabilidade = responsabilidade;
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
