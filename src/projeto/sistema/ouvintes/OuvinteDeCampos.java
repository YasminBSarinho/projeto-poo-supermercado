package projeto.sistema.ouvintes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaBaseFormularios;

public class OuvinteDeCampos implements KeyListener {
    private JanelaBaseFormularios janela;
    private SistemaMercado sistema;
    
    public OuvinteDeCampos(SistemaMercado sistema, JanelaBaseFormularios janela){
        this.setJanela(janela);
        this.setSistema(sistema);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(!(Character.isLetter(e.getKeyChar()))){
            e.consume();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    public boolean validarCampo(){

        String texto;
        for(JTextField campo : janela.getCampos()){
            if (campo instanceof JPasswordField){
                JPasswordField campoSenha = (JPasswordField) campo;
                texto = new String(campoSenha.getPassword());

            }else{
                texto = campo.getText();
            }

            if(texto.trim().isEmpty() && campo.isEnabled()){

                JOptionPane.showMessageDialog(janela, "Preencha todos os campos obrigatórios",
                                         "Campo Vazio", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public JanelaBaseFormularios getJanela() {
        return janela;
    }
    public void setJanela(JanelaBaseFormularios janela) {
        this.janela = janela;
    }
    public SistemaMercado getSistema() {
        return sistema;
    }
    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }
}
