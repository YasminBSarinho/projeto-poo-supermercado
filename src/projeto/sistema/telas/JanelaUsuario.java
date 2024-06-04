package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projeto.sistema.SistemaMercado;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;

public class JanelaUsuario extends JFrame{
    Font fonteDoBotao = new Font("arial", Font.BOLD, 20);
    Font fonteCabecalho = new Font("arial", Font.BOLD, 25);
    JButton cadastrarCliente;
    JButton trocarUsuario;
    JButton sair;
    
    public JanelaUsuario(SistemaMercado sistema){
        setSize(600, 600);
        setLayout(null);
        setResizable(false);
        JLabel teste = new JLabel("Bem-vindo fulano!", JLabel.CENTER);
        teste.setForeground(Color.WHITE);
        teste.setFont(fonteCabecalho);
        teste.setBounds(0, 0, getWidth(), 60);
        teste.setBackground(Color.GRAY);
        teste.setOpaque(true);
        JPanel painelBotoes = new JPanel(new GridLayout(3, 1, 20, 20));
        painelBotoes.setBackground(Color.GRAY);
        painelBotoes.setOpaque(true);
        painelBotoes.setBounds(150, 120, 300, 300);
        
        cadastrarCliente = adicionarBotao("Cadastrar Cliente", getFonteDoBotao(), painelBotoes);
        trocarUsuario = adicionarBotao("Trocar de usuario", getFonteDoBotao(), painelBotoes);  
        sair = adicionarBotao("Sair", getFonteDoBotao(), painelBotoes);
            
        add(painelBotoes);
        add(teste);
        setVisible(true);
    }   

    public JButton adicionarBotao(String texto, Font fonte, JPanel painel){
        JButton botao = new JButton(texto);
        botao.setFont(fonte);
        painel.add(botao);
        return botao;
    }
    
    public JButton getCadastrarCliente() {
        return cadastrarCliente;
    }
    
    public void setCadastrarCliente(JButton cadastrarCliente) {
        this.cadastrarCliente = cadastrarCliente;
    }
    
    public JButton getTrocarUsuario() {
        return trocarUsuario;
    }
    
    public void setTrocarUsuario(JButton trocarUsuario) {
        this.trocarUsuario = trocarUsuario;
    }
    
    public JButton getSair() {
        return sair;
    }
    
    public void setSair(JButton sair) {
        this.sair = sair;
    }

    public Font getFonteDoBotao() {
        return fonteDoBotao;
    }

    public void setFonteDoBotao(Font fonteDoBotao) {
        this.fonteDoBotao = fonteDoBotao;
    }
}
