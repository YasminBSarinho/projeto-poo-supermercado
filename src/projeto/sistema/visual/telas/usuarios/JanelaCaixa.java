package projeto.sistema.visual.telas.usuarios;

import javax.swing.JButton;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.ouvintes.OuvinteCaixa;

public class JanelaCaixa extends JanelaUsuario{
    private JanelaCaixa janela;
    private SistemaMercado sistema;
    private JButton realizarVenda;
    
    public JanelaCaixa(SistemaMercado sistema){
        super(sistema);

        realizarVenda = adicionarBotao("Realizar venda", getFonteDoBotao(), getPainelBotoes());
        OuvinteCaixa ouvinteCaixa = new OuvinteCaixa(this,sistema);
        getRealizarVenda().addActionListener(ouvinteCaixa);
    }
    
    public JButton getRealizarVenda() {
        return realizarVenda;
    }
            
    public void setRealizarVenda(JButton realizarVenda) {
        this.realizarVenda = realizarVenda;
    }

    public JanelaCaixa getJanela() {
        return janela;
    }
    public void setJanela(JanelaCaixa janela) {
        this.janela = janela;
    }
            
    public SistemaMercado getSistema() {
        return sistema;
    }
        
    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }
}
            