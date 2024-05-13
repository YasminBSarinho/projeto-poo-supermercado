package projeto;

import projeto.sistema.Menu;
import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.*;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;

import java.util.Scanner;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;

public class Programa {
	public static void main(String[] args) {

		SistemaMercado sistema = new SistemaMercado();
		Scanner scanner = new Scanner(System.in);
		Gson json = new Gson();
		FileWriter escritor;
		FileReader leitor;
		Boolean on = true;
		
		while (on) {
			
			System.out.println("-----Bem-Vindo-----");
			
			// Verifica se existe arquivo json para ler
			try {
				leitor = new FileReader("sistema.json");
				sistema = json.fromJson(leitor, SistemaMercado.class);
				leitor.close();
				
			} catch (Exception e) {
				// No caso de não haver um aquivo para ler ainda
			}

			// Cadastro ou login inicial
			try {

				if (!sistema.verificarExistenciaDeUsuarios()) {
					System.out.println("Sistema iniciado pela primeira vez, requer o cadastro de gerente!");
					sistema.cadastrarFuncionario();
					escritor = new FileWriter("sistema.json");
					String jsonSistema = json.toJson(sistema);
					escritor.write(jsonSistema);
					escritor.close();

				} else {

					System.out.print("Digite o seu login: ");
					String login = scanner.next();
					System.out.print("Digite o sua Senha: ");
					String senha = scanner.next();

					Usuario usuario = sistema.getUsuarioLogado(login, senha);

					if (usuario != null) {
						System.out.println("Login efetuado");

					} else {
						System.out.println("Credenciais informadas são inválidas");
						continue;
					}

					// Sistema

					while (true) {

						int escolha = 0;
						if (usuario instanceof Gerente){

							Gerente gerente = (Gerente) usuario;
							Menu.mostrarMenuGerente(gerente);
							escolha = scanner.nextInt();
							switch (escolha) {
								case 1:
									gerente.cadastrarCliente(sistema);
									break;
								case 2:
									gerente.cadastrarProduto(sistema);
									break;
								case 3:
									System.out.print("almoxarife ou caixa eletronico? ");
									String cargo = scanner.next();
									sistema.cadastrarFuncionario(cargo);
									break;
								case 4:
									gerente.listarProdutos(sistema, true);
									
									break;
								case 5:
									gerente.registrarValorUnitarioDeVendaDeProduto();
									break;
								case 6:
									gerente.enviarEmailComCupomDeDesconto();
									break;
								case 7:
									gerente.gerarBalancoMensal();
									break;
								case 8:
									escolha = -1;
									break;
								case 9:
									escolha = -1;
									on = false;
									break;
								default:
									break;
							}
						}else if(usuario instanceof Almoxarife){

							Almoxarife almoxarife = (Almoxarife) usuario;
							Menu.mostrarMenuAlmoxarife(almoxarife);
							escolha = scanner.nextInt();
							switch (escolha) {
								case 1:
									almoxarife.cadastrarCliente(sistema);
									break;
								case 2:
									almoxarife.cadastrarProduto(sistema);
									break;
								case 3:
									almoxarife.listarProdutos(sistema, true);
									break;
								case 4:
									almoxarife.registarEntradaDeProduto(sistema);
									break;
								case 5:
									escolha = -1;
									break;
								case 6:
									escolha = -1;
									on = false;
									break;
								default:
									break;
							}
						}
						else if(usuario instanceof CaixaEletronico){

							CaixaEletronico caixa = (CaixaEletronico) usuario;
							Menu.mostrarMenuCaixa(caixa);
							escolha = scanner.nextInt();
							switch (escolha) {
								case 1:
									caixa.cadastrarCliente(sistema);
									break;
								case 2:
									caixa.realizarVenda();
									break;
								case 3:
									escolha = -1;
									break;
								case 4:
									escolha = -1;	
									on = false;
									break;
								default:
									break;
							}
						}

						escritor = new FileWriter("sistema.json");
						String jsonSistema = json.toJson(sistema);
						escritor.write(jsonSistema);
						escritor.close();

						if(escolha == -1){
							break;
						}

					}
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		scanner.close();
	}
}