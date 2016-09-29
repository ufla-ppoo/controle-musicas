package br.ufla.dcc.ppoo.seguranca;

import br.ufla.dcc.ppoo.modelo.Usuario;

public class SessaoUsuario {
    private static SessaoUsuario instancia;
    private Usuario usuario;
    
    private SessaoUsuario() {}
    
    public static SessaoUsuario obterInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }
    
    public Usuario obterUsuario() {
        return this.usuario;
    }
    
    public boolean estahLogado() {
        return (this.usuario != null);
    }
    
    public void alterarUsuario(Usuario u) {
        this.usuario = u;
    }
    
    public void invalidarSessao() {
        this.usuario = null;
    }
}
