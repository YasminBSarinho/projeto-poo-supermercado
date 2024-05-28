package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.ouvintes.OuvinteCadastro;

public class JanelaDeCadastro extends JanelaPadrao{ 
    private JButton botaoCadastrar;
    private JButton botaoCancelar;
    private JTextField campoDonome;
    private JTextField campoDoLogin;
    private JPasswordField campoDasenha;
    private JPasswordField campoDeconfirmacao;
    private JTextField campoDoEmail;
    private JTextField campoDaMatricula;
    
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
        
        setCampoDonome((JTextField) adicionarCampo("Nome:", getFonteDoCampo(), boundsNome, false));
        setCampoDoLogin((JTextField) adicionarCampo("Novo Login:", getFonteDoCampo() , boundsLogin , false));
        setCampoDasenha((JPasswordField) adicionarCampo("Nova Senha:", getFonteDoCampo(), boundsSenha, true));
        setCampoDeconfirmacao((JPasswordField) adicionarCampo("Confirmação:", getFonteDoCampo(), boundsConfirmacao, true));
        setCampoDoEmail((JTextField) adicionarCampo("Email:", getFonteDoCampo(), boundsEmail, false));
        setCampoDaMatricula((JTextField) adicionarCampo("Matricula:", getFonteDoCampo(), boundsMatricula, false));
        setBotaoCadastrar(adicionarBotao("Cadastrar", boundsBotaoCadastrar));
        setBotaoCancelar(adicionarBotao("Cancelar", boundsBotaoCancelar));

        OuvinteCadastro ouvinteCadastro = new OuvinteCadastro(this, sistema);
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

    public JTextField getCampoDonome() {
        return campoDonome;
    }

    public void setCampoDonome(JTextField campoDonome) {
        this.campoDonome = campoDonome;
    }

    public JTextField getCampoDoLogin() {
        return campoDoLogin;
    }

    public void setCampoDoLogin(JTextField campoDoLogin) {
        this.campoDoLogin = campoDoLogin;
    }

    public JPasswordField getCampoDasenha() {
        return campoDasenha;
    }

    public void setCampoDasenha(JPasswordField campoDasenha) {
        this.campoDasenha = campoDasenha;
    }

    public JPasswordField getCampoDeconfirmacao() {
        return campoDeconfirmacao;
    }

    public void setCampoDeconfirmacao(JPasswordField campoDeconfirmacao) {
        this.campoDeconfirmacao = campoDeconfirmacao;
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

    
    
}