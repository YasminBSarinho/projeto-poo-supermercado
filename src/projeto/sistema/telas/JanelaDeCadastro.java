package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
    private JPasswordField campoDeConfirmacao;
    private JTextField campoDoEmail;
    private JTextField campoDaMatricula;
    private JCheckBox checkAlmoxarife;
    private JCheckBox checkCaixa;
    
    public JanelaDeCadastro(SistemaMercado sistema){
        super(sistema);
        adicionarCabecalho("Cadastro");
        int[] boundsNome = {60, 100, 120, 30};
        int[] boundsLogin = {60, 145, 120, 30};
        int[] boundsSenha = {60, 185, 120, 30};
        int[] boundsConfirmacao = {60, 225, 120, 30};
        int[] boundsEmail= {60, 265, 120, 30};
        int[] boundsMatricula = {60, 305, 120, 30};
        int[] boundsBotaoCadastrar = {180, 370, 140, 50};
        int[] boundsBotaoCancelar = {350, 370, 140, 50};
        int[] boundsCheckAlmoxarife = {220, 70, 100, 30};
        int[] boundsCheckcaixa = {320, 70, 120, 30};
        
        
        setCampoDonome((JTextField) adicionarCampo("Nome:", getFonteDoCampo(), boundsNome, false));
        setCampoDoLogin((JTextField) adicionarCampo("Novo Login:", getFonteDoCampo() , boundsLogin , false));
        setCampoDaSenha((JPasswordField) adicionarCampo("Nova Senha:", getFonteDoCampo(), boundsSenha, true));
        setCampoDeConfirmacao((JPasswordField) adicionarCampo("Confirmação:", getFonteDoCampo(), boundsConfirmacao, true));
        setCampoDoEmail((JTextField) adicionarCampo("Email:", getFonteDoCampo(), boundsEmail, false));
        setCampoDaMatricula((JTextField) adicionarCampo("Matricula:", getFonteDoCampo(), boundsMatricula, false));
        setBotaoCadastrar(adicionarBotao("Cadastrar", boundsBotaoCadastrar));
        setBotaoCancelar(adicionarBotao("Cancelar", boundsBotaoCancelar));
        setCheckAlmoxarife(adicionarCheckBox("Almoxarife", boundsCheckAlmoxarife));
        setCheckCaixa(adicionarCheckBox("Caixa Eletronico", boundsCheckcaixa));

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

    public JPasswordField getCampoDeConfirmacao() {
        return campoDeConfirmacao;
    }

    public void setCampoDeConfirmacao(JPasswordField campoDeconfirmacao) {
        this.campoDeConfirmacao = campoDeconfirmacao;
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