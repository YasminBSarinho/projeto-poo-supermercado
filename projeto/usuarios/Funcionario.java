package projeto.usuarios;

import java.util.ArrayList;

import projeto.produtos.Produto;

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

        System.out.println();
        System.out.println("Digite menu para voltar ao menu ou " + 
                            "Digite o codigo do produto para exibir os detalhes: ");
    }

    public void cadastrarProduto(){
        // LUCAS
    }

    public void exibirDetalhesDeUmProduto(){
         
    }

    public void editarProduto(){

    }

}
