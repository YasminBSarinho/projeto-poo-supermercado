package sistema.visual.telas.usuarios.funcionarios;


import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;
import sistema.visual.ouvintes.OuvinteFuncionario;
import sistema.visual.ouvintes.OuvinteUsuario;
import sistema.visual.telas.JanelaCadastroUsuario;
import sistema.visual.telas.JanelaDeVendas;
import sistema.visual.telas.usuarios.JanelaCaixa;

public class JanelaGerente extends JanelaFuncionario {

    private JButton cadastrarUsuario;
    private JButton enviarCupons;
    private JButton gerarBalancoMensal;

    public JanelaGerente(SistemaMercado sistema, Usuario usuario){
        super(sistema, usuario);
        setSize(720, 600);
        setLocationRelativeTo(null);

        setCabecalho(adicionarCabecalho("Bem-vindo(a), " + usuario.getNome() + "."));

        int larguraPainel = calcularLargura(200, 20, 3);
        int alturaPainel = calcularAltura(150, 20, 2);
        int x = calcularX(larguraPainel);
        int y = calcularY(getCabecalho());

        ImageIcon iconeCadastroUsuario = new ImageIcon(getClass().getResource("/imagens/cadastrarUsuario.png"));
        ImageIcon iconeDeCupom = new ImageIcon(getClass().getResource("/imagens/cupom.png"));
        ImageIcon iconeDoBalanco = new ImageIcon(getClass().getResource("/imagens/balanco.png"));

        cadastrarUsuario = adicionarBotao("Cadastrar Usuário", getFonteDoBotao(), getPainelBotoes(), iconeCadastroUsuario);
        enviarCupons = adicionarBotao("Enviar Cupons", getFonteDoBotao(), getPainelBotoes(), iconeDeCupom);
        gerarBalancoMensal = adicionarBotao("Balanço Mensal", getFonteDoBotao(), getPainelBotoes(), iconeDoBalanco);

        OuvinteGerente ouvinteGerente = new OuvinteGerente(this, sistema, usuario);
        cadastrarUsuario.addActionListener(ouvinteGerente);
        enviarCupons.addActionListener(ouvinteGerente);
        gerarBalancoMensal.addActionListener(ouvinteGerente);

        getPainelBotoes().setLayout(new GridLayout(2,3, 20, 20));
        getPainelBotoes().setBounds(x, y, larguraPainel, alturaPainel);
        add(getCabecalho());
    }
    public class OuvinteGerente extends OuvinteFuncionario {

        public OuvinteGerente(JanelaFuncionario janela, SistemaMercado sistema, Usuario usuario) {
            super(janela, sistema, usuario);
        }

        @Override
        public void actionPerformed(ActionEvent e){
            JButton botao = (JButton) e.getSource();

            if(botao.equals(cadastrarUsuario)){
                JanelaCadastroUsuario janelaDeVendas = new JanelaCadastroUsuario(getSistema());
            }else if (botao.equals(enviarCupons)){
                //Envio de cupons por email
            }else{
                //gerar pdf do balanco mensal.
            }
        }
    }

    public JButton getCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(JButton cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    public JButton getGerarBalancoMensal() {
        return gerarBalancoMensal;
    }

    public void setGerarBalancoMensal(JButton gerarBalancoMensal) {
        this.gerarBalancoMensal = gerarBalancoMensal;
    }

    public JButton getEnviarCupons() {
        return enviarCupons;
    }

    public void setEnviarCupons(JButton enviarCupons) {
        this.enviarCupons = enviarCupons;
    }
}
