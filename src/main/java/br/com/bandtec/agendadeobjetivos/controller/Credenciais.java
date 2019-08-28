package br.com.bandtec.agendadeobjetivos.controller;

public class Credenciais {

    private String login;
    private String senha;

    public Credenciais(String login, String senha) {
        this.setLogin(login);
        this.setSenha(senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
