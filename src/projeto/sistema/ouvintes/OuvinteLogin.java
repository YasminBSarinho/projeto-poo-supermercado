package projeto.sistema.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.telas.JanelaLogin;

public class OuvinteLogin extends OuvinteDeCampos{
    JanelaLogin janela;
    SistemaMercado sistema;

    public OuvinteLogin(JanelaLogin janela, SistemaMercado sistema){
        super(janela, sistema);
        setJanela(janela);
        setSistema(sistema);
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
            switch (usuario.getCargo().toLowerCase()){
                case "gerente":
                    // Tela do Gerente.
                    break;
                case "almoxarife":
                    // Tela almoxarife
                    break;
                case "caixa eletronico":
                    // Tela caixa eletronico
                    break;
                default:
                    break;
            }
        }
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void verificarCargo(String cargo){

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
