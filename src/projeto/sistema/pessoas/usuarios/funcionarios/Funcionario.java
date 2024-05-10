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

    public void listarProdutos(SistemaMercado sistema){
        ArrayList <Produto> lista =  sistema.getProdutosEmEstoque();
        System.out.println("--- Listar Produto ---");
        System.out.println();
        System.out.println("Código | Nome do Produto | Valor | Quantidade");
        for (Produto produto : lista) {
            System.out.println(produto.getCodigo() + " | " + produto.getNome() + " | " + produto.getValorUnitarioDeVenda() + " | " + produto.getUnidade());
        }
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;
        while(true){
            System.out.println("[1] - Exibir detalhes de produto");
            System.out.println("[2] - Voltar para o menu");
            System.out.print("Digite o numero equivalente a opção selecionada: ");
            escolha = scanner.nextInt();
                            
            switch (escolha) {
                case 1:
                    System.out.print("Digite o codigo do produto para detalhar: ");
                    String codigoDoProduto = scanner.next();
                    exibirDetalhesDeUmProduto(codigoDoProduto, lista);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("""
                    ----------------------------------------------
                    A opção escolhida é inválida, tente novamente!
                    ----------------------------------------------""");
                    continue;
            }
            break;
        }

    }

    public void cadastrarProduto(){
        
    }
    
    public void exibirDetalhesDeUmProduto(String codigoDoProduto, ArrayList<Produto> lista){
        for (Produto produto : lista) {
            
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
                        editarProduto(codigoDoProduto, lista);
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
                
            }
        }
    }

    public void editarProduto(String codigo, ArrayList<Produto> lista){

        Scanner scanner = new Scanner(System.in);

        for(Produto produto : lista){
            if(codigo.equals(produto.getCodigo())){
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
