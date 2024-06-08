package projeto.sistema.visual.ouvintes;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;

import projeto.sistema.SistemaMercado;
import projeto.sistema.utilitarios.Cupom;
import projeto.sistema.utilitarios.Json;
import projeto.sistema.visual.telas.JanelaCupom;

public class OuvinteCupom extends OuvinteDeCampos{
    
    private JanelaCupom janela;
    private SistemaMercado sistema;
    
    public OuvinteCupom(JanelaCupom janela, SistemaMercado sistema){
        super(janela, sistema);
        setJanela(janela);
        setSistema(sistema);  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }

    @Override
    protected void confirmar(){
        String codigo = janela.getCampoCodigo().getText();
        String descontoTexto = janela.getCampoDesconto().getText();
        float desconto = Float.parseFloat(descontoTexto)/100;
        Cupom cupom = new Cupom(codigo, desconto);

        if(sistema.validarCupom(codigo) == null){
            sistema.getCupons().add(cupom);
            Json json = new Json();
            janela.dispose();
            JOptionPane.showMessageDialog(janela, "Cupom cadastrado!");
            json.escreverJson(sistema);
        }else{
            JOptionPane.showMessageDialog(janela, "O Cupom já está cadastrado!");
        }

    }    

    @Override
    public void keyTyped(KeyEvent e) {

        JTextField campo = (JTextField) e.getSource();
        JTextField campoCodigo = janela.getCampoCodigo();
        String codigo = janela.getCampoCodigo().getText();
        String desconto = janela.getCampoDesconto().getText();
        char letra = e.getKeyChar();
        
        if(campo.equals(campoCodigo)) {
            if(codigo.length() > 4 || !Character.isLetterOrDigit(letra)){
                e.consume();
            }
        } else {
            if(desconto.length() > 1 || !Character.isDigit(letra)){
                e.consume();
            }
        }
    }
    
    public JanelaCupom getJanela() {
        return janela;
    }
    
    public void setJanela(JanelaCupom janela) {
        this.janela = janela;
    }
    
    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }
}