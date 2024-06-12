package projeto.sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.Cliente;
import projeto.sistema.produtos.Produto;
import projeto.sistema.utilitarios.Cupom;
import projeto.sistema.visual.telas.JanelaCadastroCliente;
import projeto.sistema.visual.telas.JanelaDeVendas;

public class OuvinteVendas extends OuvinteDeCampos{
    private JanelaDeVendas janela;
    public OuvinteVendas(JanelaDeVendas janela, SistemaMercado sistema) {
        super(janela, sistema);
        setJanela(janela);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        JButton vender = janela.getBotaoVender();
        if(e.getSource().equals(vender)){
            String cupom = JOptionPane.showInputDialog(janela, "O total de compras foi: R$ " + janela.getTotalDeVendas() + "\nAdicione um cupom: ");
            Cupom cupomValidado = sistema.validarCupom(cupom);
            
            if(cupom != null && cupomValidado != null){
                float porcentagem =  cupomValidado.getDesconto();
                float total = janela.getTotalDeVendas();
                janela.setTotalDeVendas(total - (total * porcentagem));
                JOptionPane.showMessageDialog(janela, "O total de compras com desconto foi: R$ " + janela.getTotalDeVendas() + "\nObrigado pela compra!");
                janela.dispose();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField campoDoCPF = janela.getCampoCPF();
        JTextField campoDoProduto = janela.getCampoProduto();
        String CPF = campoDoCPF.getText();
        String produto = campoDoProduto.getText();
        JTextField campo = (JTextField) e.getSource();

        char letra = e.getKeyChar();
        if(campo.equals(campoDoCPF) && (!Character.isDigit(letra) || CPF.length() > 10)){
            e.consume();
        }
        else if(CPF.length() == 11){
            Cliente cliente = sistema.buscarCliente(CPF);
            if(cliente == null){
                int resposta = JOptionPane.showConfirmDialog(janela, "Deseja cadastrar o cliente?", "Cliente não possui cadastro", JOptionPane.YES_NO_OPTION);
                if(resposta == JOptionPane.YES_OPTION){
                    JanelaCadastroCliente janelaCadastroCliente = new JanelaCadastroCliente(sistema);
                }
            } 
        }
        else if(campo.equals(campoDoProduto) && (!Character.isDigit(letra) || produto.length() > 4)){
            e.consume();
        }
        else{
            if(!Character.isDigit(letra)){
                e.consume();
            }    
        } 
    }


    @Override
    protected void confirmar() {
        JTextField campoDoProduto = janela.getCampoProduto();
        String codigo = campoDoProduto.getText();
        Produto produto = sistema.buscarProdutoPorCodigo(codigo);
        int quantidade = Integer.parseInt(janela.getCampoQTD().getText());

        if(produto == null){
            JOptionPane.showMessageDialog(janela, "Produto não encontrado", "Aviso", JOptionPane.ERROR_MESSAGE); 

        }else if(quantidade > produto.getUnidade()){
            JOptionPane.showMessageDialog(janela, "Existem apenas" + produto.getUnidade() + "em estoque", "Aviso", JOptionPane.ERROR_MESSAGE);

        }else{
            produto.setUnidade(produto.getUnidade() - quantidade);

            float valorUnitario = produto.getValorUnitarioDeVenda();
            float total = janela.getTotalDeVendas();
            janela.setTotalDeVendas(total + (quantidade * valorUnitario));

            JOptionPane.showMessageDialog(janela, "O produto foi adicionado ao carrinho!");
            
            janela.getCampoProduto().setText("");
            janela.getCampoQTD().setText("");
            janela.getCampoProduto().repaint();
            janela.getCampoQTD().repaint();
            janela.getCampoCPF().setEnabled(false);
        }

    }

    public JanelaDeVendas getJanela() {
        return janela;
    }

    public void setJanela(JanelaDeVendas janela) {
        this.janela = janela;
    }
    
    
}
