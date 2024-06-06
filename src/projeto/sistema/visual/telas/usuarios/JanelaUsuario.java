package projeto.sistema.visual.telas.usuarios;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.ouvintes.OuvinteUsuario;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;


public class JanelaUsuario extends JFrame{
    private Font fonteDoBotao = new Font("arial", Font.BOLD, 20);
    private Font fonteCabecalho = new Font("arial", Font.BOLD, 25);
    private JPanel painelBotoes;
    private JButton cadastrarCliente;
    private JMenuItem trocarUsuario;
    private JMenuItem sair;
    private SistemaMercado sistema;
    
    public JanelaUsuario(SistemaMercado sistema){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);
        setResizable(false);
        
        JLabel cabecalho = new JLabel("Bem-vindo(a), " , JLabel.CENTER);
        cabecalho.setOpaque(true);
        cabecalho.setForeground(Color.WHITE);
        cabecalho.setFont(fonteCabecalho);
        cabecalho.setBounds(0, 0, getWidth(), 60);
        cabecalho.setBackground(Color.GRAY);
        
        painelBotoes = new JPanel(new GridLayout(3, 1, 20, 20));
        painelBotoes.setBounds(calcularX(200), 120, 200, calcularAltura(90));
        adicionarMenu();
        
        cadastrarCliente = adicionarBotao("Cadastrar Cliente", getFonteDoBotao(), painelBotoes);
        OuvinteUsuario ouvinteUsuario = new OuvinteUsuario(this, sistema);
        
        getCadastrarCliente().addActionListener(ouvinteUsuario);
        getTrocarUsuario().addActionListener(ouvinteUsuario);
        getSair().addActionListener(ouvinteUsuario);
        add(painelBotoes);
        add(cabecalho);
        setVisible(true);
    }

    public JButton adicionarBotao(String texto, Font fonte, JPanel painel){
        JButton botao = new JButton(texto);
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
    
    public int calcularAltura(int alturaDoBotao){
        int altura = (3 * (alturaDoBotao));
        return altura;
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
    
}
