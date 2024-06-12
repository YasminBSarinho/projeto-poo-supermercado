package projeto.sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;
import projeto.sistema.visual.ouvintes.OuvinteVendas;

public class JanelaDeVendas extends JanelaDeCampos{

    private JTextField campoCPF;
    private JTextField campoProduto;
    private JTextField campoQTD;
    private JButton botaoVender;
    private ArrayList<Produto> carrinho = new ArrayList<>();
    private float totalDeVendas;

    public JanelaDeVendas(SistemaMercado sistema) {
        super(sistema);
        setSize(650, 400);

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();

        adicionarCabecalho("Vendas");

        painelTextos.setLayout(new GridLayout(3, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(3, 1, 0, 20));
        painelTextos.setBounds(40, 100, 200, 140);
        painelCampos.setBounds(240, 100, 370, 140);
        campoCPF = new JTextField();
        campoProduto = new JTextField();
        campoQTD = new JTextField();

        JLabel textoCPF = new JLabel("CPF do Cliente");
        JLabel textoProduto = new JLabel("Código do Produto: ");
        JLabel textoQTD = new JLabel("Unidades: ");

        setBotaoConfirmatorio(new JButton("Adicionar ao Carrinho"));
        botaoVender = new JButton("Finalizar");
        getBotaoConfirmatorio().setBounds(240, 280, 200, 50);
        botaoVender.setBounds(490, 280, 120, 50);

        JTextField[] componentesCampos = {campoCPF, campoProduto, campoQTD};

        JComponent[] componentesTextos = { textoCPF, textoProduto, textoQTD};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoVender()};
        
        setCampos(componentesCampos);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        setFonteDoBotao(new Font("arial", Font.BOLD, 15));
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCampos, painelCampos);

        OuvinteVendas ouvinteVendas = new OuvinteVendas(this,sistema);
        getCampoCPF().addKeyListener(ouvinteVendas);
        getCampoProduto().addKeyListener(ouvinteVendas);
        getCampoQTD().addKeyListener(ouvinteVendas);
        getBotaoConfirmatorio().addActionListener(ouvinteVendas);
        getBotaoVender().addActionListener(ouvinteVendas);
        
        add(getBotaoConfirmatorio());
        add(botaoVender);
        add(painelTextos);
        add(painelCampos);
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

    public JButton getBotaoVender() {
        return botaoVender;
    }

    public void setBotaoVender(JButton botaoVender) {
        this.botaoVender = botaoVender;
    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public float getTotalDeVendas() {
        return totalDeVendas;
    }

    public void setTotalDeVendas(float totalDeVendas) {
        this.totalDeVendas = totalDeVendas;
    }

}
