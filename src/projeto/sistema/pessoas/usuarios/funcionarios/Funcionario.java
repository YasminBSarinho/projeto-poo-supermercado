package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.ArrayList;
import java.util.Scanner;

import projeto.sistema.Formularios;
import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.produtos.Produto;

public class Funcionario extends Usuario{

    public Funcionario(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }


    public void listarProdutos(SistemaMercado sistema, Boolean detalhes){ 
        ArrayList <Produto> lista =  sistema.getProdutosEmEstoque();
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while(true){
            System.out.println("""
                        --- Listar Produto ---
            "Código | Nome do Produto | Valor | Quantidade""");

            for (Produto produto : lista) {
                System.out.println(produto.getCodigo() + " | " + produto.getNome() + " | " + produto.getValorUnitarioDeVenda() + " | " + produto.getUnidade());
                }

            if(detalhes){
                System.out.println("""
                    [1] - Exibir detalhes de produto
                    [2] - Voltar para o menu """);
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
            }
            break;
        }
    }
    public void cadastrarProduto(SistemaMercado sistema){
        Formularios formulario = new Formularios();
        Produto produto = formulario.solicitarDadosDoProduto();
        sistema.getProdutosEmEstoque().add(produto);
    }
    
    public void exibirDetalhesDeUmProduto(String codigoDoProduto, ArrayList<Produto> lista){
        for (Produto produto : lista) {
            
            if(produto.getCodigo().equals(codigoDoProduto)){

                Scanner scanner = new Scanner(System.in);
                
                System.out.printf("""
                    ---- Detalhes ---
                    Codigo: %s
                    Nome: %s
                    Unidades: %d
                    Valor unitário compra: %.2f
                    Valor unitário de venda: %.2f
                    [1] - Editar Produto
                    [2] - Voltar ao menu
                    """,
                    produto.getCodigo(), 
                    produto.getNome(),
                    produto.getUnidade(),
                    produto.getValorUnitarioDeCompra(), 
                    produto.getValorUnitarioDeVenda());

                System.out.print("Digite o numero equivalente a opção selecionada: " );
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
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
                System.out.print("""
                    --- Editar Produto ---

                    [1] - Nome
                    [2] - Unidades
                    [3] - Valor unitário de compra
                    [4] - Valor unitário de venda

                    Digite o número equivalente a informação que você deseja editar: """);
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.print("Digite o novo nome do produto: ");   
                        String nome = scanner.next();
                        produto.setNome(nome);
                        break;
                    case 2:
                        System.out.print("Digite as unidade do produto: ");   
                        int unidade = scanner.nextInt();
                        produto.setUnidade(unidade);
                        break;
                    case 3:
                        System.out.print("Digite o valor unitário compra do produto: "); 
                        int valorUnitarioDeCompra = scanner.nextInt();
                        produto.setValorUnitarioDeCompra(valorUnitarioDeCompra);
                        break;
                    case 4:
                        System.out.print("Digite o valor unitário venda do produto: "); 
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
