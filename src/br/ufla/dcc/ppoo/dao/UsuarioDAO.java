package br.ufla.dcc.ppoo.dao;

import br.ufla.dcc.ppoo.modelo.Usuario;

public interface UsuarioDAO {
    public Usuario obterUsuarioPeloLogin(String login);
    public void adicionarUsuario(Usuario u);
    
}
