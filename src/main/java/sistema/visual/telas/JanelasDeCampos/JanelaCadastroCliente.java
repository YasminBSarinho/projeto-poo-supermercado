package sistema.visual.telas.JanelasDeCampos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import sistema.SistemaMercado;
import sistema.pessoas.Cliente;
import sistema.utilitarios.CampoPersonalizado;
import sistema.utilitarios.Tipos;
import sistema.visual.ouvintes.OuvinteDeCampos;

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
        
        try {
            MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
            maskCPF.setPlaceholderCharacter('_');
            campoDoCPF = new JFormattedTextField(maskCPF);
        } catch (ParseException e) {
            e.printStackTrace();
            campoDoCPF = new JTextField();
        }
     
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

        campoDoNome = new CampoPersonalizado(Tipos.TEXTUAL);
        try {
            MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
            maskCPF.setPlaceholderCharacter('_');
            campoDoCPF = new JFormattedTextField(maskCPF);
        } catch (ParseException e) {
            e.printStackTrace();
            campoDoCPF = new JTextField();
        }
        campoDoEmail = new JTextField();
        campoDoEndereco = new JTextField();

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
        campoDoNome.addKeyListener(ouvinteCadastroCliente);
        getCheckEmail().addActionListener(ouvinteCadastroCliente);
        getCheckEndereco().addActionListener(ouvinteCadastroCliente);
        setVisible(true);
        
    }
    public class OuvinteCadastroCliente extends OuvinteDeCampos {
        private JanelaCadastroCliente janela;
        private JCheckBox checkEmail;
        private JCheckBox checkEndereco;

        public OuvinteCadastroCliente(JanelaCadastroCliente janela, SistemaMercado sistema){
            super(janela, sistema);
            this.setJanela(janela);
            checkEmail = janela.getCheckEmail();
            checkEndereco = janela.getCheckEndereco();
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            monitorarCampos(e);
            super.actionPerformed(e);
        }

        @Override
        public void confirmar(){
            String nome = janela.getCampoDoNome().getText();
            String email = janela.getCampoDoEmail().getText();
            String cpf = janela.getCampoDoCPF().getText();
            String endereco = janela.getCampoDoEndereco().getText();

            if (getSistema().buscarCliente(cpf) != null){
                JOptionPane.showMessageDialog(janela,"Este cliente já está cadastrado!",
                                        "Aviso", JOptionPane.ERROR_MESSAGE);
            }else{
                getSistema().getClientes().add(new Cliente(nome,email,cpf,endereco));
                janela.dispose();
                JOptionPane.showMessageDialog(janela, "Cliente cadastrado!");
            }
        }
        
        public void monitorarCampos(ActionEvent e){
            if(e.getSource() instanceof JCheckBox){
                JCheckBox checkbox = (JCheckBox) e.getSource();
                boolean isMarcado = checkbox.isSelected();

                if (e.getSource().equals(checkEmail)) {
                    janela.getCampoDoEmail().setEnabled(isMarcado);
                }
                if (e.getSource().equals(checkEndereco)) {
                    janela.getCampoDoEndereco().setEnabled(isMarcado);
                }
            }
        }

        public JanelaCadastroCliente getJanela() {
            return janela;
        }
        
        public void setJanela(JanelaCadastroCliente janela) {
            this.janela = janela;
        }
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
