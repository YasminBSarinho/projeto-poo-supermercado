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
        
    }
    
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
                        System.out.println("""
                                --- Editar Produto ---
                                Digite o código do produto que você deseja editar: 
                                """);
                        String codigoDoProdutoEditar = scanner.next();
                        editarProduto(produto);
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
                scanner.close();
            }
        }
    }

    public void editarProduto(Produto produtoEditar){

        Scanner scanner = new Scanner(System.in);

        for(Produto produto : SistemaMercado.getProdutosEmEstoque()){
            if(produtoEditar.equals(produto.getCodigo())){
                System.out.println("""
                    --- Editar Produto ---

                    [1] - Nome
                    [2] - Unidades
                    [3] - Valor unitário de compra
                    [4] - Valor unitário de venda

                    Digite o número equivalente a informação que você deseja editar: 
                """);
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Digite o novo nome do produto: ");   
                        String nome = scanner.next();
                        produto.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Digite as unidade do produto: ");   
                        int unidade = scanner.nextInt();
                        produto.setUnidade(unidade);
                        break;
                    case 3:
                        System.out.println("Digite o valor unitário compra do produto: "); 
                        int valorUnitarioDeCompra = scanner.nextInt();
                        produto.setValorUnitarioDeCompra(valorUnitarioDeCompra);
                        break;
                    case 4:
                        System.out.println("Digite o valor unitário venda do produto: "); 
                        int valorUnitarioDeVenda = scanner.nextInt();
                        produto.setValorUnitarioDeVenda(valorUnitarioDeVenda);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
