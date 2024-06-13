package projeto.sistema.visual.telas.usuarios.funcionarios;
import javax.swing.JButton;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.visual.ouvintes.OuvinteFuncionario;
import projeto.sistema.visual.telas.usuarios.JanelaUsuario;

public class JanelaFuncionario extends JanelaUsuario {
    private JButton listarProdutos;
    private JButton cadastrarProduto;

    public JanelaFuncionario(SistemaMercado sistema){
        super(sistema);
        listarProdutos = adicionarBotao("Listar Produtos", getFonteDoBotao(), getPainelBotoes());
        cadastrarProduto = adicionarBotao("Cadastrar Produto", getFonteDoBotao(), getPainelBotoes());

        OuvinteFuncionario ouvinteFuncionario = new OuvinteFuncionario(this, sistema);
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
