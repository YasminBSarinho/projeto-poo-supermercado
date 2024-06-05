package projeto.sistema.ouvintes;

import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaUsuario;

public class OuvinteUsuario{
    private JanelaUsuario janela;
    private SistemaMercado sistema;
    
    public OuvinteUsuario(JanelaUsuario janela, SistemaMercado sistema){
        setJanela(janela);
        setSistema(sistema);
    }
    
    public JanelaUsuario getJanela() {
        return janela;
    }
    
    public void setJanela(JanelaUsuario janela) {
        this.janela = janela;
        }
        
    public SistemaMercado getSistema() {
        return sistema;
    }
    
    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }
        
}
