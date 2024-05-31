package projeto.sistema.telas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.ouvintes.OuvinteCadastro;

public class JanelaDeCadastro extends JanelaDefaultLogar{ 
    private JButton botaoCadastrar;
    private JButton botaoCancelar;
    private JTextField campoDoNome;
    private JTextField campoDoLogin;
    private JPasswordField campoDaSenha;
    private JPasswordField campoConfirmar;
    private JTextField campoDoEmail;
    private JTextField campoDaMatricula;
    private JCheckBox checkAlmoxarife;
    private JCheckBox checkCaixa;
    
    public JanelaDeCadastro(SistemaMercado sistema){
        super(sistema);
        setSize(600, 540); 
        adicionarCabecalho("Cadastro");
        setLayout(null);

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();
        JPanel painelCheckers = new JPanel();

        painelTextos.setLayout(new GridLayout(6, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(6, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 30, 0));
        painelCheckers.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        painelTextos.setBounds(50, 100, 100, 300);
        painelCampos.setBounds(150, 100, 400, 300);
        painelBotoes.setBounds(250, 420, 300, 50);
        painelCheckers.setBounds(300, 70, 250, 30);

        JLabel textoNome = new JLabel("Nome:");
        JLabel textoLogin = new JLabel("Login:");
        JLabel textoSenha = new JLabel("Senha:");
        JLabel textoConfirmar = new JLabel("Confirmar:");
        JLabel textoEmail = new JLabel("E-mail:");
        JLabel textoMatricula = new JLabel("Pis/NIS: ");

        campoDoNome = new JTextField(30);
        campoDoLogin = new JTextField(15);
        campoDaSenha = new JPasswordField(15);
        campoConfirmar = new JPasswordField(15);
        campoDoEmail = new JTextField(30);
        campoDaMatricula = new JTextField(15);

        checkAlmoxarife = new JCheckBox("Almoxarife");
        checkCaixa = new JCheckBox("Caixa Eletronico");
        botaoCadastrar = new JButton("Cadastrar");
        botaoCancelar  = new JButton("Cancelar");

        JComponent[] componentes = {textoNome, textoLogin, textoSenha,
                                    textoConfirmar, textoEmail, textoMatricula,
                                    campoDoNome,campoDoLogin, campoDaSenha, campoConfirmar,
                                    campoDoEmail,campoDaMatricula, botaoCadastrar, botaoCancelar };
        adicionarFontes(componentes);

        painelTextos.add(textoNome);
        painelTextos.add(textoLogin);
        painelTextos.add(textoSenha);
        painelTextos.add(textoConfirmar);
        painelTextos.add(textoEmail);
        painelTextos.add(textoMatricula);

        painelCampos.add(campoDoNome);
        painelCampos.add(campoDoLogin);
        painelCampos.add(campoDaSenha);
        painelCampos.add(campoConfirmar);
        painelCampos.add(campoDoEmail);
        painelCampos.add(campoDaMatricula);

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoCancelar);
        painelCheckers.add(checkAlmoxarife);
        painelCheckers.add(checkCaixa);
        
    
        add(painelTextos);
        add(painelCampos);
        add(painelCheckers);
        add(painelBotoes);
        
        OuvinteCadastro ouvinteCadastro = new OuvinteCadastro(this, sistema);
        getCheckAlmoxarife().addActionListener(ouvinteCadastro);
        getCheckCaixa().addActionListener(ouvinteCadastro);
        getBotaoCadastrar().addActionListener(ouvinteCadastro);
        getBotaoCancelar().addActionListener(ouvinteCadastro);
        setVisible(true);
    }

    public JCheckBox adicionarCheckBox(String texto,int [] bounds){
        JCheckBox checkBox = new JCheckBox(texto);
        checkBox.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        add(checkBox);
        if(sistema.isSemGerente()){
            checkBox.setVisible(false);
        }
        return checkBox;
    }
    public JButton getBotaoCadastrar() {
        return botaoCadastrar;
    }

    public void setBotaoCadastrar(JButton botaoCadastrar) {
        this.botaoCadastrar = botaoCadastrar;
    }

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public void setBotaoCancelar(JButton botaoCancelar) {
        this.botaoCancelar = botaoCancelar;
    }

    public JTextField getCampoDoNome() {
        return campoDoNome;
    }

    public void setCampoDonome(JTextField campoDonome) {
        this.campoDoNome = campoDonome;
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

    public void setCampoDaSenha(JPasswordField campoDaSenha) {
        this.campoDaSenha = campoDaSenha;
    }

    public void setCampoConfirmar(JPasswordField campoConfirmar){
        this.campoConfirmar = campoConfirmar;
    }

    public JPasswordField getCampoConfirmar(){
        return campoConfirmar;
    }

    public JTextField getCampoDoEmail() {
        return campoDoEmail;
    }

    public void setCampoDoEmail(JTextField campoDoEmail) {
        this.campoDoEmail = campoDoEmail;
    }

    public JTextField getCampoDaMatricula() {
        return campoDaMatricula;
    }

    public void setCampoDaMatricula(JTextField campoDaMatricula) {
        this.campoDaMatricula = campoDaMatricula;
    }

    public JCheckBox getCheckAlmoxarife() {
        return checkAlmoxarife;
    }

    public void setCheckAlmoxarife(JCheckBox checkAlmoxarife) {
        this.checkAlmoxarife = checkAlmoxarife;
    }

    public JCheckBox getCheckCaixa() {
        return checkCaixa;
    }

    public void setCheckCaixa(JCheckBox checkCaixa) {
        this.checkCaixa = checkCaixa;
    }

    
    
}