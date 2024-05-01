package projeto;

import projeto.usuarios.SistemaMercado;
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
		String cargo;
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

				if (sistema.verificarExistenciaDeUsuarios() == false) {
					System.out.println("Sistema iniciado pela primeira vez, requer o cadastro de gerente!");
					sistema.cadastrarUsuario("gerente");
					escritor = new FileWriter("sistema.json");
					String jsonSistema = json.toJson(sistema);
					escritor.write(jsonSistema);
					escritor.close();

				} else {

					System.out.print("Digite o seu login: ");
					String login = scanner.next();
					System.out.print("Digite o sua Senha: ");
					String senha = scanner.next();

					cargo = sistema.getCargoUsuarioLogado(login, senha);

					if (cargo != null) {
						System.out.println("Login efetuado");

					} else {
						System.out.println("Credenciais informadas são inválidas");
						continue;
					}

					// Sistema em si

					while (true) {
						System.out.print("""

									---Opções---
								[1] - Cadastrar um usuário
								[2] - Cadastrar um Produto
								[4] - Trocar de conta
								[5] - Sair
								
									""");
						System.out.print("Sua escolha: ");
						
						int escolha = scanner.nextInt();
						
						if (escolha == 4) {
							break;
						}
						else if(escolha == 5) {
							on = false;
							break;
						}
						
						sistema.executarEscolha(escolha, cargo);
						
						escritor = new FileWriter("sistema.json");
						String jsonSistema = json.toJson(sistema);
						escritor.write(jsonSistema);
						escritor.close();
					}

				}
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}

		}

	}
}