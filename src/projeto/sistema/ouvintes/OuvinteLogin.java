package projeto.sistema.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.telas.JanelaLogin;

public class OuvinteLogin extends OuvinteDeFormularios{
    JanelaLogin janela;
    SistemaMercado sistema;

    public OuvinteLogin(JanelaLogin janela, SistemaMercado sistema){
        super(sistema, janela);
        setJanela(janela);
        setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        acaoAoConfirmar();
    }

    @Override

    public void acaoAoConfirmar(){
        String login = janela.getCampoDoLogin().getText();
        String senha = new String(janela.getCampoDaSenha().getPassword());

        Usuario usuario = sistema.getUsuarioLogado(login, senha);

        if(usuario.getCargo() != null){
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
