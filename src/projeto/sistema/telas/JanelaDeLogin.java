package projeto.sistema.telas;
import javax.swing.JTextField;

import com.fasterxml.jackson.databind.cfg.PackageVersion;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import projeto.sistema.SistemaMercado;
import projeto.sistema.ouvintes.OuvinteLogin;
import java.awt.GridLayout;
public class JanelaDeLogin extends JanelaDefaultLogar{
    private JTextField campoDoLogin;
    private JPasswordField campoDaSenha;
    private JButton botaoLogin;
    private JButton botaoCancelar;

    public JanelaDeLogin(SistemaMercado sistema){
        super(sistema);
        setSize(500, 350); 
        setLayout(null);
        setResizable(false);
        adicionarCabecalho("Login");

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();
        
        painelTextos.setLayout(new GridLayout(6, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(6, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 50, 10));

        painelBotoes.setBounds(100, 230, 300, 50);
       
        painelTextos.setBounds(50, 100,400, 120);

        JLabel login = new  JLabel("Login:");
        JLabel senha = new  JLabel("Senha:");
        campoDoLogin = new JTextField(15);
        campoDaSenha = new JPasswordField(15);
        senha.setFont(getFonteDoCampo());
        login.setFont(getFonteDoCampo());

        botaoLogin = new JButton("Login");
        botaoLogin.setFont(getFonteDoBotao());
        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setFont(getFonteDoBotao());


        OuvinteLogin loginO = new OuvinteLogin(this, sistema);
        getBotaoLogin().addActionListener(loginO);
        getBotaoCancelar().addActionListener(loginO);
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
