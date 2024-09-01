package sistema.visual.ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import sistema.SistemaMercado;
import sistema.pessoas.usuarios.CaixaEletronico;
import sistema.pessoas.usuarios.Usuario;
import sistema.pessoas.usuarios.funcionarios.Almoxarife;
import sistema.pessoas.usuarios.funcionarios.Gerente;
import sistema.utilitarios.Json;
import sistema.visual.telas.JanelaCadastroUsuario;
import sistema.visual.telas.JanelaLogin;

public class OuvinteCadastroUsuario extends OuvinteDeCampos{
    private JanelaCadastroUsuario janela;
    private JRadioButton checkAlmoxarife;
    private JRadioButton checkCaixa;
    private JCheckBox checkEmail;
    private JCheckBox checkNisPis;

    public OuvinteCadastroUsuario(JanelaCadastroUsuario janela, SistemaMercado sistema){
        super(janela, sistema);
        setJanela(janela);
        checkAlmoxarife = janela.getCheckAlmoxarife();
        checkCaixa = janela.getCheckCaixa();
        checkEmail = janela.getCheckEmail();
        checkNisPis = janela.getCheckNisPis();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        monitorarCampos(e);
        super.actionPerformed(e);
    }

    @Override
    protected void confirmar(){
        try{
            this.cadastrar(sistema.getListaDeUsuarios());
        }
        catch(Exception erro){
            System.out.println(erro.getMessage());
        }
      
    }

    public String getCargoEscolhido(){

            if(sistema.isSemGerente()){
                return "Gerente";
            }

            else if(checkAlmoxarife.isSelected()){
                return "Almoxarife";
            }
            else if(checkCaixa.isSelected()){
                return "Caixa Eletronico";

            }
        return "";
    }

    public void monitorarCampos(ActionEvent e){
        if(e.getSource() instanceof JCheckBox){
            JCheckBox checkbox = (JCheckBox) e.getSource();
            boolean isMarcado = checkbox.isSelected();

            if (e.getSource().equals(checkEmail)) {
                janela.getCampoDoEmail().setEnabled(isMarcado);
            }
            if (e.getSource().equals(checkNisPis)) {
                janela.getCampoDaMatricula().setEnabled(isMarcado);
            }
        }
    }
    
    public void cadastrar(ArrayList<Usuario> listaDeUsuarios) throws Exception{

        String cargo = getCargoEscolhido();
        String nome = janela.getCampoDoNome().getText();
        String login = janela.getCampoDoLogin().getText();
        String senha = new String(janela.getCampoDaSenha().getPassword());
        String confirmacao = new String(janela.getCampoConfirmar().getPassword());
        String email = janela.getCampoDoEmail().getText();
        String matricula = janela.getCampoDaMatricula().getText();
        boolean cadastrado = true;
        boolean senhaConfirmada = senha.equals(confirmacao);

        if(!senhaConfirmada){
            JOptionPane.showMessageDialog(janela, "Senhas não coincidem");
            throw new Exception("Senhas não conhecidem");
        }

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
                "Aviso", JOptionPane.ERROR_MESSAGE);
                cadastrado = false;
                break;
            
        }if (cadastrado){
            Json json = new Json();
            janela.dispose();
            json.escreverJson(sistema);
            if(cargo.equalsIgnoreCase("gerente")){
                JOptionPane.showMessageDialog(janela, "Cadastro concluido!");
                JanelaLogin janelaDeLogin = new JanelaLogin(sistema);
            }
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    //Getters e Setters

    public JanelaCadastroUsuario getJanela() {
        return janela;
    }

    public void setJanela(JanelaCadastroUsuario janela) {
        this.janela = janela;
    }
    
    public JRadioButton getCheckAlmoxarife() {
        return checkAlmoxarife;
    }

    public void setCheckAlmoxarife(JRadioButton checkAlmoxarife) {
        this.checkAlmoxarife = checkAlmoxarife;
    }

    public JRadioButton getCheckCaixa() {
        return checkCaixa;
    }

    public void setCheckCaixa(JRadioButton checkCaixa) {
        this.checkCaixa = checkCaixa;
    }

    public JCheckBox getCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(JCheckBox checkEmail) {
        this.checkEmail = checkEmail;
    }

    public JCheckBox getCheckNisPis() {
        return checkNisPis;
    }

    public void setCheckNisPis(JCheckBox checkNisPis) {
        this.checkNisPis = checkNisPis;
    }    

}
