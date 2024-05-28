package projeto.sistema.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.telas.JanelaDeLogin;

public class OuvinteLogin implements ActionListener{
    private JanelaDeLogin janela;
    private SistemaMercado sistema;
    
    public OuvinteLogin(JanelaDeLogin janela, SistemaMercado sistema){
        setJanela(janela);
        setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaoLogin = janela.getBotaoLogin();
        JButton botaoCancelar = janela.getBotaoCancelar();
        String login = janela.getCampoDoLogin().getText();
        String senha = new String(janela.getCampoDasenha().getPassword());
        

        if(e.getSource().equals(botaoLogin)){
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

        }else if(e.getSource().equals(botaoCancelar)){
            janela.dispose();
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

    public JanelaDeLogin getJanela() {
        return janela;
    }

    public void setJanela(JanelaDeLogin janela) {
        this.janela = janela;
    }


    
}
