package br.ufla.dcc.ppoo.modelo;

import java.util.Arrays;

/**
 * Representa um usuário do sistema.
 */
public class Usuario {
    private String login;
    private char[] senha;
    private String nome;

    public Usuario(String login, char[] senha, String nome) {
        this.login = login;
        this.senha = Arrays.copyOf(senha, senha.length);
        this.nome = nome;
    }
    
    public Usuario(String login, char[] senha) {
        this.login = login;
        this.senha = Arrays.copyOf(senha, senha.length);
        this.nome = "";
    }
    
    public boolean checarSenha(char[] senha) {
        return (Arrays.equals(this.senha, senha));
    }

    public String obterLogin() {
        return login;
    }

    public char[] obterSenha() {
        return senha;
    }

    public String obterNome() {
        return nome;
    }
    
    
}
