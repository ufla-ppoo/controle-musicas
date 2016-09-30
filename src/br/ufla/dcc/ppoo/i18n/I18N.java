package br.ufla.dcc.ppoo.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18N {

    private static final String CAMINHO_ARQUIVOBASE_I18N = "br/ufla/dcc/ppoo/i18n/Strings";
    private static ResourceBundle rb = ResourceBundle.getBundle(CAMINHO_ARQUIVOBASE_I18N, Locale.getDefault());
    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale EN_US = new Locale("en", "US");

    public static void alterarLocalidade(Locale localidade) {
        Locale.setDefault(localidade);
        rb = ResourceBundle.getBundle(CAMINHO_ARQUIVOBASE_I18N, localidade);
    }

    public static String obterNomeDoSistema() {
        return rb.getString("sistema.nome");
    }

    public static String obterMenuInicio() {
        return rb.getString("menu.inicio");
    }

    public static char obterMnemonicoMenuInicio() {
        return rb.getString("mnemonico.menu.inicio").charAt(0);
    }

    public static String obterMenuEntrar() {
        return rb.getString("menu.inicio.entrar");
    }

    public static String obterMenuMeusLivros() {
        return rb.getString("menu.inicio.meus_livros");
    }

    public static String obterMenuCadastrarUsuario() {
        return rb.getString("menu.inicio.cadastrar");
    }

    public static String obterMenuSair() {
        return rb.getString("menu.inicio.sair");
    }

    public static String obterMenuLogout() {
        return rb.getString("menu.inicio.logout");
    }

    public static String obterMenuIdioma() {
        return rb.getString("menu.idioma");
    }

    public static char obterMnemonicoMenuIdioma() {
        return rb.getString("mnemonico.menu.idioma").charAt(0);
    }

    public static String obterMenuIdiomaPortugues() {
        return rb.getString("menu.idioma.pt_br");
    }

    public static String obterMenuIdiomaIngles() {
        return rb.getString("menu.idioma.en_us");
    }

    public static String obterMenuAjuda() {
        return rb.getString("menu.ajuda");
    }

    public static char obterMnemonicoMenuAjuda() {
        return rb.getString("mnemonico.menu.ajuda").charAt(0);
    }

    public static String obterMenuSobre() {
        return rb.getString("menu.ajuda.sobre");
    }

    public static String obterConfirmacaoSaida() {
        return rb.getString("confirmacao.saida.descricao");
    }

    public static String obterConfirmacaoDeletar() {
        return rb.getString("confirmacao.deletar.descricao");
    }

    public static String obterErroAutenticacao() {
        return rb.getString("erro.usuario.autenticacao");
    }

    public static String obterErroUsuarioJaCadastrado() {
        return rb.getString("erro.usuario.ja_cadastrado");
    }

    public static String obterErroSenhasNaoConferem() {
        return rb.getString("erro.usuario.senhas_nao_conferem");
    }

    public static String obterSucessoCadastroUsuario() {
        return rb.getString("sucesso.usuario.cadastro");
    }

    public static String obterTituloMensagemConfirmacao() {
        return rb.getString("confirmacao.titulo");
    }

    public static String obterMensagemSobre() {
        return rb.getString("sistema.sobre");
    }

    public static String obterTituloMensagemInformacao() {
        return rb.getString("informacao.titulo");
    }

    public static String obterTituloMensagemErro() {
        return rb.getString("erro.titulo");
    }

    public static String obterTituloTelaAutenticacao() {
        return rb.getString("tela.autenticacao.titulo");
    }

    public static String obterTituloTelaPrincipal() {
        return obterNomeDoSistema();
    }

    public static String obterTituloTelaMeusLivros() {
        return rb.getString("tela.meuslivros.titulo");
    }

    public static String obterTituloTelaCadastrarUsuario() {
        return rb.getString("tela.cadastrousuario.titulo");
    }

    public static String obterRotuloUsuarioLogin() {
        return rb.getString("rotulo.usuario.login");
    }

    public static String obterRotuloUsuarioSenha() {
        return rb.getString("rotulo.usuario.senha");
    }

    public static String obterBotaoEntrar() {
        return rb.getString("botao.entrar");
    }

    public static String obterBotaoCancelar() {
        return rb.getString("botao.cancelar");
    }

    public static String obterBotaoSalvar() {
        return rb.getString("botao.salvar");
    }

    public static String obterBotaoNovo() {
        return rb.getString("botao.novo");
    }

    public static String obterBotaoEditar() {
        return rb.getString("botao.editar");
    }

    public static String obterBotaoDeletar() {
        return rb.getString("botao.deletar");
    }

    public static String obterRotuloUsuarioNome() {
        return rb.getString("rotulo.usuario.nome");
    }

    public static String obterRotuloLivroTitulo() {
        return rb.getString("rotulo.livro.titulo");
    }

    public static String obterRotuloLivroAutores() {
        return rb.getString("rotulo.livro.autores");
    }

    public static String obterRotuloLivroAno() {
        return rb.getString("rotulo.livro.ano");
    }

    public static String obterRotuloLivroPaginas() {
        return rb.getString("rotulo.livro.numpaginas");
    }

    public static String obterRotuloLivroDescricao() {
        return rb.getString("rotulo.livro.descricao");
    }

    public static String obterRotuloUsuarioConfirmarSenha() {
        return rb.getString("rotulo.usuario.confirmar_senha");
    }

    public static String obterColunaTituloLivro() {
        return rb.getString("coluna.titulolivro");
    }

    public static String obterColunaAutoresLivro() {
        return rb.getString("coluna.autoreslivro");
    }

}
