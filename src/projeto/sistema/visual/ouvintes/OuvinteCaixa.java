package projeto.sistema.visual.ouvintes;

import java.awt.event.ActionEvent;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.telas.usuarios.JanelaCaixa;

public class OuvinteCaixa extends OuvinteUsuario{
    private JanelaCaixa janela;
    private SistemaMercado sistema;
    
    public OuvinteCaixa(JanelaCaixa janela, SistemaMercado sistema) {
        super(janela, sistema);
        setJanela(janela);
        setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(janela.getRealizarVenda())){
            
        }
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
