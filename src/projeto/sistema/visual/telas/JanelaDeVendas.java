package projeto.sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import projeto.sistema.SistemaMercado;

public class JanelaDeVendas extends JanelaDeCampos{

    private JTextField campoCPF;
    private JTextField campoProduto;
    private JTextField campoQTD;

    public JanelaDeVendas(SistemaMercado sistema) {
        super(sistema);
        setSize(600, 400);

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();

        adicionarCabecalho("Vendas");

        painelTextos.setLayout(new GridLayout(3, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(3, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 50, 0));
        painelTextos.setBounds(40, 100, 200, 140);
        painelCampos.setBounds(240, 100, 300, 140);
        painelBotoes.setBounds(240, 280, 300, 50);
        campoCPF = new JTextField();
        campoProduto = new JTextField();
        campoQTD = new JTextField();

        JLabel textoCPF = new JLabel("CPF do Cliente");
        JLabel textoProduto = new JLabel("Código do Produto: ");
        JLabel textoQTD = new JLabel("Unidades: ");

        setBotaoConfirmatorio(new JButton("Vender"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JTextField[] componentesCampos = {campoCPF, campoProduto, campoQTD};

        JComponent[] componentesTextos = { textoCPF, textoProduto, textoQTD};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};
        
        setCampos(componentesCampos);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        setVisible(true);
        
    }

    public JTextField getCampoCPF() {
        return campoCPF;
    }

    public void setCampoCPF(JTextField campoCPF) {
        this.campoCPF = campoCPF;
    }

    public JTextField getCampoProduto() {
        return campoProduto;
    }

    public void setCampoProduto(JTextField campoProduto) {
        this.campoProduto = campoProduto;
    }

    public JTextField getCampoQTD() {
        return campoQTD;
    }

    public void setCampoQTD(JTextField campoQTD) {
        this.campoQTD = campoQTD;
    }
    
}
