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
	
	
	@Column(name = "endereco")
	private String endereco;

	@Column(name = "assunto")
	private String assunto;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "origem")
	private String origem;

	@Column(name = "nomeUtente")
	private String nomeUtente;
	
	@Column(name = "data_ocorrencia")
	private String dataOcorrencia;

	@Column(name = "nomedorepresentantedogrupo")
	private String nomeDoRepresentanteDoGrupo;

	@Column(name = "moradaUtente")
	private String moradaUtente;

	@Column(name = "faixaEtaria")
	private String faixaEtaria;

	@Column(name = "nivel")
	private int nivel;

	@ManyToOne
	@JoinColumn(name = "provincia_projecto_id")
	private ProvinciaProjecto provinciaProjecto;
	
	@ManyToOne
	@JoinColumn(name = "canal_entrada_id")
	private CanalEntrada canalEntrada=null;
	
	@ManyToOne
	@JoinColumn(name = "tipo_alerta_id")
	private TipoAlerta tipoAlerta=null;
	
	@ManyToOne
	@JoinColumn(name = "tipo_ocorrencia_id")
	private TipoOcorrencia tipoOcorrencia;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "projecto_id")
	private Projecto projecto;

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public Projecto getProjecto() {
		return projecto;
	}

	public void setProjecto(Projecto projecto) {
		this.projecto = projecto;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNomeDoRepresentanteDoGrupo() {
		return nomeDoRepresentanteDoGrupo;
	}

	public void setNomeDoRepresentanteDoGrupo(String nomeDoRepresentanteDoGrupo) {
		this.nomeDoRepresentanteDoGrupo = nomeDoRepresentanteDoGrupo;
	}

	public String getMoradaUtente() {
		return moradaUtente;
	}

	public void setMoradaUtente(String moradaUtente) {
		this.moradaUtente = moradaUtente;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
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

	public ProvinciaProjecto getProvinciaProjecto() {
		return provinciaProjecto;
	}

	public void setProvinciaProjecto(ProvinciaProjecto provinciaProjecto) {
		this.provinciaProjecto = provinciaProjecto;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(String dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}
	

}
