package br.ufla.dcc.ppoo.util;

import br.ufla.dcc.ppoo.i18n.I18N;
import javax.swing.JOptionPane;

public class Utilidades {

    public static boolean msgConfirmacao(String mensagem) {
        final int op = JOptionPane.showConfirmDialog(null, mensagem,
                I18N.obterTituloMensagemConfirmacao(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return op == JOptionPane.YES_OPTION;
    }

    public static void msgInformacao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                I18N.obterTituloMensagemInformacao(), JOptionPane.INFORMATION_MESSAGE);

    }
    
    public static void msgErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem,
                I18N.obterTituloMensagemErro(), JOptionPane.ERROR_MESSAGE);

    }
}
