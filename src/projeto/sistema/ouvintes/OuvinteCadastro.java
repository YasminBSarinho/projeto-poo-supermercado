package projeto.sistema.ouvintes;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.JsonpCharacterEscapes;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.CaixaEletronico;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;
import projeto.sistema.telas.JanelaCadastroFuncionario;
import projeto.sistema.telas.JanelaLogin;
import projeto.sistema.utilitarios.Json;

public class OuvinteCadastro implements ActionListener {
    private JanelaCadastroFuncionario janela;
    private SistemaMercado sistema;
    private JButton botaoCancelar;
    private JButton botaoCadastrar;
    private JCheckBox checkAlmoxarife;
    private JCheckBox checkCaixa;
    private JCheckBox checkEmail;
    private JCheckBox checkNisPis;
    private ArrayList<Usuario> usuarios;

    public OuvinteCadastro(JanelaCadastroFuncionario janela, SistemaMercado sistema){
        this.janela = janela;
        this.sistema = sistema;
        this.botaoCancelar = janela.getBotaoCancelar();
        this.botaoCadastrar = janela.getBotaoCadastrar();
        this.checkAlmoxarife = janela.getCheckAlmoxarife();
        this.checkCaixa = janela.getCheckCaixa();
        this.checkEmail = janela.getCheckEmail();
        this.checkNisPis = janela.getCheckNisPis();
        this.usuarios = sistema.getListaDeUsuarios();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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
        
        if(checkEmail.isSelected()){
            janela.getCampoDoEmail().setEnabled(true);
        }else{
            janela.getCampoDoEmail().setEnabled(false);
        }
        
        if (checkNisPis.isSelected()){
            janela.getCampoDaMatricula().setEnabled(true);;
        }else{
            janela.getCampoDaMatricula().setEnabled(false);;
        }

    }
    
    public void Cadastrar(String cargo, ArrayList<Usuario> listaDeUsuarios){
        String nome = janela.getCampoDoNome().getText();
        String login = janela.getCampoDoLogin().getText();
        String senha = new String(janela.getCampoDaSenha().getPassword());
        String confirmacao = new String(janela.getCampoConfirmar().getPassword());
        String email = janela.getCampoDoEmail().getText();
        String matricula = janela.getCampoDaMatricula().getText();

        boolean cadastrado = true;
        boolean valido = verificarCampos(nome, login, senha, confirmacao, email, matricula);

        if(sistema.isSemGerente()){
            cargo = "Gerente";
        }
       
        if(valido){
            switch (cargo.toLowerCase()) {
                case "almoxarife":
                    listaDeUsuarios.add(new Almoxarife(nome, cargo, login, senha, email, matricula));
                    break;
                case "caixa eletronico":
                    listaDeUsuarios.add(new CaixaEletronico(nome, cargo, login, senha, email, matricula));;
                    break;
                case "gerente":
                    listaDeUsuarios.add(new Gerente(nome, cargo, login, senha, email, matricula));
                    break;
                default:
                    JOptionPane.showMessageDialog(janela, "Selecione um cargo", 
                    "aviso", JOptionPane.ERROR_MESSAGE);
                    cadastrado = false;
                    break;

            }if (cadastrado){
                Json json = new Json();
                janela.dispose();
                JOptionPane.showMessageDialog(janela, "Cadastro concluido!");
                json.escreverJson(sistema);
                JanelaLogin janelaDeLogin = new JanelaLogin(sistema);
            }
        }

    }


    public boolean verificarCampos(String nome, String login, String senha, String confirmacao, String email, String matricula){
        if(nome.isEmpty() || login.isEmpty() || senha.isEmpty() || confirmacao.isEmpty()){
            JOptionPane.showMessageDialog(janela, "Preencha todos os campos obrigatórios",
                                     "Campo Vazio", JOptionPane.ERROR_MESSAGE);
            return false;
        }if((checkEmail.isSelected() && email.isEmpty())  || (checkNisPis.isSelected() && matricula.isEmpty())){
            JOptionPane.showMessageDialog(janela, "Preencha todos os campos obrigatórios",
            "Campo Vazio", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public JanelaCadastroFuncionario getJanela() {
        return janela;
    }

    public void setJanela(JanelaCadastroFuncionario janela) {
        this.janela = janela;
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

}
