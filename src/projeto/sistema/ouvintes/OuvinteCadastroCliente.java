package projeto.sistema.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.Cliente;
import projeto.sistema.telas.JanelaCadastroCliente;
import projeto.sistema.utilitarios.Json;

public class OuvinteCadastroCliente extends OuvinteDeFormularios {
    private JanelaCadastroCliente janela;
    private SistemaMercado sistema;
    private JCheckBox checkEmail;
    private JCheckBox checkEndereco;

    public OuvinteCadastroCliente(JanelaCadastroCliente janela, SistemaMercado sistema){
        super(janela, sistema);
        this.setJanela(janela);
        this.setSistema(sistema);
        checkEmail = janela.getCheckEmail();
        checkEndereco = janela.getCheckEndereco();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        monitorarCampos(e);
        super.actionPerformed(e);
    }

    @Override
    public void confirmar(){
        String nome = janela.getCampoDoNome().getText();
        String email = janela.getCampoDoEmail().getText();
        String cpf = janela.getCampoDoCPF().getText();
        String endereco = janela.getCampoDoEndereco().getText();

        if (sistema.buscarCliente(cpf) != null){
            JOptionPane.showMessageDialog(janela,"Este cliente já está cadastrado!",
                                    "Aviso", JOptionPane.ERROR_MESSAGE);
        }else{
            sistema.getClientes().add(new Cliente(nome,email,cpf,endereco));
            Json json = new Json();
            janela.dispose();
            JOptionPane.showMessageDialog(janela, "Cliente cadastrado!");
            json.escreverJson(sistema);
        }
    }
    
    public void monitorarCampos(ActionEvent e){
        if(e.getSource() instanceof JCheckBox){
            JCheckBox checkbox = (JCheckBox) e.getSource();
            boolean isMarcado = checkbox.isSelected();

            if (e.getSource().equals(checkEmail)) {
                janela.getCampoDoEmail().setEnabled(isMarcado);
            }
            if (e.getSource().equals(checkEndereco)) {
                janela.getCampoDoEndereco().setEnabled(isMarcado);
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

    public JCheckBox getCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(JCheckBox checkEmail) {
        this.checkEmail = checkEmail;
    }

    public JCheckBox getCheckEndereco() {
        return checkEndereco;
    }

    public void setCheckEndereco(JCheckBox checkEndereco) {
        this.checkEndereco = checkEndereco;
    }
    
}
