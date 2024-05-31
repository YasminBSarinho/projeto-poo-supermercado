package projeto.sistema.telas;
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
import projeto.sistema.ouvintes.OuvinteCadastro;

public class JanelaCadastroFuncionario extends JanelaBaseFormularios{ 
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
    
    public JanelaCadastroFuncionario(SistemaMercado sistema){
        super(sistema);
        setSize(600, 540); 
        setLayout(null);
        setLocationRelativeTo(null);

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();
        JPanel painelCheckers = new JPanel();

        painelTextos.setLayout(new GridLayout(6, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(6, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 100, 0));
        painelCheckers.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        
        painelTextos.setBounds(50, 100, 100, 300);
        painelCampos.setBounds(150, 100, 400, 300);
        painelBotoes.setBounds(150, 420, 400, 50);
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

        JComponent[] componentesCampos = {campoDoNome,campoDoLogin, campoDaSenha, campoConfirmar,
                                        campoDoEmail,campoDaMatricula};

        JComponent[] componentesTextos = {textoNome, textoLogin, textoSenha,
                                        textoConfirmar, textoEmail, textoMatricula};

        JComponent[] componentesBotoes = {botaoCadastrar, botaoCancelar};  
        
        JComponent[] componentesCheckers = {checkAlmoxarife, checkCaixa};

        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCheckers, painelCheckers);
    
        add(painelTextos);
        add(painelCampos);
        add(painelCheckers);
        add(painelBotoes);
        
        if(sistema.isSemGerente()){
            adicionarCabecalho("Cadastrar Gerente");
            checkAlmoxarife.setVisible(false);
            checkCaixa.setVisible(false);
        }else{
            adicionarCabecalho("Cadastrar Funcionários");
        }

        OuvinteCadastro ouvinteCadastro = new OuvinteCadastro(this, sistema);
        getCheckAlmoxarife().addActionListener(ouvinteCadastro);
        getCheckCaixa().addActionListener(ouvinteCadastro);
        getBotaoCadastrar().addActionListener(ouvinteCadastro);
        getBotaoCancelar().addActionListener(ouvinteCadastro);
        setVisible(true);
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