package projeto.sistema.utilitarios;

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

        cargo = cargo.toLowerCase();
        switch (cargo) {
            case "gerente":
                return new Gerente(nome, cargo, login, senha, email, matricula);
            case "almoxarife":
                return new Almoxarife(nome, cargo, login, senha, email, matricula);
            case "caixa":
                return new CaixaEletronico(nome, cargo, login, senha, email, matricula);
            default:
                return null;
        }
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
        
        return new Cliente(nome, email, cpf, endereco);
    }
    
    public Registro solicitarDadosDeCompra(String codigo){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas unidade foram compradas: ");
        int unidades = scanner.nextInt();
        System.out.print("Valor unitário de compra: ");
        float valorUnitario = scanner.nextFloat();

        return new Registro(codigo, unidades, valorUnitario, "");
    }

    public Registro solicitarValorDeVenda(String codigo){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Valor unitario de venda: ");
        float valorUnitarioDeVenda = scanner.nextFloat();

        return new Registro(codigo, valorUnitarioDeVenda, "");

    }

    public static Cupom criarCupom(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o codigo do cupom com 5 caracteres: ");
        String codigo = scanner.next();
        System.out.print("Digite o valor de desconto do cupom: ");
        float desconto = scanner.nextFloat()/100;
        System.out.println("""
                ------------------------------
                Codigo adicionado com sucesso!
                ------------------------------""");

        return new Cupom(codigo, desconto);
    }

    //public CaixaEletronico realizarVenda(){
        
    //}
}