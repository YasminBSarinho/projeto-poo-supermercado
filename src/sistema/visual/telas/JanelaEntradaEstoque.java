package sistema.visual.telas;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistema.SistemaMercado;
import sistema.produtos.Produto;
import sistema.visual.ouvintes.OuvinteDeCampos;

public class JanelaEntradaEstoque extends JanelaDeCampos{
    private JTextField campoDoNome;
    private JTextField campoDoCodigo;
    private JTextField campoDaUnidade;
    private JTextField campoDoValorCompra;
    private Produto produto;
    private JanelaListarProdutos janelaTabela;
    private int linha;
    
    public JanelaEntradaEstoque(SistemaMercado sistema){
        super(sistema);
        setSize(600, 400); 
        setLayout(null);
        setLocationRelativeTo(null);
        
        adicionarCabecalho("Registrando Em Estoque");
        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();
        
        painelTextos.setLayout(new GridLayout(4, 1, 0, 10));
        painelCampos.setLayout(new GridLayout(4, 1, 0, 10));
        painelBotoes.setLayout(new GridLayout(1, 2, 20, 10));
        
        painelTextos.setBounds(90, 100, 160, 160);
        painelCampos.setBounds(250, 100, 240, 160);
        painelBotoes.setBounds(250, 280, 240, 50);
        
        JLabel nome = new JLabel("Nome:");
        JLabel codigo = new JLabel("Codigo:");
        JLabel unidade = new JLabel("Unidades:");
        JLabel valorCompra = new JLabel("Valor de compra:");
        
        campoDoNome = new JTextField(1);
        campoDoCodigo = new JTextField(1);
        campoDoNome.setEnabled(false);
        campoDoCodigo.setEnabled(false);
        campoDaUnidade = new JTextField(1);
        campoDoValorCompra = new JTextField(1);
        
        setBotaoConfirmatorio(new JButton("Cadastrar"));
        setBotaoCancelatorio(new JButton("Cancelar"));
        
        JComponent[] componentesTextos = {nome, codigo, unidade, valorCompra};
        JTextField [] componentesCampos = {campoDoNome, campoDoCodigo,campoDaUnidade, campoDoValorCompra};
        JComponent [] componentesBotoes = {getBotaoConfirmatorio(), getBotaoCancelatorio()};
        
        setFonteDoBotao(new Font("arial",Font.BOLD, 15));
        adicionarFontes(componentesBotoes);
        adicionarAoPainel(componentesTextos, painelTextos);
        adicionarAoPainel(componentesCampos, painelCampos);
        adicionarAoPainel(componentesBotoes, painelBotoes);
        adicionarFontes(componentesTextos);
        adicionarFontes(componentesCampos);

        
        setCampos(componentesCampos);
        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        
        OuvinteDoEstoque ouvinteEstoque = new OuvinteDoEstoque(this, sistema);
        getBotaoConfirmatorio().addActionListener(ouvinteEstoque);
        getBotaoCancelatorio().addActionListener(ouvinteEstoque);
        setVisible(true);
    }

    public void receberProduto(Produto produto){
        this.produto = produto;
        this.campoDoCodigo.setText(produto.getCodigo());
        this.campoDoNome.setText(produto.getNome());
        repaint();
    }

    public class OuvinteDoEstoque extends OuvinteDeCampos{
        private JanelaEntradaEstoque janela;

        public OuvinteDoEstoque(JanelaEntradaEstoque janela,SistemaMercado sistema){
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
                int unidades = Integer.parseInt(campoDaUnidade.getText());
                float valor = Float.parseFloat(campoDoValorCompra.getText());

                produto.setUnidade(unidades);
                produto.setValorUnitarioDeCompra(valor);
         
                DefaultTableModel modelo = (DefaultTableModel) getJanelaTabela().getTabela().getModel();
                modelo.setValueAt(unidades, getLinha(), 2);
                modelo.setValueAt(valor, getLinha(), 3);
                
                janelaTabela.getTabela().repaint();
                JOptionPane.showMessageDialog(janela,"Unidade e valor cadastrado!");
                janela.dispose();

            }catch(Exception error){

            }
        }

        public JanelaEntradaEstoque getJanela() {
            return janela;
        }

        public void setJanela(JanelaEntradaEstoque janela) {
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
    
    public void setCampoDoValorCompra(JTextField campoDoValorCompra) {
        this.campoDoValorCompra = campoDoValorCompra;
    }
    
    public JTextField getCampoDoValorCompra() {
        return campoDoValorCompra;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
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
