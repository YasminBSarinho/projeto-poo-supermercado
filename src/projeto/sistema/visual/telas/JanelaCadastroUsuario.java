package projeto.sistema.visual.telas;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.ouvintes.OuvinteCadastroUsuario;

public class JanelaCadastroUsuario extends JanelaDeCampos{ 
    private JTextField campoDoNome;
    private JTextField campoDoLogin;
    private JPasswordField campoDaSenha;
    private JPasswordField campoConfirmar;
    private JTextField campoDoEmail;
    private JTextField campoDaMatricula;
    private JCheckBox checkAlmoxarife;
    private JCheckBox checkCaixa;
    private JCheckBox checkEmail;
    private JCheckBox checkNisPis;
    
    public JanelaCadastroUsuario(SistemaMercado sistema){
        super(sistema);
        setSize(600, 540); 
        setLayout(null);
        setLocationRelativeTo(null);

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();
        JPanel painelCheckers = new JPanel();
        JPanel painelCheckersCampo = new JPanel();

        painelTextos.setLayout(new GridLayout(6, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(6, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 100, 0));
        painelCheckers.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        painelCheckersCampo.setLayout(new GridLayout(2, 1, 0, 0));
        
        painelTextos.setBounds(50, 100, 100, 300);
        painelCampos.setBounds(150, 100, 400, 300);
        painelBotoes.setBounds(150, 420, 400, 50);
        painelCheckers.setBounds(300, 70, 250, 30);
        painelCheckersCampo.setBounds(20, 300, 20, 110);

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
        campoDoEmail.setEnabled(false);
        campoDaMatricula.setEnabled(false);
        checkAlmoxarife = new JCheckBox("Almoxarife");
        checkCaixa = new JCheckBox("Caixa Eletronico");
        checkEmail = new JCheckBox();
        checkNisPis = new JCheckBox();

        setBotaoConfirmatorio(new JButton("Cadastrar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JTextField[] componentesCampos = {campoDoNome,campoDoLogin, campoDaSenha, campoConfirmar,
                                        campoDoEmail,campoDaMatricula};

        JComponent[] componentesTextos = {textoNome, textoLogin, textoSenha,
                                        textoConfirmar, textoEmail, textoMatricula};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};  

        JComponent[] componentesCheckers = {checkAlmoxarife, checkCaixa};

        JComponent [] componentesCheckersCampo = {checkEmail, checkNisPis};

        setCampos(componentesCampos);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCheckers, painelCheckers);
        adicionarAoPainel(componentesCheckersCampo, painelCheckersCampo);
        add(painelTextos);
        add(painelCampos);
        add(painelCheckers);
        add(painelCheckersCampo);
        add(painelBotoes);
     
        

        if(sistema.isSemGerente()){
            adicionarCabecalho("Cadastrar Gerente");
            checkAlmoxarife.setVisible(false);
            checkCaixa.setVisible(false);
        }else{
            adicionarCabecalho("Cadastrar Funcionários");
        }

        OuvinteCadastroUsuario ouvinteCadastro = new OuvinteCadastroUsuario(this, sistema);
        
        getBotaoConfirmatorio().addActionListener(ouvinteCadastro);
        getBotaoCancelatorio().addActionListener(ouvinteCadastro);
        getCheckAlmoxarife().addActionListener(ouvinteCadastro);
        getCheckCaixa().addActionListener(ouvinteCadastro);
        getCheckEmail().addActionListener(ouvinteCadastro);
        getCheckNisPis().addActionListener(ouvinteCadastro);


        setVisible(true);
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

    public void setCampoDoNome(JTextField campoDoNome) {
        this.campoDoNome = campoDoNome;
    }

    public JCheckBox getCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(JCheckBox checkEmail) {
        this.checkEmail = checkEmail;
    }

    public JCheckBox getCheckNisPis() {
        return checkNisPis;
    }

    public void setCheckNisPis(JCheckBox checkNisPis) {
        this.checkNisPis = checkNisPis;
    }
}