package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import projeto.sistema.SistemaMercado;
import java.awt.*;

public class JanelaBaseFormularios extends JFrame{
    SistemaMercado sistema;
    private JButton BotaoConfirmatorio;
    private JButton botaoCancelatorio;
    private JTextField[] campos;
    private Font fonteDoCabecalho = new Font("arial", Font.BOLD, 30);
    private Font fonteDoCampo = new Font("arial", Font.PLAIN, 20);
    private Font fonteDoBotao = new Font("arial", Font.BOLD, 20);

    public JanelaBaseFormularios(SistemaMercado sistema){
        setSistema(sistema);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void adicionarCabecalho(String texto){
            int largura = getWidth();
            JLabel cabecalho = new JLabel(texto, JLabel.CENTER);
            cabecalho.setFont(getFonteDoCabecalho());
            cabecalho.setBounds(0, 0, largura, largura/10);
            cabecalho.setBackground(Color.LIGHT_GRAY);
            cabecalho.setOpaque(true);
            add(cabecalho);
    }

    public void adicionarFontes(JComponent[]  componentes){
        for(JComponent componente : componentes){
            if(componente instanceof JTextField || componente instanceof JLabel || componente instanceof JPasswordField){
                componente.setFont(getFonteDoCampo());
            }
            else if(componente instanceof JButton){
                componente.setFont(getFonteDoBotao());
            }
        }
    }
    public void adicionarAoPainel(JComponent[] componentes, JPanel painel){
        for(JComponent componente : componentes){
            painel.add(componente);
        }
    }

    public JTextComponent adicionarCampo(Font fonte, int[] bounds, Boolean secreto){
        JTextComponent campo;

        if(secreto){
            campo = new JPasswordField();
        }else{
            campo = new JTextField();
        }

        campo.setFont(getFonteDoCampo());
        campo.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        add(campo);

        if(campo instanceof JPasswordField){
            return (JPasswordField) campo;
        }else{
            return (JTextField) campo;
        }
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public Font getFonteDoCampo() {
        return fonteDoCampo;
    }

    public Font getFonteDoBotao() {
        return fonteDoBotao;
    }
    

    public void setFonteDoCabecalho(Font fonteDoCabecalho) {
        this.fonteDoCabecalho = fonteDoCabecalho;
    }

    public void setFonteDoCampo(Font fonteDoCampo) {
        this.fonteDoCampo = fonteDoCampo;
    }

    public void setFonteDoBotao(Font fonteDoBotao) {
        this.fonteDoBotao = fonteDoBotao;
    }

    public Font getFonteDoCabecalho() {
        return fonteDoCabecalho;
    }

    public JButton getBotaoConfirmatorio() {
        return BotaoConfirmatorio;
    }

    public void setBotaoConfirmatorio(JButton botaoConfirmatorio) {
        BotaoConfirmatorio = botaoConfirmatorio;
    }

    public JButton getBotaoCancelatorio() {
        return botaoCancelatorio;
    }

    public void setBotaoCancelatorio(JButton botaoCancelatorio) {
        this.botaoCancelatorio = botaoCancelatorio;
    }

    public JTextField[] getCampos() {
        return campos;
    }

    public void setCampos(JTextField[] campos) {
        this.campos = campos;
    }
}