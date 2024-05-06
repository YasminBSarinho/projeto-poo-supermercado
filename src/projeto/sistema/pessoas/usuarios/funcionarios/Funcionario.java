package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.ArrayList;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.produtos.Produto;

public class Funcionario extends Usuario{

    public Funcionario(String nome, String cargo, String login, String senha){
        super(nome, cargo, login, senha);
    }

    public Funcionario(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros

    public void listarProdutos(){
        ArrayList<Produto> listaDeProdutos = SistemaMercado.getProdutosEmEstoque();
        System.out.println("--- Listar Produto ---");
        System.out.println();
        System.out.println("Código | Nome do Produto | Valor | Quantidade");
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto.getCodigo() + " | " + produto.getNome() + " | " + produto.getValorUnitarioDeVenda() + " | " + produto.getUnidade());
        }

        System.out.println("[1] - Exibir detalhes de produto");
        System.out.println("[2] - Voltar para o menu");

        
    }

    public void cadastrarProduto(){
        // LUCAS
    }

    public void exibirDetalhesDeUmProduto(){

    }

    public void editarProduto(){

    }

}
