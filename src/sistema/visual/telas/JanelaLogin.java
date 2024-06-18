package sistema.visual.telas;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;
import sistema.visual.ouvintes.OuvinteDeCampos;
import sistema.visual.telas.usuarios.JanelaCaixa;
import sistema.visual.telas.usuarios.funcionarios.JanelaAlmoxarife;
import sistema.visual.telas.usuarios.funcionarios.JanelaGerente;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class JanelaLogin extends JanelaDeCampos{
    private JTextField campoDoLogin;
    private JPasswordField campoDaSenha;
    private SistemaMercado sistema;

    public JanelaLogin(SistemaMercado sistema){
        super(sistema);
        setSistema(sistema);
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

    public class OuvinteLogin extends OuvinteDeCampos{
        private JanelaLogin janela;

        public OuvinteLogin(JanelaLogin janela, SistemaMercado sistema){
            super(janela, sistema);
            setJanela(janela);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            super.actionPerformed(e);
        }

        @Override

        public void confirmar(){
            String login = janela.getCampoDoLogin().getText();
            String senha = new String(janela.getCampoDaSenha().getPassword());

            Usuario usuario = sistema.getUsuarioLogado(login, senha);
            
            if(usuario == null){
                JOptionPane.showMessageDialog(janela, "O Login informado não é válido",
                                            "Credenciais Incorretas", JOptionPane.ERROR_MESSAGE);
            }
            else{
                janela.dispose();
                JOptionPane.showMessageDialog(janela, "O Login foi efetuado!!");
                switch (usuario.getCargo().toLowerCase()){
                    case "gerente":
                        JanelaGerente janelaGerente = new JanelaGerente(getSistema(), usuario); 
                        break;
                    case "almoxarife":
                        JanelaAlmoxarife janelaAlmoxarife = new JanelaAlmoxarife(getSistema(), usuario);
                        break;
                    case "caixa eletronico":
                        JanelaCaixa janelaCaixa = new JanelaCaixa(getSistema(), usuario);
                        break;
                    }
                }  
            }

        @Override
        public void keyTyped(KeyEvent e) {
        
        }

        public JanelaLogin getJanela() {
            return janela;
        }

        public void setJanela(JanelaLogin janela) {
            this.janela = janela;
        }

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

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }
    
    
}
