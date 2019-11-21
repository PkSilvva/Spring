package br.com.bandtec.projetopw.domain;

import br.com.bandtec.projetopw.controller.Credenciais;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Embedded
	@JsonProperty
	private Credenciais credenciais;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	protected Usuario() {}
	
	public Usuario(String login, String senha) {
		this.credenciais = new Credenciais(login, senha);
	}

	public UUID getId() {
		return id;
	}

	public void atualizarSenha(String novaSenha) {
		this.credenciais.setSenha(novaSenha);
	}

	@JsonIgnore
	public String getSenha() {
		return this.credenciais.getSenha();
	}
}
