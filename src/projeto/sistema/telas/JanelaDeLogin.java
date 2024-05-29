package projeto.sistema.telas;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import projeto.sistema.SistemaMercado;
import projeto.sistema.ouvintes.OuvinteLogin;

public class JanelaDeLogin extends JanelaDefaultLogar{
    private JTextField campoDoLogin;
    private JPasswordField campoDaSenha;
    private JButton botaoLogin;
    private JButton botaoCancelar;

    public JanelaDeLogin(SistemaMercado sistema){
        super(sistema);
        setSize(560, 300); 
        adicionarCabecalho("Login");
        int[] boundsLogin = {30, 100, 120, 30};
        int[] boundsSenha = {30, 145, 120, 30};
        int[] boundsBotaoLogin = {120, 200, 140, 50};
        int[] boundsBotaoCancelar = {290, 200, 140, 50};

        int[] boundsLoginCampo = {boundsLogin[0] + boundsLogin[2] + 10, 100, 280, 30};
        int[] boundsSenhaCampo = {boundsSenha[0] + boundsSenha[2] + 10, 145, 280, 30};

       
        adicionarTexto("Login:", getFonteDoCampo(), boundsLogin);
        setCampoDoLogin((JTextField) adicionarCampo(getFonteDoCampo(), boundsLoginCampo, false));
        adicionarTexto("Senha:", getFonteDoCampo(), boundsSenha);
        setCampoDasenha((JPasswordField) adicionarCampo(getFonteDoCampo(), boundsSenhaCampo, true));
        setBotaoLogin(adicionarBotao("Confirmar", boundsBotaoLogin));
        setBotaoCancelar(adicionarBotao("Cancelar", boundsBotaoCancelar));

        OuvinteLogin login = new OuvinteLogin(this, sistema);
        getBotaoLogin().addActionListener(login);
        getBotaoCancelar().addActionListener(login);
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
