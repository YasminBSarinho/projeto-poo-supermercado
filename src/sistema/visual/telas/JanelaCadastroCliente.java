package sistema.visual.telas;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sistema.SistemaMercado;
import sistema.visual.ouvintes.OuvinteCadastroCliente;

public class JanelaCadastroCliente extends JanelaDeCampos{

    private JTextField campoDoNome;
    private JTextField campoDoCPF;
    private JTextField campoDoEmail;
    private JTextField campoDoEndereco;
    private JCheckBox checkEmail;
    private JCheckBox checkEndereco;
    
    public JanelaCadastroCliente(SistemaMercado sistema){
        super(sistema);
        setSize(600, 450);
        adicionarCabecalho("Cadastro do Cliente");
        setLocationRelativeTo(null);
     
        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();
        JPanel painelCheckers = new JPanel();

        painelTextos.setLayout(new GridLayout(4, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(4, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 100, 0));
        painelCheckers.setLayout(new GridLayout(2, 1, 0, 0));
        
        painelTextos.setBounds(50, 100, 100, 200);
        painelCampos.setBounds(150, 100, 400, 200);
        painelBotoes.setBounds(150, 320, 400, 50);
        painelCheckers.setBounds(20, 200, 20, 110);

        JLabel textoNome = new JLabel("Nome:");
        JLabel textoCPF = new JLabel("CPF:");
        JLabel textoEmail = new JLabel("E-mail:");
        JLabel textoEndereco = new JLabel("Endereço:");

        campoDoNome = new JTextField(30);
        campoDoCPF = new JTextField(15);
        campoDoEmail = new JTextField(15);
        campoDoEndereco = new JTextField(15);

        campoDoEmail.setEnabled(false);
        campoDoEndereco.setEnabled(false);
        
        checkEmail = new JCheckBox();
        checkEndereco = new JCheckBox();

        setBotaoConfirmatorio( new JButton("Cadastrar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JComponent[] componentesTextos = {textoNome, textoEmail, textoCPF, textoEmail, textoEndereco};

        JTextField[] componentesCampos = {campoDoNome, campoDoCPF, campoDoEmail, campoDoEndereco};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};

        JComponent[] componentesCheckers = {checkEmail, checkEndereco}; 

        setCampos(componentesCampos);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesCheckers, painelCheckers);
        adicionarAoPainel(componentesBotoes, painelBotoes);

        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        add(painelCheckers);
        add(painelBotoes);
   
        OuvinteCadastroCliente ouvinteCadastroCliente = new OuvinteCadastroCliente(this, sistema);
        
        getBotaoConfirmatorio().addActionListener(ouvinteCadastroCliente);
        getBotaoCancelatorio().addActionListener(ouvinteCadastroCliente);
        getCheckEmail().addActionListener(ouvinteCadastroCliente);
        getCheckEndereco().addActionListener(ouvinteCadastroCliente);
        setVisible(true);
        
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
