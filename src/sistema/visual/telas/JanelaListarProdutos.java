package sistema.visual.telas;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.*;
import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;
import sistema.pessoas.usuarios.funcionarios.Almoxarife;
import sistema.pessoas.usuarios.funcionarios.Gerente;
import sistema.produtos.Produto;
import sistema.visual.ouvintes.OuvinteListarProdutos;

public class JanelaListarProdutos extends JFrame {
    private JTable tabela;
    private SistemaMercado sistema;
    private Font fonteDoCabecalho = new Font("arial", Font.BOLD, 30);
    private Font fonteDoCampo = new Font("arial", Font.PLAIN, 20);
    private Font fonteDoBotao = new Font("arial", Font.BOLD, 20);

    public JanelaListarProdutos(SistemaMercado sistema, Usuario usuario){
        setSize(650, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setSistema(sistema);
        adicionarTabela();
        String[] botoes = {"Detalhar", "Editar", "Excluir"};
        adicionarBotoes(botoes, usuario);
    }

    public void adicionarTabela(){
                
        JLabel cabecalho = new JLabel("Lista de Produtos", JLabel.CENTER);
        cabecalho.setBounds(0, 0, getWidth(), 60);
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor de Compra");
        modelo.addColumn("Valor de Venda");

        ArrayList<Produto> listaDeProdutos = getSistema().getProdutosEmEstoque();

        for (Produto produto : listaDeProdutos){
            Object[] linha = new Object[5];
            linha[0] = produto.getCodigo();
            linha[1] = produto.getNome();
            linha[2] = produto.getUnidade();
            linha[3] = produto.getValorUnitarioDeCompra();
            linha[4] = produto.getValorUnitarioDeVenda();
            modelo.addRow(linha);  
        }
        
        tabela = new JTable(modelo);
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(40, 80, 570, 270);
        add(painel);
        cabecalho.setFont(getFonteDoCabecalho());
        cabecalho.setBackground(Color.LIGHT_GRAY);
        cabecalho.setOpaque(true);
        add(cabecalho);
        setVisible(true);
    }
    public void adicionarBotoes(String[] rotulos, Usuario usuario){
        OuvinteListarProdutos ouvinte = new OuvinteListarProdutos(this, sistema);

        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        painel.setBounds(getBounds());
        for(String rotulo : rotulos){
            JButton botao = new JButton(rotulo);
            botao.addActionListener(ouvinte);
            painel.add(botao);
        }
        if(usuario instanceof Gerente){
            JButton botao = new JButton("Valor unitário de venda");
            botao.addActionListener(ouvinte);
            painel.add(botao);

        }else if(usuario instanceof Almoxarife){
            JButton botao = new JButton("Registrar Entrada");
            botao.addActionListener(ouvinte);
            painel.add(botao);
        }
        painel.setBounds(0, 380, getWidth(), 100);
        add(painel);
    }
    
    public Font getFonteDoCabecalho() {
        return fonteDoCabecalho;
    }

    public void setFonteDoCabecalho(Font fonteDoCabecalho) {
        this.fonteDoCabecalho = fonteDoCabecalho;
    }

    public Font getFonteDoCampo() {
        return fonteDoCampo;
    }

    public void setFonteDoCampo(Font fonteDoCampo) {
        this.fonteDoCampo = fonteDoCampo;
    }

    public Font getFonteDoBotao() {
        return fonteDoBotao;
    }

    public void setFonteDoBotao(Font fonteDoBotao) {
        this.fonteDoBotao = fonteDoBotao;
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    
}
