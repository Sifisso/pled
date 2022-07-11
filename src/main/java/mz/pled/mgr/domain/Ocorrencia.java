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

	@Column(name = "nome")
	private String nome;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "assunto")
	private String assunto;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "nivel")
	private int nivel;

	@ManyToOne
	@JoinColumn(name = "provincia_actividade_id")
	private ProvinciaProjecto provinciaActividade;
	
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public ProvinciaProjecto getProvinciaActividade() {
		return provinciaActividade;
	}

	public void setProvinciaActividade(ProvinciaProjecto provinciaActividade) {
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

<<<<<<< HEAD
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
	
	
=======
>>>>>>> branch 'master' of https://github.com/Sifisso/pled.git
}
