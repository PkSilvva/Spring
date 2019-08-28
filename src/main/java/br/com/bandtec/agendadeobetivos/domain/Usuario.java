package br.com.bandtec.agendadeobetivos.domain;

public class Usuario {

    private String nome;
    private Integer idade ;

    public Usuario(String nome, Integer idade) {
        this.setNome(nome);
        this.setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
