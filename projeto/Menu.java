package projeto;
import java.util.Scanner;
import projeto.usuarios.Almoxarife;
import projeto.usuarios.CaixaEletronico;
import projeto.usuarios.Gerente;

public class Menu {
    public static void mostrarMenuInicial(){
        System.out.println("--- Menu ---");
        System.out.println("[1] - Cadastrar Cliente");
        
    }

    public static void mostrarMenuFuncionario(){
        System.out.println("[2] - Cadastrar Produto");
        System.out.println("[3] - Listar Produto");
    }

    public static void mostrarMenuCaixa(CaixaEletronico caixaEletronico){
        mostrarMenuInicial();
        System.out.println("[2] - Realizar venda");
        System.out.print("Digite o numero equivalente a opção selecionada: ");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        
        switch(escolha){
            case 1:
                caixaEletronico.cadastrarCliente();
                break;
            case 2:
                caixaEletronico.realizarVenda();
                break;
        }
        
    }

    public static void mostrarMenuAlmoxarife(Almoxarife almoxarife){
        mostrarMenuInicial();
        mostrarMenuFuncionario();
        System.out.println("[4] - Registrar entrada de produto");
        System.out.print("Digite o numero equivalente a opção selecionada: ");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch(escolha){
            case 1:
                almoxarife.cadastrarCliente();
                break;
            case 2:
                almoxarife.cadastrarProduto();
                break;
            case 3:
                almoxarife.listarProdutos();
                break;

        }
    }

    public static void mostrarMenuGerente(Gerente gerente){
        mostrarMenuInicial();
        mostrarMenuFuncionario();
        System.out.println("[4] - Registrar valor unitario de venda");
        System.out.println("[5] - Enviar cupom de desconto por email");
        System.out.println("[6] - Gerar relatório de balanço mensal");
        System.out.print("Digite o numero equivalente a opção selecionada: ");
        
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch(escolha){
            case 1:
                gerente.cadastrarCliente();
                break;
            case 2:
                gerente.cadastrarProduto();
                break;
            case 3:
                gerente.listarProdutos();
                break;
            case 4:
                gerente.registrarValorUnitarioDeVendaDeProduto();
                break;
            case 5:
                gerente.enviarEmailComCupomDeDesconto();
                break;
            case 6:
                gerente.gerarBalancoMensal();
                break;
        }
        
        
    }

}
