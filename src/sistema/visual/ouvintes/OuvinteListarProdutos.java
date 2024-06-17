package sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sistema.SistemaMercado;
import sistema.produtos.Produto;
import sistema.utilitarios.Json;
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
                    break;
                case "Excluir":
                    int resposta = JOptionPane.showConfirmDialog(janela, "Você deseja excluir " + produto.getNome() + "?");
                    if(resposta == JOptionPane.YES_OPTION){
                        DefaultTableModel modelo = (DefaultTableModel) janela.getTabela().getModel();
                        modelo.removeRow(linhaSelecionada);
                        janela.getTabela().repaint();
                        listaProdutos.remove(linhaSelecionada);
                        json.escreverJson(sistema);
                    }
                    break;
                case "Valor unitário de venda":
                    try{
                        float valor = Float.parseFloat(JOptionPane.showInputDialog(janela, "Digite o valor:"));
                        if(valor <= 0){
                            JOptionPane.showMessageDialog(janela, "Digite um valor válido");
                        }else{
                            produto.setValorUnitarioDeVenda(valor);
                            json.escreverJson(sistema);
                            DefaultTableModel modelo = (DefaultTableModel) janela.getTabela().getModel();
                            modelo.setValueAt(valor, linhaSelecionada, 4);
                            janela.getTabela().repaint();
                        }
                    }
                    catch(Exception error){
                        JOptionPane.showMessageDialog(janela, "Digite um valor válido");
                    }
                    break;
                case "Registrar Entrada":
                    break;
                default:
                    break;
            }
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
