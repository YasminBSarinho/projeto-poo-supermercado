package sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import sistema.SistemaMercado;
import sistema.utilitarios.Cupom;
import sistema.visual.ouvintes.OuvinteDeCampos;

public class JanelaCupom extends JanelaDeCampos{
    private JTextField campoCodigo;
    private JTextField campoDesconto;

    public JanelaCupom(SistemaMercado sistema){
        super(sistema);
        setSize(500, 350);
        adicionarCabecalho("Criar Cupom");

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();

        painelTextos.setLayout(new GridLayout(2, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(2, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 20, 0));

        painelTextos.setBounds(100, 80, 150, 100);
        painelCampos.setBounds(250, 80, 150, 100);
        painelBotoes.setBounds(100, 220, 300, 50);

        JLabel textoCodigo = new JLabel("Código:");
        JLabel textoDesconto = new JLabel("Desconto(%):");
        campoCodigo = new JTextField(5);
        campoDesconto = new JTextField(3);

        setBotaoConfirmatorio(new JButton("Criar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JComponent[] componentesTexto = {textoCodigo, textoDesconto};
        JTextField[] componentesCampo = {campoCodigo, campoDesconto};
        JComponent[] componentesBotao = {getBotaoConfirmatorio(), getBotaoCancelatorio()};
        
        setCampos(componentesCampo);
        adicionarFontes(componentesTexto);
        adicionarFontes(componentesCampo);
        adicionarFontes(componentesBotao);
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
            float desconto = Float.parseFloat(descontoTexto)/100;
            Cupom cupom = new Cupom(codigo, desconto);

            if(getSistema().validarCupom(codigo) == null){
                getSistema().getCupons().add(cupom);
                janela.dispose();
                JOptionPane.showMessageDialog(janela, "Cupom cadastrado!");
            }else{
                JOptionPane.showMessageDialog(janela, "O Cupom já está cadastrado!");
            }

        }    

        @Override
        public void keyTyped(KeyEvent e) {

            JTextField campo = (JTextField) e.getSource();
            JTextField campoCodigo = janela.getCampoCodigo();
            String codigo = janela.getCampoCodigo().getText();
            String desconto = janela.getCampoDesconto().getText();
            char letra = e.getKeyChar();
            
            if(campo.equals(campoCodigo)) {
                if(codigo.length() > 4 || !Character.isLetterOrDigit(letra)){
                    e.consume();
                }
            } else {
                if(desconto.length() > 1 || !Character.isDigit(letra)){
                    e.consume();
                }
            }
        }
    
        public JanelaCupom getJanela() {
            return janela;
        }
        
        public void setJanela(JanelaCupom janela) {
            this.janela = janela;
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
