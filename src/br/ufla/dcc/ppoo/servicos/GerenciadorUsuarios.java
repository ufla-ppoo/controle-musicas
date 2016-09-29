package br.ufla.dcc.ppoo.servicos;

import br.ufla.dcc.ppoo.dao.UsuarioDAO;
import br.ufla.dcc.ppoo.dao.lista.UsuarioDAOLista;
import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.modelo.Usuario;
import br.ufla.dcc.ppoo.seguranca.SessaoUsuario;

public class GerenciadorUsuarios {

    private static final UsuarioDAO repositorioUsuario
            = UsuarioDAOLista.obterInstancia();
    private static final SessaoUsuario sessaoUsuario
            = SessaoUsuario.obterInstancia();

    public static void autenticarUsuario(Usuario u) throws Exception {
        Usuario ret = repositorioUsuario.obterUsuarioPeloLogin(u.obterLogin());
        if (ret == null || !u.checarSenha(u.obterSenha())) {
            throw new Exception(I18N.obterErroAutenticacao());
        }
        sessaoUsuario.alterarUsuario(ret);
    }

    public static void cadastrarUsuario(Usuario u) throws Exception {
        Usuario ret = repositorioUsuario.obterUsuarioPeloLogin(u.obterLogin());
        if (ret != null) {
            throw new Exception(I18N.obterErroUsuarioJaCadastrado());
        }
        repositorioUsuario.adicionarUsuario(u);
    }
}
