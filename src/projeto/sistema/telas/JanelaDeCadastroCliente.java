package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.ouvintes.OuvinteCadastroCliente;

public class JanelaDeCadastroCliente extends JanelaDefaultLogar{
    
    private JButton botaoCadastrar;
    private JButton botaoCancelar;
    private JTextField campoDoNome;
    private JTextField campoDoCPF;
    private JTextField campoDoEmail;
    private JTextField campoDoEndereco;
    private JCheckBox checkEmail;
    private JCheckBox checkEndereco;
    
    public JanelaDeCadastroCliente(SistemaMercado sistema){
        
        super(sistema);
        setSize(560,400);
        adicionarCabecalho("Cadastro do Cliente");
        
        int[] boundsNome = {60, 100, 120, 30};
        int[] boundsCPF = {60, 145, 120, 30};
        int[] boundsEmail = {60, 185, 120, 30};
        int[] boundsEndereco = {60, 225, 120, 30};
        int[] boundsBotaoCadastrar = {180, 280, 140, 50};
        int[] boundsBotaoCancelar = {350, 280, 140, 50};
        int[] boundsCheckEmail = {60, 185, 60, 30};
        int[] boundsCheckEndereco = {60, 225, 50, 30};
        
        int[] boundsNomeCampo = {boundsNome[0] + boundsNome[2] + 10, 100, 280, 30};
        int[] boundsCPFCampo = {boundsCPF[0] + boundsCPF[2] + 10, 145, 280, 30};
        int[] boundsEmailCampo = {boundsEmail[0] + boundsEmail[2] + 10, 185, 280, 30};
        int[] boundsEnderecoCampo = {boundsEndereco[0] + boundsEndereco[2] + 10, 225, 280, 30};
        
        adicionarTexto("Nome:", getFonteDoBotao(), boundsNome);
        setCampoDoNome((JTextField) adicionarCampo(getFonteDoBotao(), boundsNomeCampo, false));
        
        adicionarTexto("CPF:", getFonteDoBotao(), boundsCPF);
        setCampoDoCPF((JTextField) adicionarCampo(getFonteDoBotao(), boundsCPFCampo, false));
        
        adicionarTexto("Email:", getFonteDoBotao(), boundsEmail);
        setCampoDoEmail((JTextField) adicionarCampo(getFonteDoBotao(), boundsEmailCampo, false));

        adicionarTexto("Endereço:", getFonteDoBotao(), boundsEndereco);
        setCampoDoEndereco((JTextField) adicionarCampo(getFonteDoBotao(), boundsEnderecoCampo, false));
        
        setBotaoCadastrar(adicionarBotao("Cadastrar", boundsBotaoCadastrar));
        setBotaoCancelar(adicionarBotao("Cancelar", boundsBotaoCancelar));
        
        setCheckEmail(adicionarCheckBox("", boundsCheckEmail));
        setCheckEndereco(adicionarCheckBox("", boundsCheckEndereco));
        
        OuvinteCadastroCliente ouvinteCadastroCliente = new OuvinteCadastroCliente(this, sistema);
        getBotaoCadastrar().addActionListener(ouvinteCadastroCliente);
        getBotaoCancelar().addActionListener(ouvinteCadastroCliente);
        getCheckEmail().addActionListener(ouvinteCadastroCliente);
        getCheckEndereco().addActionListener(ouvinteCadastroCliente);
        setVisible(true);
        
    }
    
    public JCheckBox adicionarCheckBox(String texto,int [] bounds){
        JCheckBox checkBox = new JCheckBox(texto);
        checkBox.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        add(checkBox);
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
    
    public void setCampoDoNome(JTextField campoDoNome) {
        this.campoDoNome = campoDoNome;
    }
    public JTextField getCampoDoCPF() {
        return campoDoCPF;
    }
    
    public void setCampoDoCPF(JTextField campoDoCPF) {
        this.campoDoCPF = campoDoCPF;
    }
    
    public JTextField getCampoDoEmail() {
        return campoDoEmail;
    }
    
    public void setCampoDoEmail(JTextField campoDoEmail) {
        this.campoDoEmail = campoDoEmail;
    }
    
    public JTextField getCampoDoEndereco() {
        return campoDoEndereco;
    }
    
    public void setCampoDoEndereco(JTextField campoDoEndereco) {
        this.campoDoEndereco = campoDoEndereco;
    }
    
    public JCheckBox getCheckEmail() {
        return checkEmail;
    }
    
    public void setCheckEmail(JCheckBox checkEmail) {
        this.checkEmail = checkEmail;
    }
    
    public JCheckBox getCheckEndereco() {
        return checkEndereco;
    }
    
    public void setCheckEndereco(JCheckBox checkEndereco) {
        this.checkEndereco = checkEndereco;
    }
}
