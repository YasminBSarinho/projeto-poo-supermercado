package sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sistema.SistemaMercado;
import sistema.produtos.Produto;
import sistema.utilitarios.Json;
import sistema.utilitarios.Registro;
import sistema.visual.telas.JanelaEditar;
import sistema.visual.telas.JanelaEntradaEstoque;
import sistema.visual.telas.JanelaListarProdutos;

public class OuvinteListarProdutos implements ActionListener{
    private SistemaMercado sistema;
    private JanelaListarProdutos janela;
    public OuvinteListarProdutos(JanelaListarProdutos janela, SistemaMercado sistema){
        setJanela(janela);
        setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int linhaSelecionada = janela.getTabela().getSelectedRow();
        Json json = new Json();
        
        if(linhaSelecionada == -1){
            JOptionPane.showMessageDialog(janela, "Nenhuma linha selecionada", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            ArrayList<Produto> listaProdutos = sistema.getProdutosEmEstoque();
            Produto produto = listaProdutos.get(linhaSelecionada);

            switch (e.getActionCommand()) {
                case "Detalhar":
                    JOptionPane.showMessageDialog(janela, "Detalhes:\n\nCodigo: " + produto.getCodigo() + "\nNome: " 
                                                    + produto.getNome() + "\nUnidades: " + produto.getUnidade() 
                                                    + "\nValor de compra: " + produto.getValorUnitarioDeCompra() 
                                                    + "\nValor de venda: " + produto.getValorUnitarioDeVenda());
                    break;
                    
                case "Editar":
                    JanelaEditar janelaEditar = new JanelaEditar(sistema);
                    janelaEditar.receberProduto(produto);
                    janelaEditar.setJanelaTabela(this.janela);
                    janelaEditar.setLinha(linhaSelecionada);
                    break;

                case "Excluir":
                    if (verificarVendaProduto(produto, sistema.getRegistrosDeVenda())) {
                        excluirProduto(produto, listaProdutos, linhaSelecionada); 
                    } else{
                        JOptionPane.showMessageDialog(janela, "Produto não pode ser excluido pois já foi vendido");
                    }
                    
                    break;

                case "Valor unitário de venda":
                    mudarValorDeVenda(produto, linhaSelecionada, 4);
                    
                    break;
                case "Registrar Entrada":
                    JanelaEntradaEstoque janelaEstoque = new JanelaEntradaEstoque(sistema);
                    janelaEstoque.receberProduto(produto);
                    janelaEstoque.setJanelaTabela(this.janela);
                    janelaEstoque.setLinha(linhaSelecionada);
                    break;

                default:
                    break;
            }
            json.escreverJson(sistema);
        }
        
    }

    public void excluirProduto(Produto produto, ArrayList<Produto> listaProdutos, int linha){
        int resposta = JOptionPane.showConfirmDialog(janela, "Você deseja excluir " + produto.getNome() + "?");
        if(resposta == JOptionPane.YES_OPTION){
            DefaultTableModel modelo = (DefaultTableModel) janela.getTabela().getModel();
            modelo.removeRow(linha);
            janela.getTabela().repaint();
            listaProdutos.remove(linha);
        }
    }

    public boolean verificarVendaProduto(Produto produto, ArrayList<Registro> registrosDeVenda){
        for (Registro registro : registrosDeVenda) {
            if(produto.getNome().equals(registro.getNome())){
                return false;
            }
        }
        return true;
    }

    public void mudarValorDeVenda(Produto produto, int linha, int coluna){
        try{
            float valor = Float.parseFloat(JOptionPane.showInputDialog(janela, "Digite o valor:"));
            if(valor <= 0){
                JOptionPane.showMessageDialog(janela, "Digite um valor acima de zero");
            }else{
                produto.setValorUnitarioDeVenda(valor);
                DefaultTableModel modelo = (DefaultTableModel) janela.getTabela().getModel();
                modelo.setValueAt(valor, linha, 4);
                janela.getTabela().repaint();
            }
        }catch(Exception error){
            JOptionPane.showMessageDialog(janela, "Você precisa digitar um valor numérico!");
        }
        
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public JanelaListarProdutos getJanela() {
        return janela;
    }

    public void setJanela(JanelaListarProdutos janela) {
        this.janela = janela;
    }

}
