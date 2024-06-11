package projeto.sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GridLayout;

import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;
import projeto.sistema.visual.ouvintes.OuvinteCadastroProduto;


public class JanelaCadastroProduto extends JanelaDeCampos{
    private JTextField campoDoNome;
    private JTextField campoDoCodigo;
    private JTextField campoDaUnidade;
    public JanelaCadastroProduto(SistemaMercado sistema) {
        super(sistema);
        setSize(600, 400);
        setLayout(null);
        setResizable(false);

        adicionarCabecalho("Cadastrar Produto");

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();

        painelTextos.setLayout(new GridLayout(3, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(3, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 30, 0));

        painelTextos.setBounds(40, 100, 160, 140);
        painelCampos.setBounds(210, 100, 300, 140);
        painelBotoes.setBounds(210, 280, 300, 50);

        JLabel textoCodigo = new JLabel("Codigo:");
        JLabel textoNome = new JLabel("Nome:");
        JLabel textoUnidades = new JLabel("Unidades:");

        campoDoCodigo = new JTextField(30);
        campoDoCodigo.setEnabled(false); 
        campoDoNome = new JTextField(15);
        campoDaUnidade = new JTextField(30);
    
        setBotaoConfirmatorio(new JButton("Cadastrar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JTextField[] componentesCampos = {campoDoCodigo, campoDoNome, campoDaUnidade};

        JComponent[] componentesTextos = { textoCodigo, textoNome, textoUnidades};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};

        setCampos(componentesCampos);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesTextos, painelTextos);

        OuvinteCadastroProduto OuvinteCadastroProduto = new OuvinteCadastroProduto(this, sistema);
        getBotaoConfirmatorio().addActionListener(OuvinteCadastroProduto);
        getBotaoCancelatorio().addActionListener(OuvinteCadastroProduto);
        campoDoCodigo.addKeyListener(OuvinteCadastroProduto);
        campoDoNome.addKeyListener(OuvinteCadastroProduto);
        campoDaUnidade.addKeyListener(OuvinteCadastroProduto);
    
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

    
}
