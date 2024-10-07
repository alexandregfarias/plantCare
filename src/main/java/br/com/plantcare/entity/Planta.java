package br.com.plantcare.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome da planta é obrigatório")
	private String nome;

	private String especie;
	private LocalDate dataDeAquisicao;
	private LocalDate ultimaRegagem;
	private LocalDate proximaAdubacao;

	@Size(max = 255, message = "As observações não podem ter mais de 255 caracteres")
	private String observacoes;

	private String mensagemDaSemana;

	@Lob
	private byte[] foto;

	@ManyToOne
	@JsonIgnore
	private Usuario usuario;

	public Planta() {}

	public Planta(Long id, String nome, String especie, LocalDate dataDeAquisicao, LocalDate ultimaRegagem,
			LocalDate proximaAdubacao, String observacoes, String mensagemDaSemana, byte[] foto, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.dataDeAquisicao = dataDeAquisicao;
		this.ultimaRegagem = ultimaRegagem;
		this.proximaAdubacao = proximaAdubacao;
		this.observacoes = observacoes;
		this.mensagemDaSemana = mensagemDaSemana;
		this.foto = foto;
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getDataDeAquisicao() {
		return dataDeAquisicao;
	}

	public void setDataDeAquisicao(LocalDate dataDeAquisicao) {
		this.dataDeAquisicao = dataDeAquisicao;
	}

	public LocalDate getUltimaRegagem() {
		return ultimaRegagem;
	}

	public void setUltimaRegagem(LocalDate ultimaRegagem) {
		this.ultimaRegagem = ultimaRegagem;
	}

	public LocalDate getProximaAdubacao() {
		return proximaAdubacao;
	}

	public void setProximaAdubacao(LocalDate proximaAdubacao) {
		this.proximaAdubacao = proximaAdubacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getMensagemDaSemana() {
		return mensagemDaSemana;
	}

	public void setMensagemDaSemana(String mensagemDaSemana) {
		this.mensagemDaSemana = mensagemDaSemana;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}	

}
