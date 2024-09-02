package sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sistema.SistemaMercado;
import sistema.utilitarios.CampoPersonalizado;
import sistema.utilitarios.Json;
import sistema.utilitarios.Tipos;
import sistema.visual.telas.JanelaDeCampos;

public abstract class  OuvinteDeCampos implements ActionListener, KeyListener {
    SistemaMercado sistema;
    JanelaDeCampos janela;

    public OuvinteDeCampos(JanelaDeCampos janela, SistemaMercado sistema){
        setJanela(janela);
        setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Json json = new Json();
        if(source.equals(janela.getBotaoConfirmatorio())){
            boolean cadastroValido = this.validarCampo();
            if(cadastroValido){
                confirmar();
            }
        }else if(source.equals(janela.getBotaoCancelatorio())){
            janela.dispose();
        }
        json.escreverJson(sistema);
    }

    protected abstract void confirmar(); 

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() instanceof CampoPersonalizado){
            CampoPersonalizado campo = (CampoPersonalizado) e.getSource();
            Character caracter = e.getKeyChar();
            int tamanho = campo.getText().length();

            if(campo.getTipo().equals(Tipos.TEXTUAL) && !(Character.isLetter(caracter))){
                e.consume();
            }else if(campo.getTipo().equals(Tipos.NUMERICO) && !(Character.isDigit(caracter))){
                e.consume();
            }else if(tamanho >= campo.getTamanho() && campo.getTamanho() != -1){
                e.consume();
            }
        }
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

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public JanelaDeCampos getJanela() {
        return janela;
    }
    
    public void setJanela(JanelaDeCampos janela) {
        this.janela = janela;
    }

}
