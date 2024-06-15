
package sistema.visual.telas;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sistema.SistemaMercado;
import java.awt.*;

public class JanelaDeCampos extends JFrame{
    private SistemaMercado sistema;
    private JButton botaoConfirmatorio;
    private JButton botaoCancelatorio;
    private JTextField[] campos;
    private Font fonteDoCabecalho = new Font("arial", Font.BOLD, 30);
    private Font fonteDoCampo = new Font("arial", Font.PLAIN, 20);
    private Font fonteDoBotao = new Font("arial", Font.BOLD, 20);

    public JanelaDeCampos(SistemaMercado sistema){
        setSistema(sistema);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        return botaoConfirmatorio;
    }

    public void setBotaoConfirmatorio(JButton botaoConfirmatorio) {
        this.botaoConfirmatorio = botaoConfirmatorio;
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