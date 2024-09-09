package sistema.visual.telas.JanelasDeCampos;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import sistema.SistemaMercado;
import sistema.utilitarios.CampoPersonalizado;
import sistema.utilitarios.Cupom;
import sistema.utilitarios.Tipos;
import sistema.visual.ouvintes.OuvinteDeCampos;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import sistema.pessoas.Cliente;
import javax.swing.JScrollPane;

public class JanelaCupom extends JanelaDeCampos{
    private JTextField campoCodigo;
    private JTextField campoDesconto;
    private JTextArea campoMensagem;

    public JanelaCupom(SistemaMercado sistema){
        super(sistema);
        setSize(500, 500);
        setLocationRelativeTo(null);
        adicionarCabecalho("Criar Cupom");

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();


        painelTextos.setLayout(new GridLayout(2, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(2, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 20, 0));

        painelTextos.setBounds(100, 80, 150, 80);
        painelCampos.setBounds(250, 80, 150, 80);
        painelBotoes.setBounds(100, 330, 300, 50);

        JLabel textoCodigo = new JLabel("Código:");
        JLabel textoDesconto = new JLabel("Desconto(%):");
        JLabel textoMensagem = new JLabel("Mensagem:");

        campoCodigo = new CampoPersonalizado(Tipos.NUMERICO_TEXTUAL, 5);
        campoDesconto = new CampoPersonalizado(Tipos.NUMERICO,2);
        campoMensagem = new JTextArea();
        campoMensagem.setLineWrap(true);
        campoMensagem.setWrapStyleWord(true);

        JScrollPane scrollMensagem = new JScrollPane(campoMensagem);
        textoMensagem.setBounds(100, 170, 150, 30);
        scrollMensagem.setBounds(100, 210, 300, 100);
        
        setBotaoConfirmatorio(new JButton("Criar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JComponent[] componentesTexto = {textoCodigo, textoDesconto};
        JTextField[] componentesCampo = {campoCodigo, campoDesconto};
        JComponent[] componentesBotao = {getBotaoConfirmatorio(), getBotaoCancelatorio()};
        
        setCampos(componentesCampo);
        adicionarFontes(componentesTexto);
        adicionarFontes(componentesCampo);
        adicionarFontes(componentesBotao);
        textoMensagem.setFont(getFonteDoCampo());
        adicionarAoPainel(componentesTexto, painelTextos);
        adicionarAoPainel(componentesCampo, painelCampos);
        adicionarAoPainel(componentesBotao, painelBotoes);
        
        OuvinteCupom ouvinteCupom = new OuvinteCupom(this, sistema);
        getBotaoConfirmatorio().addActionListener(ouvinteCupom);
        getBotaoCancelatorio().addActionListener(ouvinteCupom);
        getCampoCodigo().addKeyListener(ouvinteCupom);
        getCampoDesconto().addKeyListener(ouvinteCupom);
        
        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        add(textoMensagem);
        add(scrollMensagem);
        setVisible(true);
    }

    public class OuvinteCupom extends OuvinteDeCampos{

        private JanelaCupom janela;
        
        public OuvinteCupom(JanelaCupom janela, SistemaMercado sistema){
            super(janela, sistema);
            setJanela(janela);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            super.actionPerformed(e);
        }

        @Override
        protected void confirmar(){
            String codigo = janela.getCampoCodigo().getText();
            String descontoTexto = janela.getCampoDesconto().getText();
            BigDecimal percentual = BigDecimal.valueOf(Double.parseDouble(descontoTexto)/100);
            Cupom cupom = new Cupom(codigo, percentual);
            String mensagem = campoMensagem.getText();

            if(getSistema().validarCupom(codigo) == null){
                getSistema().getCupons().add(cupom);
                janela.dispose();
                JOptionPane.showMessageDialog(janela, "Cupom cadastrado!");
                for(Cliente cliente : getSistema().getClientes()){
                    enviarCupom(mensagem, cliente.getEmail());
                }
            }else{
                JOptionPane.showMessageDialog(janela, "O Cupom já está cadastrado!");
            }

        }    
            
        public JanelaCupom getJanela() {
            return janela;
        }
        
        public void setJanela(JanelaCupom janela) {
            this.janela = janela;
        }
    
    }

    public void enviarCupom(String mensagem, String emailDestinatario){
        SimpleEmail email = new SimpleEmail();  
		
		try {
            email.setDebug(true);  
            email.setHostName("smtp.gmail.com");  
            email.setAuthentication("poosupermercado@gmail.com","emracwewirwrbaow");  
            email.setSSLOnConnect(true);
            email.setFrom("poosupermercado@gmail.com");
            email.setSubject("Cupom de desconto do mercadinho java");  
            email.setMsg(mensagem);  
            email.addTo(emailDestinatario);
            email.send();
			

		} catch (EmailException e) {  

		System.out.println(e.getMessage());  

		}
    }

    public JTextField getCampoCodigo() {
        return campoCodigo;
    }

    public void setCampoCodigo(JTextField campoCodigo) {
        this.campoCodigo = campoCodigo;
    }

    public JTextField getCampoDesconto() {
        return campoDesconto;
    }

    public void setCampoDesconto(JTextField campoDesconto) {
        this.campoDesconto = campoDesconto;
    }
}
