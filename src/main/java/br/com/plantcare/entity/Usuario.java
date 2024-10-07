package br.com.plantcare.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	@Size(max = 70, message = "O nome não pode ter mais de 70 caracteres")
	private String nome;

	@NotBlank(message = "O e-mail é obrigatório")
	@Email(message = "O e-mail deve ser válido")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "A senha é obrigatória")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	@Pattern(regexp = ".*[A-Z].*", message = "A senha deve conter pelo menos uma letra maiúscula")
	@Pattern(regexp = ".*[a-z].*", message = "A senha deve conter pelo menos uma letra minúscula")
	@Pattern(regexp = ".*\\d.*", message = "A senha deve conter pelo menos um dígito")
	@Pattern(regexp = ".*[@#$%^&+=].*", message = "A senha deve conter pelo menos um caractere especial (@, #, $, %, ^, &, +, =)")
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private List<Planta> plantas;

	public Usuario(){}

	public Usuario(Long id, String nome, String email, String senha, List<Planta> plantas) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.plantas = plantas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Planta> getPlantas() {
		return plantas;
	}

	public void setPlantas(List<Planta> plantas) {
		this.plantas = plantas;
	}

	public Long getId() {
		return id;
	}

}