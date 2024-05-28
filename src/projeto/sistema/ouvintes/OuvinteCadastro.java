package projeto.sistema.ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.JButton;

import com.fasterxml.jackson.databind.ObjectMapper;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;
import projeto.sistema.telas.JanelaDeCadastro;

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
        	ObjectMapper conversor = new ObjectMapper();
        if(e.getSource().equals(botaoCadastrar)){
            String nome = janela.getCampoDonome().getText();
            String login = janela.getCampoDoLogin().getText();
            String senha = new String(janela.getCampoDasenha().getPassword());
            String confirmacao = new String(janela.getCampoDeconfirmacao().getPassword());
            String email = janela.getCampoDoLogin().getText();
            String matricula = janela.getCampoDaMatricula().getText();
            if(sistema.verificarExistenciaDeUsuarios()){
                try{
                    Gerente gerente = new Gerente(nome,"gerente",login, senha, email, matricula);
                    sistema.getListaDeUsuarios().add(gerente);
                	FileWriter escritor = new FileWriter("sistema.json");
					String jsonSistema = conversor.writeValueAsString(sistema);
					escritor.write(jsonSistema);
					escritor.close();
                    janela.setVisible(false);
                }catch(Exception error){
                    System.out.println(error.getMessage());
                }
            }
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
