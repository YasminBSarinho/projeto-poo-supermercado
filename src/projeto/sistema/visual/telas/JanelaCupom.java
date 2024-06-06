package projeto.sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.ouvintes.OuvinteCupom;

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
