package sistema.visual.telas.usuarios;

import javax.swing.*;

import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;
import sistema.visual.ouvintes.OuvinteUsuario;
import sistema.visual.telas.JanelaDeVendas;

import java.awt.*;
import java.awt.event.ActionEvent;

public class JanelaCaixa extends JanelaUsuario{
    private JanelaCaixa janela;
    private SistemaMercado sistema;
    private JButton realizarVenda;
    
    public JanelaCaixa(SistemaMercado sistema, Usuario usuario){
        super(sistema, usuario);
        setSize(550, 350);
        setLocationRelativeTo(null);

        setCabecalho(adicionarCabecalho("Bem-vindo(a), " + usuario.getNome()));
        add(getCabecalho());

        int larguraPainel = calcularLargura(200,20, 2);
        int alturaPainel = calcularAltura(150, 20, 1);
        int x = calcularX(larguraPainel);
        int y = calcularY(getCabecalho());

        ImageIcon iconeVendas = new ImageIcon(getClass().getResource("/vendas.png"));
        realizarVenda = adicionarBotao("Realizar venda", getFonteDoBotao(), getPainelBotoes(), iconeVendas);

        getPainelBotoes().setLayout(new GridLayout(1,3, 20, 20));
        getPainelBotoes().setBounds(x, y, larguraPainel, alturaPainel);
        OuvinteCaixa ouvinteCaixa = new OuvinteCaixa(this,sistema);
        getRealizarVenda().addActionListener(ouvinteCaixa);
        setVisible(true);
    }

    public class OuvinteCaixa extends OuvinteUsuario {
        private JanelaCaixa janela;

        public OuvinteCaixa(JanelaCaixa janela, SistemaMercado sistema) {
            super(janela, sistema);
            setJanela(janela);
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(realizarVenda)){
                JanelaDeVendas janelaDeVendas = new JanelaDeVendas(getSistema());
            }
        }

        public JanelaCaixa getJanela() {
            return janela;
        }

        public void setJanela(JanelaCaixa janela) {
            this.janela = janela;
        }

    }

    public JButton getRealizarVenda() {
        return realizarVenda;
    }
            
    public void setRealizarVenda(JButton realizarVenda) {
        this.realizarVenda = realizarVenda;
    }

    public JanelaCaixa getJanela() {
        return janela;
    }
    public void setJanela(JanelaCaixa janela) {
        this.janela = janela;
    }
            
    public SistemaMercado getSistema() {
        return sistema;
    }
        
    public void setSistema(SistemaMercado sistema) {
        this.sistema = sistema;
    }
}
            