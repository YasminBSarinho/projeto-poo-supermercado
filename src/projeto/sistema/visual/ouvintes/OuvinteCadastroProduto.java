package projeto.sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.telas.JanelaCadastroProduto;

public class OuvinteCadastroProduto extends OuvinteDeCampos{
    private JanelaCadastroProduto janela;
    private SistemaMercado sistema;

    public OuvinteCadastroProduto(JanelaCadastroProduto janela, SistemaMercado sistema) {
        super(janela, sistema);
        setJanela(janela);
        setSistema(sistema);
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
        int unidade = Integer.parseInt(campoUnidade.getText());
        char letra = e.getKeyChar(); 

        if(campo.equals(campoUnidade)){
            if (!Character.isDigit(letra) || unidade == 0) {
                e.consume();
            }
        }

    }

    @Override
    protected void confirmar() {
        
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
