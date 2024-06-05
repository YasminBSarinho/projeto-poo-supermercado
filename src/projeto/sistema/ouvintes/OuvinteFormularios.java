package projeto.sistema.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.JTextComponent;

import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaBaseFormularios;

public abstract class  OuvinteFormularios implements ActionListener {
    SistemaMercado sistema;
    JanelaBaseFormularios janela;

    public OuvinteFormularios(SistemaMercado sistema, JanelaBaseFormularios janela){
        setSistema(sistema);
        setJanela(janela);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OuvinteCampos ouvinteCampos = new OuvinteCampos(sistema, janela);
        for(JTextComponent campo : janela.getCampos()){
            campo.addKeyListener(ouvinteCampos);

        }
        Object source = e.getSource();
        if(source.equals(janela.getBotaoConfirmatorio())){
            boolean cadastroValido = ouvinteCampos.validarCampo();
            if(cadastroValido){
                acaoAoConfirmar();
            }
        }else if(source.equals(janela.getBotaoCancelatorio())){
            janela.dispose();
        }
    }

    protected abstract void acaoAoConfirmar();


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
