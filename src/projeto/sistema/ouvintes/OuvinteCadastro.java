package projeto.sistema.ouvintes;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.CaixaEletronico;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
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
        JButton botaoCancelar = janela.getBotaoCancelar();
        JButton botaoCadastrar = janela.getBotaoCadastrar();
        JCheckBox checkAlmoxarife = janela.getCheckAlmoxarife();
        JCheckBox checkCaixa = janela.getCheckCaixa();
        ArrayList<Usuario> usuarios = sistema.getListaDeUsuarios();
        String cargo = "";

        if(checkAlmoxarife.isSelected()){
            checkCaixa.setEnabled(false);
            cargo = "Almoxarife";
        }
        else if(checkCaixa.isSelected()){
            checkAlmoxarife.setEnabled(false);
            cargo = "Caixa Eletronico";
        }else{
            checkAlmoxarife.setEnabled(true);
            checkCaixa.setEnabled(true);
        }
        
        if(e.getSource().equals(botaoCadastrar)){
            this.Cadastrar(cargo, usuarios);
            

        } else if (e.getSource().equals(botaoCancelar)) {
            janela.dispose();
        }
    }
    
    public void Cadastrar(String cargo, ArrayList<Usuario> listaDeUsuarios){
        String nome = janela.getCampoDonome().getText();
        String login = janela.getCampoDoLogin().getText();
        String senha = new String(janela.getCampoDasenha().getPassword());
        String confirmacao = new String(janela.getCampoDeconfirmacao().getPassword());
        String email = janela.getCampoDoEmail().getText();
        String matricula = janela.getCampoDaMatricula().getText();
        boolean cadastrado = true;

        if(sistema.isSemGerente()){
            cargo = "Gerente";
        }
        switch (cargo) {
            case "Almoxarife":
                listaDeUsuarios.add(new Almoxarife(nome, cargo, login, senha, email, matricula));
                break;
            case "Caixa Eletronico":
                listaDeUsuarios.add(new CaixaEletronico(nome, cargo, login, senha, email, matricula));;
                break;
            case "Gerente":
                listaDeUsuarios.add(new Gerente(nome, cargo, login, senha, email, matricula));
                break;
            default:
                JOptionPane.showMessageDialog(janela, "Selecione um cargo", 
                "aviso", JOptionPane.ERROR_MESSAGE);
                cadastrado = false;
                break;
        }if (cadastrado){
            Json json = new Json();
            janela.setVisible(false);
            json.escreverJson(sistema);
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
