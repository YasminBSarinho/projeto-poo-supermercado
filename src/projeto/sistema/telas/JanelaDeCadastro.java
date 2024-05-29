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
    private JPasswordField campoConfirmar;
    private JTextField campoDoEmail;
    private JTextField campoDaMatricula;
    private JCheckBox checkAlmoxarife;
    private JCheckBox checkCaixa;
    
    public JanelaDeCadastro(SistemaMercado sistema){
        super(sistema);
        adicionarCabecalho("Cadastro");

        // Textos
        int[] boundsNome = {60, 100, 120, 30};
        int[] boundsLogin = {60, 145, 120, 30};
        int[] boundsSenha = {60, 185, 120, 30};
        int[] boundsConfirmar = {60, 225, 120, 30};
        int[] boundsEmail= {60, 265, 120, 30};
        int[] boundsMatricula = {60, 305, 120, 30};
        int[] boundsBotaoCadastrar = {180, 370, 140, 50};
        int[] boundsBotaoCancelar = {350, 370, 140, 50};
        int[] boundsCheckAlmoxarife = {220, 70, 100, 30};
        int[] boundsCheckcaixa = {320, 70, 120, 30};
        
        //Campos
        int[] boundsNomeCampo = {boundsNome[0] + boundsNome[2] + 10, 100, 280, 30};
        int[] boundsLoginCampo = {boundsLogin[0] + boundsLogin[2] + 10, 145, 280, 30};
        int[] boundsSenhaCampo = {boundsSenha[0] + boundsSenha[2] + 10, 185, 280, 30};
        int[] boundsConfirmarCampo = {boundsConfirmar[0] + boundsConfirmar[2] + 10, 225, 280, 30};
        int[] boundsEmailCampo= {boundsEmail[0] + boundsEmail[2] + 10, 265, 280, 30};
        int[] boundsMatriculaCampo = {boundsMatricula[0] + boundsMatricula[2] + 10, 305, 280, 30};
        
        adicionarTexto("Nome:", getFonteDoBotao(), boundsNome);

        setCampoDonome((JTextField) adicionarCampo(getFonteDoCampo(), boundsNomeCampo, false));
        adicionarTexto("Login:", getFonteDoBotao(), boundsLogin);
        setCampoDoLogin((JTextField) adicionarCampo(getFonteDoCampo() , boundsLoginCampo , false));
        adicionarTexto("Senha:", getFonteDoBotao(), boundsSenha);
        setCampoDaSenha((JPasswordField) adicionarCampo(getFonteDoCampo(), boundsSenhaCampo, true));
        adicionarTexto("Confirmar:", getFonteDoBotao(), boundsConfirmar);
        setCampoConfirmar((JPasswordField) adicionarCampo(getFonteDoCampo(), boundsConfirmarCampo, true));
        adicionarTexto("Email:", getFonteDoBotao(), boundsEmail);
        setCampoDoEmail((JTextField) adicionarCampo(getFonteDoCampo(), boundsEmailCampo, false));
        adicionarTexto("NIS/PIS:", getFonteDoBotao(), boundsMatricula);
        setCampoDaMatricula((JTextField) adicionarCampo(getFonteDoCampo(), boundsMatriculaCampo, false));
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