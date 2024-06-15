package sistema.visual.telas.usuarios.funcionarios;
import javax.swing.*;

import sistema.SistemaMercado;
import sistema.pessoas.usuarios.Usuario;
import sistema.visual.ouvintes.OuvinteFuncionario;
import sistema.visual.telas.usuarios.JanelaUsuario;

public class JanelaFuncionario extends JanelaUsuario {
    private JButton listarProdutos;
    private JButton cadastrarProduto;

    public JanelaFuncionario(SistemaMercado sistema, Usuario usuario){
        super(sistema, usuario);
        add(adicionarCabecalho("Bem-vindo(a), " + usuario.getNome()));
        ImageIcon iconeLista = new ImageIcon(getClass().getResource("/imagens/listarProdutos.png"));
        ImageIcon iconeCadastroProduto = new ImageIcon(getClass().getResource("/imagens/CadastrarProduto.png"));

        listarProdutos = adicionarBotao("Listar Produtos", getFonteDoBotao(), getPainelBotoes(), iconeLista);
        cadastrarProduto = adicionarBotao("Cadastrar Produto", getFonteDoBotao(), getPainelBotoes(), iconeCadastroProduto);

        OuvinteFuncionario ouvinteFuncionario = new OuvinteFuncionario(this, sistema, usuario);
        listarProdutos.addActionListener(ouvinteFuncionario);
        cadastrarProduto.addActionListener(ouvinteFuncionario);
        setVisible(true);
    }
    
    public JButton getListarProdutos(){
        return listarProdutos;
    }

    public void setListarProdutos(JButton listarProdutos) {
        this.listarProdutos = listarProdutos;
    }
    
    public JButton getCadastrarProduto(){
        return cadastrarProduto;
    }

    public void setCadastrarProduto(JButton cadastrarProduto) {
        this.cadastrarProduto = cadastrarProduto;
    }
}
