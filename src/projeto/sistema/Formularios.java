package projeto.sistema;

import java.util.Scanner;
import projeto.sistema.pessoas.usuarios.*;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;

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

        if(cargo.equals("gerente")){
            Gerente gerente = new Gerente(nome, cargo, login, senha, email, matricula);
            return gerente;
        }else if(cargo.equals("almoxarife")){
            Almoxarife almoxarife = new Almoxarife(nome, cargo, login, senha, email, matricula);
            return almoxarife;
        }else if(cargo.equals("caixa eletronico")){
            CaixaEletronico caixa = new CaixaEletronico(nome, cargo, login, senha, email, matricula);
            return caixa;
        }
        return null;

    }

    //public Cliente solicitarInformacaoCliente(){

   // }
}