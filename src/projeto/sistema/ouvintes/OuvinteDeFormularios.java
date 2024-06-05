package projeto.sistema.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaBaseFormularios;

public abstract class  OuvinteDeFormularios implements ActionListener, KeyListener {
    SistemaMercado sistema;
    JanelaBaseFormularios janela;

    public OuvinteDeFormularios(JanelaBaseFormularios janela, SistemaMercado sistema){
        setJanela(janela);
        setSistema(sistema);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JTextComponent campo : janela.getCampos()){
            campo.addKeyListener(this);

        }
        Object source = e.getSource();
        if(source.equals(janela.getBotaoConfirmatorio())){
            boolean cadastroValido = this.validarCampo();
            if(cadastroValido){
                confirmar();
            }
        }else if(source.equals(janela.getBotaoCancelatorio())){
            janela.dispose();
        }
    }

    protected abstract void confirmar();

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
    public JanelaBaseFormularios getJanela() {
        return janela;
    }
    public void setJanela(JanelaBaseFormularios janela) {
        this.janela = janela;
    }

}
