package sistema.visual.telas.JanelasDeCampos;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.ArrayList;

import sistema.SistemaMercado;
import sistema.produtos.Produto;
import sistema.utilitarios.CampoPersonalizado;
import sistema.utilitarios.Tipos;
import sistema.visual.ouvintes.OuvinteVendas;

public class JanelaDeVendas extends JanelaDeCampos{

    private JTextField campoCPF;
    private JTextField campoCodigo;
    private JTextField campoQTD;
    private JTextField campoCupom;
    private JButton botaoVender;
    private ArrayList<Produto> carrinho = new ArrayList<>();
    private BigDecimal totalDeVendas;

    public JanelaDeVendas(SistemaMercado sistema) {
        super(sistema);
        setSize(650, 440);
        setLocationRelativeTo(null);
        this.totalDeVendas = new BigDecimal("0");
        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();

        adicionarCabecalho("Vendas");

        painelTextos.setLayout(new GridLayout(4, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(4, 1, 0, 20));
        painelTextos.setBounds(40, 100, 200, 180);
        painelCampos.setBounds(240, 100, 370, 180);

        campoCPF = criarCampoFormatado("###.###.###-##", '_');
        campoCodigo = criarCampoFormatado("#####", '_');
        campoQTD = new CampoPersonalizado(Tipos.NUMERICO, 3);
        campoCupom = criarCampoFormatado("AAAAA", '_');
        
        JLabel textoCPF = new JLabel("CPF do Cliente");
        JLabel textoProduto = new JLabel("Código do Produto: ");
        JLabel textoQTD = new JLabel("Unidades: ");
        JLabel textoCupom = new JLabel("Cupom: ");

        setBotaoConfirmatorio(new JButton("Adicionar ao Carrinho"));
        botaoVender = new JButton("Finalizar");
        botaoVender.setEnabled(false);
        getBotaoConfirmatorio().setBounds(240, 320, 200, 50);
        botaoVender.setBounds(490, 320, 120, 50);

        JTextField[] componentesCampos = {campoCPF, campoCodigo, campoQTD, campoCupom};

        JComponent[] componentesTextos = { textoCPF, textoProduto, textoQTD, textoCupom};

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
        getCampoCodigo().addKeyListener(ouvinteVendas);
        getCampoQTD().addKeyListener(ouvinteVendas);
        getCampoCupom().addKeyListener(ouvinteVendas);
        getBotaoConfirmatorio().addActionListener(ouvinteVendas);
        getBotaoVender().addActionListener(ouvinteVendas);
        
        add(getBotaoConfirmatorio());
        add(botaoVender);
        add(painelTextos);
        add(painelCampos);
        setVisible(true);
    }

    public JTextField getCampoCupom() {
        return campoCupom;
    }

    public void setCampoCupom(JTextField campoCupom) {
        this.campoCupom = campoCupom;
    }

    public JTextField getCampoCPF() {
        return campoCPF;
    }

    public void setCampoCPF(JTextField campoCPF) {
        this.campoCPF = campoCPF;
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

    public BigDecimal getTotalDeVendas() {
        return totalDeVendas;
    }

    public void setTotalDeVendas(BigDecimal totalDeVendas) {
        this.totalDeVendas = totalDeVendas;
    }

    public JTextField getCampoCodigo() {
        return campoCodigo;
    }

    public void setCampoCodigo(JTextField campoCodigo) {
        this.campoCodigo = campoCodigo;
    }

}
