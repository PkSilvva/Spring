package br.com.bandtec.agendadeobjetivos.domain;

import br.com.bandtec.agendadeobjetivos.controller.Credenciais;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tbUsuario")
public class Usuario {
	private String nome;
	private Integer idade;

	@Id
	@GeneratedValue
	private Long IdUsuario;

	@Embedded
	private Credenciais credenciais;

	public Usuario(){}

	public Usuario(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public String getNome() {
		return nome;
	}

	public Long getIdUsuario() { return IdUsuario; }

}
