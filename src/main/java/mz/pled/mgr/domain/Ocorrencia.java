package mz.pled.mgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ocorrencia")
public class Ocorrencia extends AbstractEntity{
	
	
	@Column(name = "designacao")
	private String designacao;

	@ManyToOne
	@JoinColumn(name = "provincia_actividade_id")
	private ProvinciaActividade provinciaActividade;
	
	@ManyToOne
	@JoinColumn(name = "canal_entrada_id")
	private CanalEntrada canalEntrada;
	
	@ManyToOne
	@JoinColumn(name = "tipo_alerta_id")
	private TipoAlerta tipoAlerta;
	
	@ManyToOne
	@JoinColumn(name = "tipo_ocorrencia_id")
	private TipoOcorrencia tipoOcorrencia;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "anexo_id")
	private AnexoOcorrencia anexo;
	
	@ManyToOne
	@JoinColumn(name = "resolucao_id")
	private Resolucao resolucao;

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public ProvinciaActividade getProvinciaActividade() {
		return provinciaActividade;
	}

	public void setProvinciaActividade(ProvinciaActividade provinciaActividade) {
		this.provinciaActividade = provinciaActividade;
	}

	public CanalEntrada getCanalEntrada() {
		return canalEntrada;
	}

	public void setCanalEntrada(CanalEntrada canalEntrada) {
		this.canalEntrada = canalEntrada;
	}

	public TipoAlerta getTipoAlerta() {
		return tipoAlerta;
	}

	public void setTipoAlerta(TipoAlerta tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}

	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public AnexoOcorrencia getAnexo() {
		return anexo;
	}

	public void setAnexo(AnexoOcorrencia anexo) {
		this.anexo = anexo;
	}

	public Resolucao getResolucao() {
		return resolucao;
	}

	public void setResolucao(Resolucao resolucao) {
		this.resolucao = resolucao;
	}
}
