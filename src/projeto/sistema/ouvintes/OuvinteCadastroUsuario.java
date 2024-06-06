package projeto.sistema.ouvintes;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.CaixaEletronico;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;
import projeto.sistema.telas.JanelaCadastroUsuario;
import projeto.sistema.telas.JanelaLogin;
import projeto.sistema.utilitarios.Json;

public class OuvinteCadastroUsuario extends OuvinteDeCampos{
    private JanelaCadastroUsuario janela;
    private SistemaMercado sistema;
    private JCheckBox checkAlmoxarife;
    private JCheckBox checkCaixa;
    private JCheckBox checkEmail;
    private JCheckBox checkNisPis;

    public OuvinteCadastroUsuario(JanelaCadastroUsuario janela, SistemaMercado sistema){
        super(janela, sistema);
        setJanela(janela);
        setSistema(sistema);
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
                checkCaixa.setEnabled(false);
                return "Almoxarife";
            }
            else if(checkCaixa.isSelected()){
                checkAlmoxarife.setEnabled(false);
                return "Caixa Eletronico";

            }else{
                checkAlmoxarife.setEnabled(true);
                checkCaixa.setEnabled(true);
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
            JOptionPane.showMessageDialog(janela, "Senhas não coincidem", 
            "Erro", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(janela, "Cadastro concluido!");
            json.escreverJson(sistema);
            JanelaLogin janelaDeLogin = new JanelaLogin(sistema);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    
    //Getters e Setters



    public JanelaCadastroUsuario getJanela() {
        return janela;
    }

    public void setJanela(JanelaCadastroUsuario janela) {
        this.janela = janela;
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public JCheckBox getCheckAlmoxarife() {
        return checkAlmoxarife;
    }

    public void setCheckAlmoxarife(JCheckBox checkAlmoxarife) {
        this.checkAlmoxarife = checkAlmoxarife;
    }

    public JCheckBox getCheckCaixa() {
        return checkCaixa;
    }

    public void setCheckCaixa(JCheckBox checkCaixa) {
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
