package sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import sistema.SistemaMercado;
import sistema.produtos.Produto;
import sistema.visual.ouvintes.OuvinteDeCampos;


public class JanelaCadastroProduto extends JanelaDeCampos{
    private JTextField campoDoNome;
    private JTextField campoDoCodigo;
    
    public JanelaCadastroProduto(SistemaMercado sistema) {
        super(sistema);
        setSize(600, 400);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        adicionarCabecalho("Cadastrar Produto");

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();

        painelTextos.setLayout(new GridLayout(2, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(2, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 30, 0));

        painelTextos.setBounds(40, 100, 160, 140);
        painelCampos.setBounds(210, 100, 300, 140);
        painelBotoes.setBounds(210, 280, 300, 50);

        JLabel textoCodigo = new JLabel("Codigo:");
        JLabel textoNome = new JLabel("Nome:");

        campoDoCodigo = new JTextField();
        campoDoCodigo.setEnabled(false);
        String novoCodigo = String.valueOf(sistema.getProdutosEmEstoque().size() + 1);
        campoDoCodigo.setText(novoCodigo);
        campoDoNome = new JTextField();
    
        setBotaoConfirmatorio(new JButton("Cadastrar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JTextField[] componentesCampos = {campoDoCodigo, campoDoNome};

        JComponent[] componentesTextos = { textoCodigo, textoNome};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};

        setCampos(componentesCampos);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesTextos, painelTextos);

        OuvinteCadastroProduto ouvinteCadastroProduto = new OuvinteCadastroProduto(this,sistema);
        getBotaoConfirmatorio().addActionListener(ouvinteCadastroProduto);
        getBotaoCancelatorio().addActionListener(ouvinteCadastroProduto);
        campoDoCodigo.addKeyListener(ouvinteCadastroProduto);
        campoDoNome.addKeyListener(ouvinteCadastroProduto);
    
        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        setVisible(true);
    }

    public class OuvinteCadastroProduto extends OuvinteDeCampos{
        private JanelaCadastroProduto janela;

        public OuvinteCadastroProduto (JanelaCadastroProduto janela, SistemaMercado sistema){
            super(janela, sistema);
            setJanela(janela);
        }
        
        @Override 
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        protected void confirmar() {
            String nome = getCampoDoNome().getText();
            if(getSistema().buscarProdutoPorNome(nome) != null){
                JOptionPane.showMessageDialog(janela, "Já existe um produto com este nome cadastrado", "Aviso", JOptionPane.ERROR_MESSAGE);
            
            }else{
                Produto produto = new Produto(nome, getSistema());
                getSistema().getProdutosEmEstoque().add(produto);
                JOptionPane.showMessageDialog(janela, "Produto cadastrado!\n\nCodigo: " + produto.getCodigo() + "\nNome: " + produto.getNome());
                janela.dispose();
            }
        }

        public JanelaCadastroProduto getJanela() {
            return janela;
        }

        public void setJanela(JanelaCadastroProduto janela) {
            this.janela = janela;
        }

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

}
