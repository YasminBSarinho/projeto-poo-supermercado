package projeto.sistema.telas;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import projeto.sistema.SistemaMercado;

public class JanelaCupom extends JanelaBaseFormularios{
    private JTextField campoCodigo;
    private JTextField campoDesconto;
    private JButton botaoCriar;
    private JButton botaoCancelar;
    public JanelaCupom(SistemaMercado sistema){
        super(sistema);
        setSize(500, 350);
        adicionarCabecalho("Criar Cupom");

        JPanel painelTextos = new JPanel();
        JPanel painelCampos = new JPanel();
        JPanel painelBotoes = new JPanel();

        painelTextos.setLayout(new GridLayout(2, 1, 0, 20));
        painelCampos.setLayout(new GridLayout(2, 1, 0, 20));
        painelBotoes.setLayout(new GridLayout(1, 2, 20, 0));

        painelTextos.setBounds(100, 80, 150, 100);
        painelCampos.setBounds(250, 80, 150, 100);
        painelBotoes.setBounds(100, 220, 300, 50);

        JLabel textoCodigo = new JLabel("Código:");
        JLabel textoDesconto = new JLabel("Desconto(%):");
        campoCodigo = new JTextField(5);
        campoDesconto = new JTextField(3);

        botaoCriar = new JButton("Criar");
        botaoCancelar = new JButton("Cancelar");

        JComponent[] componentesTexto = {textoCodigo, textoDesconto};
        JComponent[] componentesCampo = {campoCodigo, campoDesconto};
        JComponent[] componentesBotao = {botaoCriar, botaoCancelar};
        
        adicionarFontes(componentesTexto);
        adicionarFontes(componentesCampo);
        adicionarFontes(componentesBotao);
        adicionarAoPainel(componentesTexto, painelTextos);
        adicionarAoPainel(componentesCampo, painelCampos);
        adicionarAoPainel(componentesBotao, painelBotoes);

        add(painelTextos);
        add(painelCampos);
        add(painelBotoes);
        setVisible(true);
    }
}
