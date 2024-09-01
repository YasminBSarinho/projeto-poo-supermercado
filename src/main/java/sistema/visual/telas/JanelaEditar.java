package sistema.visual.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import sistema.SistemaMercado;
import sistema.produtos.Produto;
import sistema.visual.ouvintes.OuvinteDeCampos;

public class JanelaEditar extends JanelaDeCampos{
    
    private JTextField campoDoCodigo;
    private JTextField campoDoNome;
    private JTextField campoDaUnidade;
    private JTextField campoValorDeCompra;
    private JTextField campoValorDeVenda;
    private Produto produto;
    private JanelaListarProdutos janelaTabela;
    private int linha;
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public JanelaEditar(SistemaMercado sistema){
        super(sistema);
        setSize(600, 480);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        adicionarCabecalho("Editando Produtos");
        
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
        campoDoNome = new JTextField();
        campoDaUnidade = new JTextField();
        campoValorDeCompra = new JTextField();
        campoValorDeVenda = new JTextField();

        setBotaoConfirmatorio(new JButton("Editar"));
        setBotaoCancelatorio(new JButton("Cancelar"));

        JTextField[] componentesCampos = {campoDoCodigo, campoDoNome, campoDaUnidade, campoValorDeCompra, campoValorDeVenda};

        JComponent[] componentesTextos = { textoCodigo, textoNome, textoUnidades, textoValorCompra, textoValorVenda};

        JComponent[] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};
        
        setCampos(componentesCampos);
        
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);
        adicionarFontes(componentesBotoes);

        OuvinteEditar ouvinteEditar = new OuvinteEditar(this, sistema);
        getBotaoConfirmatorio().addActionListener(ouvinteEditar);
        getBotaoCancelatorio().addActionListener(ouvinteEditar);

        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        setVisible(true);
    }
    
    public void receberProduto(Produto produto){
        this.produto = produto;
        this.campoDoCodigo.setText(produto.getCodigo());
        this.campoDoNome.setText(produto.getNome());
        this.campoDaUnidade.setText(String.valueOf(produto.getUnidade()));
        this.campoValorDeCompra.setText(String.valueOf(produto.getValorUnitarioDeCompra()));
        this.campoValorDeVenda.setText(String.valueOf(produto.getValorUnitarioDeVenda()));
    }

    public class OuvinteEditar extends OuvinteDeCampos{
        private JanelaEditar janela;

        public OuvinteEditar(JanelaEditar janela, SistemaMercado sistema){
            super(janela,sistema);
            this.setJanela(janela);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            super.actionPerformed(e);
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        protected void confirmar() {
            try{
                String nome = campoDoNome.getText();
                int unidades = Integer.parseInt(campoDaUnidade.getText());
                BigDecimal valorCompra = new BigDecimal(campoValorDeCompra.getText());
                BigDecimal valorVenda = new BigDecimal(campoValorDeVenda.getText());

                produto.setNome(nome);
                produto.setUnidade(unidades);
                produto.setValorUnitarioDeCompra(valorCompra);
                produto.setValorUnitarioDeVenda(valorVenda);
         
                DefaultTableModel modelo = (DefaultTableModel) getJanelaTabela().getTabela().getModel();
                modelo.setValueAt(nome, linha, 1);
                modelo.setValueAt(unidades, linha, 2);
                modelo.setValueAt(valorCompra, linha, 3);
                modelo.setValueAt(valorVenda, linha, 4);
                
                janelaTabela.getTabela().repaint();
                JOptionPane.showMessageDialog(janela,"Valores editados!");
                janela.dispose();

            }catch(Exception error){

            }
        }

        public JanelaEditar getJanela() {
            return janela;
        }

        public void setJanela(JanelaEditar janela) {
            this.janela = janela;
        }
        
    }
    
    public JTextField getCampoDoNome() {
        return campoDoNome;
    }

    public void setCampoDoNome(JTextField campoDoNome) {
        this.campoDoNome = campoDoNome;
    }

    public JTextField getCampoDoCodigo() {
        return campoDoCodigo;
    }

    public void setCampoDoCodigo(JTextField campoDoCodigo) {
        this.campoDoCodigo = campoDoCodigo;
    }

    public JTextField getCampoDaUnidade() {
        return campoDaUnidade;
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

    public JanelaListarProdutos getJanelaTabela() {
        return janelaTabela;
    }

    public void setJanelaTabela(JanelaListarProdutos janelaTabela) {
        this.janelaTabela = janelaTabela;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }


}
