package br.ufla.dcc.ppoo.gui;

import br.ufla.dcc.ppoo.i18n.I18N;
import br.ufla.dcc.ppoo.imagens.GerenciadorDeImagens;
import br.ufla.dcc.ppoo.seguranca.SessaoUsuario;
import br.ufla.dcc.ppoo.util.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal {

    private final SessaoUsuario sessaoUsuario;
    private final TelaAutenticacao telaAutenticacao;
    private final TelaCadastroUsuario telaCadastroUsuario;
    private JFrame janela;

    private JMenuBar menuPrincipal;
    private JMenu menuInicio;
    private JMenu menuIdioma;
    private JMenu menuAjuda;

    private JMenuItem menuEntrar;
    private JMenuItem menuCadastrarUsuario;
    private JMenuItem menuIdiomaPortugues;
    private JMenuItem menuIdiomaIngles;
    private JMenuItem menuSair;
    private JMenuItem menuLogout;
    private JMenuItem menuSobre;

    public TelaPrincipal() {
        telaAutenticacao = new TelaAutenticacao(this);
        telaCadastroUsuario = new TelaCadastroUsuario(this);
        sessaoUsuario = SessaoUsuario.obterInstancia();
    }

    public void inicializar() {
        // Serve para o caso em que o usuário
        // decidiu mudar o idioma da aplicação.
        if (janela != null) {
            janela.dispose();
        }
        construirTela();
        configurarEventosTela();
        exibirTela();
    }

    private void configurarEventosTela() {
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Utilidades.msgConfirmacao(I18N.obterConfirmacaoSaida())) {
                    System.exit(0);
                }
            }
        });

        menuIdiomaPortugues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.PT_BR);
                inicializar();
            }
        });

        menuIdiomaIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.EN_US);
                inicializar();
            }
        });

        menuEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAutenticacao.inicializar();
            }
        });

        menuLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sessaoUsuario.invalidarSessao();
                inicializar();
            }
        });

        menuCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroUsuario.inicializar();
            }
        });

        menuSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilidades.msgInformacao(I18N.obterMensagemSobre());
            }
        });

        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (Utilidades.msgConfirmacao(I18N.obterConfirmacaoSaida())) {
                    System.exit(0);
                }
            }
        });
    }

    private void construirMenuInicio() {
        menuInicio = new JMenu(I18N.obterMenuInicio());
        menuInicio.setMnemonic(I18N.obterMnemonicoMenuInicio());
        menuEntrar = new JMenuItem(I18N.obterMenuEntrar(), GerenciadorDeImagens.ENTRAR);
        menuCadastrarUsuario = new JMenuItem(I18N.obterMenuCadastrarUsuario(), GerenciadorDeImagens.CADASTRAR_USUARIO);
        menuLogout = new JMenuItem(I18N.obterMenuLogout(), GerenciadorDeImagens.LOGOUT);

        if (!sessaoUsuario.estahLogado()) {
            menuInicio.add(menuEntrar);
            menuInicio.add(menuCadastrarUsuario);
        } else {
            // Aqui você poderá adicionar outros menus adequados
            // ao seu projeto que serão exibidos quando o
            // usuário estiver logado no sistema.

            menuInicio.add(menuLogout);
        }

        menuSair = new JMenuItem(I18N.obterMenuSair(), GerenciadorDeImagens.SAIR);
        menuInicio.addSeparator();
        menuInicio.add(menuSair);
        menuPrincipal.add(menuInicio);
    }

    private void construirMenuIdioma() {
        menuIdioma = new JMenu(I18N.obterMenuIdioma());
        menuIdioma.setMnemonic(I18N.obterMnemonicoMenuIdioma());
        menuIdiomaPortugues = new JMenuItem(I18N.obterMenuIdiomaPortugues(), GerenciadorDeImagens.BANDEIRA_BR);
        menuIdiomaIngles = new JMenuItem(I18N.obterMenuIdiomaIngles(), GerenciadorDeImagens.BANDEIRA_GB);
        menuIdioma.add(menuIdiomaPortugues);
        menuIdioma.add(menuIdiomaIngles);
        menuPrincipal.add(menuIdioma);
    }

    private void construirMenuAjuda() {
        menuAjuda = new JMenu(I18N.obterMenuAjuda());
        menuAjuda.setMnemonic(I18N.obterMnemonicoMenuAjuda());
        menuSobre = new JMenuItem(I18N.obterMenuSobre(), GerenciadorDeImagens.SOBRE);
        menuAjuda.add(menuSobre);
        menuPrincipal.add(menuAjuda);
    }

    private void construirMenuUsuario() {
        menuPrincipal = new JMenuBar();
        construirMenuInicio();

        if (sessaoUsuario.estahLogado()) {
            // Aqui você poderá adicionar outros menus adequados
            // ao seu projeto que serão exibidos quando o
            // usuário estiver logado no sistema.
        }

        construirMenuIdioma();
        construirMenuAjuda();
        janela.setJMenuBar(menuPrincipal);
    }

    private void construirTela() {
        janela = new JFrame(I18N.obterTituloTelaPrincipal());
        janela.setTitle(I18N.obterNomeDoSistema());
        construirMenuUsuario();
    }

    private void exibirTela() {
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setVisible(true);
        janela.setResizable(false);
    }

    public static void main(String[] args) {
        new TelaPrincipal().inicializar();
    }

    public JFrame obterJanela() {
        return this.janela;
    }

}
