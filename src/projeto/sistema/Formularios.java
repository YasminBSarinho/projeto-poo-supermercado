package projeto.sistema;

import java.util.Scanner;
import projeto.sistema.pessoas.Cliente;
import projeto.sistema.pessoas.usuarios.*;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;
import projeto.sistema.produtos.Produto;

public class Formularios {

    public Usuario pedirDadosFuncionario(String cargo){
        Scanner scanner = new Scanner(System.in);
		System.out.print("Informe o nome: ");
		String nome = scanner.next();
		System.out.print("Informe o novo login: ");
		String login = scanner.next();
		System.out.print("Informe a nova senha: ");
		String senha = scanner.next();

		System.out.print("Deseja informar o email e NIS/PIS? sim(s) ou não(n): ");
		String escolha = scanner.next();
        String email = "";
        String matricula = "";

		if (escolha.equals("s")) {
			System.out.print("Digite o email: ");
			email = scanner.next();
			System.out.print("Digite a matricula NIS/PIS: ");
			matricula = scanner.next();
        }

        Usuario usuario = null;

        if(cargo.equals("gerente")){
            return new Gerente(nome, cargo, login, senha, email, matricula);
        }else if(cargo.equals("almoxarife")){
            return new Almoxarife(nome, cargo, login, senha, email, matricula);
        }else if(cargo.equals("caixa eletronico")){
            return new CaixaEletronico(nome, cargo, login, senha, email, matricula);
        }
        return null;
    }

    public Produto solicitarDadosDoProduto(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String  nome = scanner.nextLine();

        Produto produto = new Produto();
        produto.setNome(nome);
        return produto;
    }

    public Cliente solicitarInformacaoCliente(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome: ");
        String nome = scanner.next();
        
        System.out.print("Digite o email: ");
        String email = scanner.next();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.next();
        
        System.out.print("Deseja adicionar o endereço para receber promoções e cupons de desconto? sim(s) ou não(n): ");
        String escolha = scanner.next();
        String endereco = "";
        if (escolha.equals("s")) {
			System.out.print("Digite o endereço: ");
			endereco = scanner.next();
        }
        System.out.println("""
        -------------------------------
        Cliente adicionado com sucesso!
        -------------------------------""");
        
        Cliente cliente = new Cliente(nome, email, cpf, endereco);
        return cliente;
    }
    
    public Registro solicitarDadosDeCompra(String codigo){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas unidade foram compradas: ");
        int unidades = scanner.nextInt();
        System.out.print("Valor unitário de compra: ");
        float valorUnitario = scanner.nextFloat();

        Registro registro = new Registro(codigo, unidades, valorUnitario, "");
        return registro;
    }

    public Registro solicitarValorDeVenda(String codigo){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Valor unitario de venda: ");
        float valorUnitarioDeVenda = scanner.nextFloat();

        Registro registro = new Registro(codigo, valorUnitarioDeVenda, "");
        return registro;
    }
}