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
        JTextField campo = (JTextField) e.getSource();
        
        String nome = campoNome.getText();
        int unidade = -1;

        try{
            unidade = Integer.parseInt(campoUnidade.getText());
        }catch(NumberFormatException error){
            
        }

        char letra = e.getKeyChar(); 

        if(campo.equals(campoUnidade)){
            if (!Character.isDigit(letra) || unidade == 0) {
                e.consume();
            }
        }

    }

    @Override
    protected void confirmar() {
        String nome = janela.getCampoDoNome().getText();
        int unidade = Integer.parseInt(janela.getCampoDaUnidade().getText());
        if(sistema.buscarProdutoPorNome(nome) != null){
            JOptionPane.showMessageDialog(janela, "Já existe um produto com este nome cadastrado", "Aviso", JOptionPane.ERROR_MESSAGE);
        
        }else{
            Produto produto = new Produto(nome, unidade, sistema);
            sistema.getProdutosEmEstoque().add(produto);
            Json json = new Json();
            janela.dispose();

            JOptionPane.showMessageDialog(janela, "Produto cadastrado!\n\nCodigo: " + produto.getCodigo() + "\nNome: " + produto.getNome() + "\nUnidades: " + produto.getUnidade());
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
