package br.ufla.dcc.ppoo.dao.lista;

import br.ufla.dcc.ppoo.dao.UsuarioDAO;
import br.ufla.dcc.ppoo.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOLista implements UsuarioDAO {

    private static UsuarioDAOLista instancia;
    private final List<Usuario> listaUsuario;

    private UsuarioDAOLista() {
        listaUsuario = new ArrayList<Usuario>();

        // Cadastrei alguns usuários para testar o programa.
        char[] senha = new char[]{'1', '2', '3'};
        listaUsuario.add(new Usuario("paulo", senha, "Paulo"));
        listaUsuario.add(new Usuario("jose", senha, "José"));
        listaUsuario.add(new Usuario("flavia", senha, "Flávia"));
        listaUsuario.add(new Usuario("matheus", senha, "Matheus"));
        listaUsuario.add(new Usuario("alexandre", senha, "Alexandre"));

    }

    public static UsuarioDAOLista obterInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAOLista();
        }
        return instancia;
    }

    @Override
    public Usuario obterUsuarioPeloLogin(String login) {
        for (Usuario u : listaUsuario) {
            if (login.equals(u.obterLogin())) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void adicionarUsuario(Usuario u) {
        listaUsuario.add(u);
    }
}
