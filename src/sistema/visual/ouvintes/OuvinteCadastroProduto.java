package sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sistema.SistemaMercado;
import sistema.produtos.Produto;
import sistema.utilitarios.Json;
import sistema.visual.telas.JanelaCadastroProduto;

public class OuvinteCadastroProduto extends OuvinteDeCampos{
    private JanelaCadastroProduto janela;

    public OuvinteCadastroProduto(JanelaCadastroProduto janela, SistemaMercado sistema) {
        super(janela, sistema);
        setJanela(janela);
    }

    @Override 
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField campoDoCodigo = janela.getCampoDoCodigo();
        JTextField campoNome = janela.getCampoDoNome();
        JTextField campoUnidade = janela.getCampoDaUnidade();
        JTextField campoValorDeCompra = janela.getCampoValorDeCompra();
        JTextField campoValorDeVenda = janela.getCampoValorDeVenda();
        JTextField campo = (JTextField) e.getSource();
        
        String nome = campoNome.getText();
        String campoVendaTexto = campoValorDeVenda.getText();
        String campoCompraTexto = campoValorDeCompra.getText();
        int unidade = -1;

        char letra = e.getKeyChar(); 

        if(campo.equals(campoUnidade)){
            if (!Character.isDigit(letra) || unidade == 0) {
                e.consume();
        }
        /* else if(campo.equals(campoValorDeCompra)){
            if(!Character.isDigit(letra) && letra != '.'){
                e.consume();
            }
        } else if (campo.equals(campoValorDeVenda)) {
            if((!Character.isDigit(letra) && letra != '.') || (campoVendaTexto.length() > 0 && campoVendaTexto.contains("."))){
                e.consume();
            }*/
        } 

    }

    @Override
    protected void confirmar() {
        String nome = janela.getCampoDoNome().getText();
        int unidade = Integer.parseInt(janela.getCampoDaUnidade().getText());
        float compra = Float.parseFloat(janela.getCampoValorDeCompra().getText());
        float venda = Float.parseFloat(janela.getCampoValorDeVenda().getText());

        if(sistema.buscarProdutoPorNome(nome) != null){
            JOptionPane.showMessageDialog(janela, "Já existe um produto com este nome cadastrado", "Aviso", JOptionPane.ERROR_MESSAGE);
        
        }else{
            Produto produto = new Produto(nome, unidade, compra, venda, sistema);
            sistema.getProdutosEmEstoque().add(produto);
            Json json = new Json();
            janela.dispose();

            JOptionPane.showMessageDialog(janela, "Produto cadastrado!\n\nCodigo: " + produto.getCodigo() + "\nNome: " + produto.getNome() + "\nUnidades: " + produto.getUnidade() + "\nValor de Compra: " + produto.getValorUnitarioDeCompra() + "\nValor de  Venda: " + produto.getValorUnitarioDeVenda());
            json.escreverJson(sistema);
        }
    }
    
    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public JanelaCadastroProduto getJanela() {
        return janela;
    }

    public void setJanela(JanelaCadastroProduto janela) {
        this.janela = janela;
    }
}
