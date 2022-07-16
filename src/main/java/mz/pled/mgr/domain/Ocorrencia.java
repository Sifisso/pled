package mz.pled.mgr.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "ocorrencia")
public class Ocorrencia extends AbstractEntity{

	@Column(name = "grm_stamp")
	private String grmStamp;

	@Column(name = "resolucao")
	private String resolucao="P";

	@Column(name = "procedencia")
	private String procedencia;

	@Column(name = "nome")
	private String nome;

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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "data_ocorrencia")
	private Date dataOcorrencia;

	@Column(name = "nomedorepresentantedogrupo")
	private String nomeDoRepresentanteDoGrupo;

	@Column(name = "moradaUtente")
	private String moradaUtente;

	@Column(name = "faixaEtaria")
	private String faixaEtaria;

	@Column(name = "nivel")
	private long nivelresolucao=1;

	@Column(name = "validado")
	private boolean validado;

	@Column(name = "temporario")
	private boolean temporario;

	@Column(name = "comunidade")
	private String comunidade;

	@Column(name = "estado")
	private String estado="Registado";
	
	@ManyToOne
	@JoinColumn(name="posto_id")
	private PostoAdministrativo postoAdministrativo;

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
	@JoinColumn(name = "actividade_id")
	private Actividade actividade;

	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;

	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;

	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private User responsavel;

	@ManyToOne
	@JoinColumn(name = "projecto_id")
	private Projecto projecto;

	public String getComunidade() {
		return comunidade;
	}
	public void setComunidade(String comunidade) {
		this.comunidade = comunidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Actividade getActividade() {
		return actividade;
	}

	public void setActividade(Actividade actividade) {
		this.actividade = actividade;
	}

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

	public String getGrmStamp() {
		return grmStamp;
	}

	public void setGrmStamp(String grmStamp) {
		this.grmStamp = grmStamp;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public long getNivelresolucao() {
		return nivelresolucao;
	}

	public void setNivelresolucao(long nivelresolucao) {
		this.nivelresolucao = nivelresolucao;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	public boolean isTemporario() {
		return temporario;
	}

	public void setTemporario(boolean temporario) {
		this.temporario = temporario;
	}

	public User getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(User responsavel) {
		this.responsavel = responsavel;
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

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public PostoAdministrativo getPostoAdministrativo() {
		return postoAdministrativo;
	}

	public void setPostoAdministrativo(PostoAdministrativo postoAdministrativo) {
		this.postoAdministrativo = postoAdministrativo;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

}
