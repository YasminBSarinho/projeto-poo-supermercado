package projeto.sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.visual.telas.JanelaLogin;
import projeto.sistema.visual.telas.usuarios.JanelaCaixa;
import projeto.sistema.visual.telas.usuarios.funcionarios.JanelaAlmoxarife;
import projeto.sistema.visual.telas.usuarios.funcionarios.JanelaGerente;

public class OuvinteLogin extends OuvinteDeCampos{
    JanelaLogin janela;

    public OuvinteLogin(JanelaLogin janela, SistemaMercado sistema){
        super(janela, sistema);
        setJanela(janela);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    @Override

    public void confirmar(){
        String login = janela.getCampoDoLogin().getText();
        String senha = new String(janela.getCampoDaSenha().getPassword());

        Usuario usuario = sistema.getUsuarioLogado(login, senha);
        
        if(usuario == null){
            JOptionPane.showMessageDialog(janela, "O Login informado não é válido",
                                        "Credenciais Incorretas", JOptionPane.ERROR_MESSAGE);
        }

        else{
            janela.dispose();
            JOptionPane.showMessageDialog(janela, "O Login foi efetuado!!");
            switch (usuario.getCargo().toLowerCase()){
                case "gerente":
                    JanelaGerente janelaGerente = new JanelaGerente(getSistema(), usuario); 
                    break;
                case "almoxarife":
                    JanelaAlmoxarife janelaAlmoxarife = new JanelaAlmoxarife(getSistema(), usuario);
                    break;
                case "caixa eletronico":
                    JanelaCaixa janelaCaixa = new JanelaCaixa(getSistema(), usuario);
                    break;
                }
            }  
        }


    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public JanelaLogin getJanela() {
        return janela;
    }

    public void setJanela(JanelaLogin janela) {
        this.janela = janela;
    }
}
