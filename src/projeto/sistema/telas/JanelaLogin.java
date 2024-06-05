package projeto.sistema.telas;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import projeto.sistema.SistemaMercado;
import projeto.sistema.ouvintes.OuvinteLogin;
import java.awt.Font;
import java.awt.GridLayout;

public class JanelaLogin extends JanelaBaseFormularios{
    private JTextField campoDoLogin;
    private JPasswordField campoDaSenha;
    private JButton botaoLogin;
    private JButton botaoCancelar;

    public JanelaLogin(SistemaMercado sistema){
        super(sistema);
        setSize(500, 300); 
        setLayout(null);
        setLocationRelativeTo(null);

        adicionarCabecalho("Login");
        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();
        
        painelTextos.setLayout(new GridLayout(2, 1, 0, 10));
        painelCampos.setLayout(new GridLayout(2, 1, 0, 10));
        painelBotoes.setLayout(new GridLayout(1, 2, 10, 10));

        painelTextos.setBounds(90, 100, 80, 70);
        painelCampos.setBounds(170, 100, 220,70);
        painelBotoes.setBounds(170, 190, 220, 50);

        JLabel login = new  JLabel("Login:");
        JLabel senha = new  JLabel("Senha:");

        campoDoLogin = new JTextField(15);
        campoDaSenha = new JPasswordField(15);

        botaoLogin = new JButton("Login");
        botaoCancelar = new JButton("Cancelar");

        JComponent[] componentesTextos = {login, senha};
        JComponent [] componentesCampos = {campoDoLogin, campoDaSenha};
        JComponent [] componentesBotoes = {botaoLogin, botaoCancelar};

        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        setFonteDoBotao(new Font("arial",Font.BOLD, 15));
        adicionarFontes(componentesBotoes);
        
        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);

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
