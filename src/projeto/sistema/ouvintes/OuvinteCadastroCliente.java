package projeto.sistema.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.Cliente;
import projeto.sistema.telas.JanelaCadastroCliente;
import projeto.sistema.utilitarios.Json;

public class OuvinteCadastroCliente implements ActionListener {
    private JanelaCadastroCliente janela;
    private SistemaMercado sistema;

    public OuvinteCadastroCliente(JanelaCadastroCliente janela, SistemaMercado sistema){
        this.setJanela(janela);
        this.setSistema(sistema);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botaoCancelar = janela.getBotaoCancelar();
        JButton botaoCadastrar = janela.getBotaoCadastrar();
        JCheckBox checkEmail = janela.getCheckEmail();
        JCheckBox checkEndereco = janela.getCheckEndereco();
        ArrayList<Cliente> clientes = sistema.getClientes();
        JTextField email = janela.getCampoDoEmail();
        JTextField endereco = janela.getCampoDoEndereco();

        if(e.getSource().equals(botaoCadastrar)){
            this.CadastrarCliente(clientes);
            
        } else if (e.getSource().equals(botaoCancelar)) {
            janela.dispose();
        }
    }

    public void CadastrarCliente(ArrayList<Cliente> clientes){
        String nome = janela.getCampoDoNome().getText();
        String email = janela.getCampoDoEmail().getText();
        String cpf = janela.getCampoDoCPF().getText();
        String endereco = janela.getCampoDoEndereco().getText();
        clientes.add(new Cliente(nome,email,cpf,endereco));
        
        Json json = new Json();
        janela.dispose();
        JOptionPane.showMessageDialog(janela, "Cliente cadastrado!");
        json.escreverJson(sistema);

    }
    
    public JanelaCadastroCliente getJanela() {
        return janela;
    }
    
    public void setJanela(JanelaCadastroCliente janela) {
        this.janela = janela;
    }
    
    public SistemaMercado getSistema() {
        return sistema;
    }
    
    
    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }
}
