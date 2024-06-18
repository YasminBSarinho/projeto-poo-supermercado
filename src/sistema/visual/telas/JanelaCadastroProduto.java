package sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.awt.GridLayout;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import sistema.SistemaMercado;
import sistema.visual.ouvintes.OuvinteCadastroProduto;


public class JanelaCadastroProduto extends JanelaDeCampos{
    private JTextField campoDoNome;
    private JTextField campoDoCodigo;
    private JTextField campoDaUnidade;
    private JTextField campoValorDeCompra;
    private JTextField campoValorDeVenda;
    
    public JanelaCadastroProduto(SistemaMercado sistema) {
        super(sistema);
        setSize(600, 480);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        adicionarCabecalho("Cadastrar Produto");

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();

        painelTextos.setLayout(new GridLayout(5, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(5, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 30, 0));

        painelTextos.setBounds(40, 100, 160, 240);
        painelCampos.setBounds(210, 100, 300, 240);
        painelBotoes.setBounds(210, 365, 300, 50);

        JLabel textoCodigo = new JLabel("Codigo:");
        JLabel textoNome = new JLabel("Nome:");
        JLabel textoUnidades = new JLabel("Unidades:");
        JLabel textoValorCompra = new JLabel("Valor de Compra: ");
        JLabel textoValorVenda = new JLabel("Valor de Venda: ");

        campoDoCodigo = new JTextField();
        campoDoCodigo.setEnabled(false);
        String novoCodigo = String.valueOf(sistema.getProdutosEmEstoque().size() + 1);
        campoDoCodigo.setText(novoCodigo);
        campoDoNome = new JTextField();
        campoDaUnidade = new JTextField();
        campoValorDeCompra = new JTextField();
        campoValorDeVenda = new JTextField();
    
        setBotaoConfirmatorio(new JButton("Cadastrar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JTextField[] componentesCampos = {campoDoCodigo, campoDoNome, campoDaUnidade, campoValorDeCompra, campoValorDeVenda};

        JComponent[] componentesTextos = { textoCodigo, textoNome, textoUnidades, textoValorCompra, textoValorVenda};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};

        setCampos(componentesCampos);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesTextos, painelTextos);

        OuvinteCadastroProduto ouvinteCadastroProduto = new OuvinteCadastroProduto(this, sistema);
        getBotaoConfirmatorio().addActionListener(ouvinteCadastroProduto);
        getBotaoCancelatorio().addActionListener(ouvinteCadastroProduto);
        campoDoCodigo.addKeyListener(ouvinteCadastroProduto);
        campoDoNome.addKeyListener(ouvinteCadastroProduto);
        campoDaUnidade.addKeyListener(ouvinteCadastroProduto);
        campoValorDeCompra.addKeyListener(ouvinteCadastroProduto);
        campoValorDeVenda.addKeyListener(ouvinteCadastroProduto);
    
        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        setVisible(true);
    }
    
    public JTextField getCampoDoCodigo() {
        return campoDoCodigo;
    }

    public void setCampoDoCodigo(JTextField campoDoCodigo) {
        this.campoDoCodigo = campoDoCodigo;
    }

    public JTextField getCampoDoNome() {
        return campoDoNome;
    }

    public void setCampoDonome(JTextField campoDonome) {
        this.campoDoNome = campoDonome;
    }

    public JTextField getCampoDaUnidade() {
        return campoDaUnidade;
    }

    public void setCampoDaUniade(JTextField campoDaUnidade) {
        this.campoDaUnidade = campoDaUnidade;
    }

    public void setCampoDoNome(JTextField campoDoNome) {
        this.campoDoNome = campoDoNome;
    }

    public void setCampoDaUnidade(JTextField campoDaUnidade) {
        this.campoDaUnidade = campoDaUnidade;
    }

    public JTextField getCampoValorDeCompra() {
        return campoValorDeCompra;
    }

    public void setCampoValorDeCompra(JTextField campoValorDeCompra) {
        this.campoValorDeCompra = campoValorDeCompra;
    }

    public JTextField getCampoValorDeVenda() {
        return campoValorDeVenda;
    }

    public void setCampoValorDeVenda(JTextField campoValorDeVenda) {
        this.campoValorDeVenda = campoValorDeVenda;
    }

    
}
