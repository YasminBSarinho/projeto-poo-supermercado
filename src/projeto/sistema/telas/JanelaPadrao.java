package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import projeto.sistema.SistemaMercado;
import java.awt.*;

public class JanelaPadrao extends JFrame{
    SistemaMercado sistema;
    private final Font fonteDoCabecalho = new Font("arial", Font.BOLD, 30);
    private final Font fonteDoCampo = new Font("arial", Font.PLAIN, 20);
    private final Font fonteDoBotao = new Font("arial", Font.BOLD, 20);

    public JanelaPadrao(SistemaMercado sistema){
        setSize(560,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void adicionarCabecalho(String texto){
            JLabel cabecalho = new JLabel(texto, JLabel.CENTER);
            cabecalho.setFont(getFonteDoCabecalho());
            cabecalho.setBounds(0, 0, 560, 60);
            cabecalho.setBackground(Color.LIGHT_GRAY);
            cabecalho.setOpaque(true);
            add(cabecalho);
    }

    public JTextComponent adicionarCampo(String texto, Font fonte, int[] bounds, Boolean secreto){
        JLabel textoDoCampo = new JLabel(texto);
        textoDoCampo.setFont(fonte);
        textoDoCampo.setHorizontalAlignment(JLabel.LEFT);
        textoDoCampo.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        JTextComponent campo;

        if(secreto){
            campo = new JPasswordField();
        }else{
            campo = new JTextField();
        }

        int xDoCampo = bounds[0] + bounds[2] + 10;
        int yDoCampo = bounds[1]; 
        int alturaDoCampo = bounds[3];

        campo.setFont(getFonteDoCampo());
        campo.setBounds(xDoCampo, yDoCampo, 280, alturaDoCampo);
        add(textoDoCampo);
        add(campo);

        if(campo instanceof JPasswordField){
            return (JPasswordField) campo;
        }else{
            return (JTextField) campo;
        }
    }

    public JButton adicionarBotao(String texto, int[] bounds){
        JButton botao = new JButton(texto);
        botao.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        botao.setFont(getFonteDoBotao());
        add(botao);
        return botao;
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

    public Font getFonteDoCabecalho() {
        return fonteDoCabecalho;
    }
}