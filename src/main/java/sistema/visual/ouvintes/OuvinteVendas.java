package sistema.visual.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sistema.SistemaMercado;
import sistema.pessoas.Cliente;
import sistema.produtos.Produto;
import sistema.utilitarios.Cupom;
import sistema.utilitarios.Pdf;
import sistema.utilitarios.Registro;
import sistema.visual.telas.JanelaCadastroCliente;
import sistema.visual.telas.JanelaDeVendas;

public class OuvinteVendas extends OuvinteDeCampos{
    private JanelaDeVendas janela;
    
    
    public OuvinteVendas(JanelaDeVendas janela, SistemaMercado sistema) {
        super(janela, sistema);
        setJanela(janela);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton vender = janela.getBotaoVender();
        Pdf pdf = new Pdf();

        if(e.getSource().equals(vender)){
            JTextField campoCupom  = janela.getCampoCupom();
            String CodigoCupom = campoCupom.getText();
            Cupom cupom = sistema.validarCupom(CodigoCupom);
            BigDecimal total = janela.getTotalDeVendas();
            BigDecimal totalComDesconto = null;
            BigDecimal desconto = cupom.getDesconto();

            //Finalização da venda (mostra o total)
            JOptionPane.showMessageDialog(janela, "total: " + total);
            validarCPF();
            janela.dispose();



            if(!CodigoCupom.equals("_____") && cupom != null){
                BigDecimal valorDescontado = total.multiply(desconto);
                totalComDesconto = total.subtract(valorDescontado);
                janela.setTotalDeVendas(totalComDesconto);
                JOptionPane.showMessageDialog(janela, "Total: " + total + "\nCom desconto: " + totalComDesconto);
            }


            for(Produto produto : janela.getCarrinho()){
                BigDecimal unidades = BigDecimal.valueOf(produto.getUnidade());
                BigDecimal totalProduto =  unidades.multiply(produto.getValorUnitarioDeVenda());
                // Caso tenha havido desconto
                if (totalComDesconto != null){
                    totalProduto = totalProduto.subtract( totalProduto.multiply(desconto));
                    total = totalComDesconto;
                }

                //Registra a venda de um dos produtos
                Registro registro = new Registro(produto.getCodigo(),  produto.getNome(), produto.getUnidade(), 
                                                produto.getValorUnitarioDeVenda(), "", totalProduto);
                sistema.getRegistrosDeVenda().add(registro);
            }
            String CPF = janela.getCampoCPF().getText();
            Cliente cliente = sistema.buscarCliente(CPF);
            pdf.emitirNotaFiscal(getSistema(), cliente, CPF, janela.getCarrinho(), total);

        } 
        //Adicionando ao carrinho;
        super.actionPerformed(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource().equals(janela.getCampoQTD()) && !Character.isDigit(e.getKeyChar())){
            e.consume();
        }
    }
    
    @Override
    protected void confirmar() {
        JTextField campoDoCodigo = janela.getCampoCodigo();
        String codigo = campoDoCodigo.getText();
        Produto produto = sistema.buscarProdutoPorCodigo(codigo);

        int quantidade = Integer.parseInt(janela.getCampoQTD().getText());

        if(produto == null){
            JOptionPane.showMessageDialog(janela, "Produto não encontrado", "Aviso", JOptionPane.ERROR_MESSAGE); 

        }else if(quantidade > produto.getUnidade()){
            JOptionPane.showMessageDialog(janela, "Existem apenas" + produto.getUnidade() + "em estoque", "Aviso", JOptionPane.ERROR_MESSAGE);

        }else{
            BigDecimal quantia = BigDecimal.valueOf(quantidade);
            AdicionarAoCarrinho(produto, quantia);
        }
        janela.getCampoCodigo().setText("");
        janela.getCampoQTD().setText("");
        janela.getCampoCPF().setEnabled(false);
        janela.repaint();
    }
    public void AdicionarAoCarrinho(Produto produto, BigDecimal quantia){
        produto.setUnidade(produto.getUnidade() - quantia.intValue());
        BigDecimal valorUnitario = produto.getValorUnitarioDeVenda();
        BigDecimal total = janela.getTotalDeVendas();

        total = total.add(valorUnitario.multiply(quantia));
        janela.setTotalDeVendas(total);
        Produto produtoComprado = new Produto();

        produtoComprado.setCodigo(produto.getCodigo());
        produtoComprado.setNome(produto.getNome());
        produtoComprado.setUnidade(quantia.intValue());
        produtoComprado.setValorUnitarioDeVenda(valorUnitario);
        produtoComprado.setValorUnitarioDeCompra(produto.getValorUnitarioDeCompra());

        janela.getCarrinho().add(produtoComprado);
        janela.getBotaoVender().setEnabled(true);
        JOptionPane.showMessageDialog(janela, "O produto foi adicionado ao carrinho!");
    }
    public void validarCPF(){
        JTextField campoDoCPF = janela.getCampoCPF();
        String CPF = campoDoCPF.getText();

        Cliente cliente = sistema.buscarCliente(CPF);

        if(cliente == null){
            int resposta = JOptionPane.showConfirmDialog(janela, "Deseja cadastrar o cliente?", "Cliente não possui cadastro", JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION){
                JanelaCadastroCliente janelaCadastroCliente = new JanelaCadastroCliente(sistema);
            }
        }
    }

    public JanelaDeVendas getJanela() {
        return janela;
    }

    public void setJanela(JanelaDeVendas janela) {
        this.janela = janela;
    }
    
    
}
