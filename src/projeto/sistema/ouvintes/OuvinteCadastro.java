package projeto.sistema.ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;
import projeto.sistema.telas.JanelaDeCadastro;
import projeto.sistema.utilitarios.Json;

public class OuvinteCadastro implements ActionListener {
    private JanelaDeCadastro janela;
    private SistemaMercado sistema;

    public OuvinteCadastro(JanelaDeCadastro janela, SistemaMercado sistema){
        this.setJanela(janela);
        this.setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaoCadastrar = janela.getBotaoCadastrar();
        Json json = new Json();
        if(e.getSource().equals(botaoCadastrar)){
            String nome = janela.getCampoDonome().getText();
            String login = janela.getCampoDoLogin().getText();
            String senha = new String(janela.getCampoDasenha().getPassword());
            String confirmacao = new String(janela.getCampoDeconfirmacao().getPassword());
            String email = janela.getCampoDoEmail().getText();
            String matricula = janela.getCampoDaMatricula().getText();
            if(sistema.verificarExistenciaDeUsuarios()){
                Gerente gerente = new Gerente(nome,"gerente",login, senha, email, matricula);
                sistema.getListaDeUsuarios().add(gerente);
                janela.setVisible(false);
                json.escreverJson(sistema);
            }
        }else if (e.getSource().equals(janela.getBotaoCancelar())){
            janela.dispose();
        }
    }
    
    public JanelaDeCadastro getJanela() {
        return janela;
    }

    public void setJanela(JanelaDeCadastro janela) {
        this.janela = janela;
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

}
