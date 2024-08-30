package sistema.visual.telas.usuarios;

import javax.swing.*;

import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;
import sistema.visual.ouvintes.OuvinteUsuario;

import java.awt.*;


public class JanelaUsuario extends JFrame{
    private Font fonteDoBotao = new Font("arial", Font.BOLD, 15);
    private Font fonteCabecalho = new Font("arial", Font.BOLD, 25);
    private JPanel painelBotoes;
    private JButton cadastrarCliente;
    private JMenuItem trocarUsuario;
    private JMenuItem sair;
    private SistemaMercado sistema;
    private JLabel cabecalho;

    public JanelaUsuario(SistemaMercado sistema, Usuario usuario){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSistema(sistema);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon iconeCadastroCliente = new ImageIcon(getClass().getResource("/cliente.png"));
        painelBotoes = new JPanel();
        cadastrarCliente = adicionarBotao("Cadastrar Cliente", getFonteDoBotao(), painelBotoes, iconeCadastroCliente);
        adicionarMenu();

        OuvinteUsuario ouvinteUsuario = new OuvinteUsuario(this, sistema);
        getCadastrarCliente().addActionListener(ouvinteUsuario);
        getTrocarUsuario().addActionListener(ouvinteUsuario);
        getSair().addActionListener(ouvinteUsuario);

        add(painelBotoes);
    }

    public JLabel adicionarCabecalho (String texto){
        JLabel cabecalho = new JLabel(texto, JLabel.CENTER);
        cabecalho.setOpaque(true);
        cabecalho.setFont(fonteCabecalho);
        cabecalho.setBounds(0, 0, getWidth(), getHeight()/10);
        cabecalho.setBackground(Color.LIGHT_GRAY);
        return cabecalho;
    }
    public JButton adicionarBotao(String texto, Font fonte, JPanel painel, ImageIcon icone){
        JButton botao = new JButton(texto);
        if(icone != null){
            botao.setVerticalTextPosition(SwingConstants.BOTTOM);
            botao.setHorizontalTextPosition(SwingConstants.CENTER);
            botao.setIcon(icone);
        }
        botao.setFocusable(false);
        botao.setFont(fonte);
        painel.add(botao);
        return botao;
    }
    
    public JMenuBar adicionarMenu(){
        JMenuBar barraDoMenu = new JMenuBar();
        JMenu opcoes = new JMenu("Opcões");
        trocarUsuario = new JMenuItem("Trocar Usuario");
        sair = new JMenuItem("Sair");
        opcoes.add(trocarUsuario);
        opcoes.add(sair);
        barraDoMenu.add(opcoes);

        setJMenuBar(barraDoMenu);
        return barraDoMenu;
    } 

    public int calcularX(int larguraPainel){
        int x = (getWidth() - larguraPainel)/2;
        return x;
    }

    public int calcularY(JLabel cabecalho){
        int y = cabecalho.getHeight() + 50;
        return y;
    }

    public int calcularAltura(int ladoDoBotao, int gapV, int QTDlinhas){
        int altura = (QTDlinhas * ladoDoBotao) + (QTDlinhas - 1) * gapV;
        return altura;
    }
    public int calcularLargura(int ladoDoBotao, int gapH, int QTDcolunas){
        int largura = (QTDcolunas * ladoDoBotao) + (QTDcolunas - 1) * gapH;
        return largura;
    }

    public JButton getCadastrarCliente() {
        return cadastrarCliente;
    }
    
    public void setCadastrarCliente(JButton cadastrarCliente) {
        this.cadastrarCliente = cadastrarCliente;
    }
    
    public Font getFonteDoBotao() {
        return fonteDoBotao;
    }
    
    public void setFonteDoBotao(Font fonteDoBotao) {
        this.fonteDoBotao = fonteDoBotao;}
    

    public Font getFonteCabecalho() {
        return fonteCabecalho;
    }

    public void setFonteCabecalho(Font fonteCabecalho) {
        this.fonteCabecalho = fonteCabecalho;
    }

    public JPanel getPainelBotoes() {
        return painelBotoes;
    }

    public void setPainelBotoes(JPanel painelBotoes) {
        this.painelBotoes = painelBotoes;
    }

    public SistemaMercado getSistema() {
        return sistema;
    }

    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }

    public JMenuItem getTrocarUsuario() {
        return trocarUsuario;
    }
    
    public void setTrocarUsuario(JMenuItem trocarUsuario) {
        this.trocarUsuario = trocarUsuario;
    }
    
    public JMenuItem getSair() {
        return sair;
    }
    
    public void setSair(JMenuItem sair) {
        this.sair = sair;
    }

    public JLabel getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(JLabel cabecalho) {
        this.cabecalho = cabecalho;
    }
}
