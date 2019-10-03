package br.com.bandtec.agendadeobjetivos.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity //Objeto que vai persistir em banco
@Table(name = "tbObjetivo")
public class Objetivo {

    @Id
    @GeneratedValue
    private Long idObjetivo;

    @Column(name = "tituloObjetivo")
    @JsonProperty
    private String titulo;

    @Column(name = "descricaoObjetivo")
    @JsonProperty
    private String descricao;

    @Column(name = "dataMaxObjetivo")
    @JsonProperty
    private LocalDate dataMaximaParaExecucao;

    @Embedded
    @JsonProperty
    private Prioridade prioridade;

    public Objetivo() {}


    public Objetivo(String titulo, String descricao, LocalDate dataMaximaParaExecucao, Prioridade prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataMaximaParaExecucao = dataMaximaParaExecucao;
        this.prioridade = prioridade;
    }


    @Override
    public String toString() {
        return "Objetivo [titulo=" + titulo + ", descricao=" + descricao + ", dataMaximaParaExecucao="
                + dataMaximaParaExecucao + "]";
    }

    public boolean ate(LocalDate data) {
        return dataMaximaParaExecucao.isBefore(data) || dataMaximaParaExecucao.isEqual(data);
    }


	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getDataMaximaParaExecucao() {
		return dataMaximaParaExecucao;
	}
}
