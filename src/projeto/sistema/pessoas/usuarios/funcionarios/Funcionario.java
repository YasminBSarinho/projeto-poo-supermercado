package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.ArrayList;
import java.util.Scanner;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.produtos.Produto;

public class Funcionario extends Usuario{

    public Funcionario(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros
    ArrayList<Produto> listaDeProdutos = SistemaMercado.getProdutosEmEstoque();

    public void listarProdutos(){
        System.out.println("--- Listar Produto ---");
        System.out.println();
        System.out.println("Código | Nome do Produto | Valor | Quantidade");
        for (Produto produto : listaDeProdutos) {
            System.out.println(produto.getCodigo() + " | " + produto.getNome() + " | " + produto.getValorUnitarioDeVenda() + " | " + produto.getUnidade());
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1] - Exibir detalhes de produto");
        System.out.println("[2] - Voltar para o menu");
        System.out.print("Digite o numero equivalente a opção selecionada: ");
        int escolha = scanner.nextInt();


        switch (escolha) {
            case 1:
                System.out.print("Digite o codigo do produto para detalhar: ");
                int codigoDoProduto = scanner.nextInt();
                exibirDetalhesDeUmProduto(codigoDoProduto);
                break;
            case 2:
                break;
            default:
                break;
        }
        
        scanner.close();
        
    }

    public void cadastrarProduto(){
        // LUCAS
    }
    //  código, nome, unidade, valor unitário de compra, valor unitário de venda;
    public void exibirDetalhesDeUmProduto(int codigoDoProduto){
        for (Produto produto : listaDeProdutos) {
            if(produto.getCodigo().equals(codigoDoProduto)){
                Scanner scanner = new Scanner(System.in);
                System.out.printf("""
                    ---- Detalhes ---
                    Codigo:  %s
                    Nome: %s
                    Unidades: %d
                    Valor unitário compra: %f
                    Valor unitário de venda: %f
                    
                    [1] - Editar Produto
                    [2] - Voltar ao menu

                    Digite o numero equivalente a opção selecionada: 
                    """, produto.getCodigo(), produto.getNome(), produto.getUnidade(),produto.getValorUnitarioDeCompra(), produto.getValorUnitarioDeVenda());
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                       editarProduto(produto);
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void editarProduto(Produto produto){

    }

}
