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

        setBotaoConfirmatorio(new JButton("Login"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JComponent[] componentesTextos = {login, senha};
        JTextField [] componentesCampos = {campoDoLogin, campoDaSenha};
        JComponent [] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};
        
        setFonteDoBotao(new Font("arial",Font.BOLD, 15));
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);


        setCampos(componentesCampos);
        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);

        OuvinteLogin ouvinteLogin = new OuvinteLogin(this, sistema);
        getBotaoConfirmatorio().addActionListener(ouvinteLogin);
        getBotaoCancelatorio().addActionListener(ouvinteLogin);
        setVisible(true);
    }

    public JTextField getCampoDoLogin() {
        return campoDoLogin;
    }

    public void setCampoDoLogin(JTextField campoDoLogin) {
        this.campoDoLogin = campoDoLogin;
    }

    public JPasswordField getCampoDaSenha() {
        return campoDaSenha;
    }

    public void setCampoDaSenha(JPasswordField campoDasenha) {
        this.campoDaSenha = campoDasenha;
    }
    
}
