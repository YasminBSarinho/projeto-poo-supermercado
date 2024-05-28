package projeto.sistema.telas;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import projeto.sistema.SistemaMercado;

public class JanelaDeLogin extends JanelaPadrao{
    private JTextField campoDoLogin;
    private JPasswordField campoDaSenha;
    private JButton botaoLogin;
    private JButton botaoCancelar;

    public JanelaDeLogin(SistemaMercado sistema){
        super(sistema);
        setSize(560, 300); 
        adicionarCabecalho("Login");
        int[] boundsLogin = {90, 100, 65, 30};
        int[] boundsSenha = {90, 145, 65, 30};
        int[] boundsBotaoLogin = {100, 200, 140, 50};
        int[] boundsBotaoCancelar = {305, 200, 140, 50};

        setCampoDoLogin((JTextField) adicionarCampo("Login:", getFonteDoCampo(), boundsLogin,false));
        setCampoDasenha((JPasswordField) adicionarCampo("Senha:", getFonteDoCampo(), boundsSenha, true));
        setBotaoLogin(adicionarBotao("Confirmar", boundsBotaoLogin));
        setBotaoCancelar(adicionarBotao("Cancelar", boundsBotaoCancelar));
        setVisible(true);
    }

    public JTextField getCampoDoLogin() {
        return campoDoLogin;
    }

    public void setCampoDoLogin(JTextField campoDoLogin) {
        this.campoDoLogin = campoDoLogin;
    }

    public JPasswordField getCampoDasenha() {
        return campoDaSenha;
    }

    public void setCampoDasenha(JPasswordField campoDasenha) {
        this.campoDaSenha = campoDasenha;
    }

    public JButton getBotaoLogin() {
        return botaoLogin;
    }

    public void setBotaoLogin(JButton botaoLogin) {
        this.botaoLogin = botaoLogin;
    }

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public void setBotaoCancelar(JButton botaoCancelar) {
        this.botaoCancelar = botaoCancelar;
    }

    
}
