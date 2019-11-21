package br.com.bandtec.projetopw.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="cidadao")
public class Cidadao {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@Embedded
	private CPF cpf;
	private Integer idade;

	@OneToMany(mappedBy = "cidadao")
	private List<ConsultaNoSUS> consultas;
	
	protected Cidadao() {}
	
	public Cidadao(String nome, CPF cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.consultas = new ArrayList<>();
	}

	public void inserir(ConsultaNoSUS consultas) {
		this.consultas.add(consultas);
		consultas.setCidadao(this);
	}

	public Long getId() {
		return id;
	}

	public boolean contem(ConsultaNoSUS consulta) {
		return consultas.contains(consulta);
	}

	public int lerIdade() {
		return idade;
	}

	public List<ConsultaNoSUS> getConsultas() {
		return consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidadao other = (Cidadao) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
}
