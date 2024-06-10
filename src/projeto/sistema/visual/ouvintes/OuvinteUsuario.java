package projeto.sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.telas.JanelaCadastroCliente;
import projeto.sistema.visual.telas.JanelaLogin;
import projeto.sistema.visual.telas.usuarios.JanelaUsuario;

public class OuvinteUsuario implements ActionListener{
    private JanelaUsuario janela;
    private SistemaMercado sistema;
    
    public OuvinteUsuario(JanelaUsuario janela, SistemaMercado sistema){
        setJanela(janela);
        setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(janela.getCadastrarCliente())){
            JanelaCadastroCliente janela = new JanelaCadastroCliente(sistema);
        }
        else if(e.getSource().equals(janela.getTrocarUsuario())){
            janela.dispose();
            JanelaLogin janela = new JanelaLogin(sistema);
        }
        else if(e.getSource().equals(janela.getSair())){
            janela.dispose();
        }
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
