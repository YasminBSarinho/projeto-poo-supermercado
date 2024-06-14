package projeto.sistema.visual.telas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;

public class JanelaListarProdutos extends JFrame {
    private Font fonteDoCabecalho = new Font("arial", Font.BOLD, 30);
    private Font fonteDoCampo = new Font("arial", Font.PLAIN, 20);
    private Font fonteDoBotao = new Font("arial", Font.BOLD, 20);

    public JanelaListarProdutos(SistemaMercado sistema){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 500);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JLabel cabecalho = new JLabel("Lista de Produtos", JLabel.CENTER);
        cabecalho.setBounds(0, 0, getWidth(), 60);
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor de Compra");
        modelo.addColumn("Valor de Venda");

        ArrayList<Produto> listaDeProdutos = sistema.getProdutosEmEstoque();

        for (Produto produto : listaDeProdutos){
            Object[] linha = new Object[5];
            linha[0] = produto.getCodigo();
            linha[1] = produto.getNome();
            linha[2] = produto.getUnidade();
            linha[3] = produto.getValorUnitarioDeCompra();
            linha[4] = produto.getValorUnitarioDeVenda();
            modelo.addRow(linha);  
        }
        
        JTable tabela = new JTable(modelo);
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(40, 80, 570, 270);
        add(painel);
        cabecalho.setFont(getFonteDoCabecalho());
        cabecalho.setBackground(Color.LIGHT_GRAY);
        cabecalho.setOpaque(true);
        add(cabecalho);
        setVisible(true);
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

    
}
