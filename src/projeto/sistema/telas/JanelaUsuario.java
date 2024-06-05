package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;

public class JanelaUsuario extends JFrame{
    
    private Font fonteDoBotao = new Font("arial", Font.BOLD, 20);
    private Font fonteCabecalho = new Font("arial", Font.BOLD, 25);
    private JPanel painelBotoes;
    private JButton cadastrarCliente;
    

    public JanelaUsuario(SistemaMercado sistema, Usuario usuario){
        
        setSize(600, 600);
        setLayout(null);
        setResizable(false);
        
        JLabel cabecalho = new JLabel("Bem-vindo(a), " + usuario.getNome() , JLabel.CENTER);
        cabecalho.setOpaque(true);
        cabecalho.setForeground(Color.WHITE);
        cabecalho.setFont(fonteCabecalho);
        cabecalho.setBounds(0, 0, getWidth(), 60);
        cabecalho.setBackground(Color.GRAY);
        
        painelBotoes = new JPanel(new GridLayout(3, 1, 20, 20));
        painelBotoes.setBounds(calcularX(200), 120, 200, calcularAltura(90));
        
        cadastrarCliente = adicionarBotao("Cadastrar Cliente", getFonteDoBotao(), painelBotoes);
        
        adicionarMenu();
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
        JMenuItem sair = new JMenuItem("Sair");
        JMenuItem trocarUsuario = new JMenuItem("Trocar Usuario");
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
        this.fonteDoBotao = fonteDoBotao;
    }
    
}
