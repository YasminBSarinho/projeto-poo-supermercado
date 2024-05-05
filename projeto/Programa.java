package projeto;

import projeto.usuarios.*;
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

					Usuario usuario = sistema.getUsuarioLogado(login, senha);

					if (usuario != null) {
						System.out.println("Login efetuado");

					} else {
						System.out.println("Credenciais informadas são inválidas");
						continue;
					}

					// Sistema

					while (true) {
						switch (usuario.getCargo()) {
							case "gerente":
								Gerente usuarioGerente = (Gerente) usuario;
								Menu.mostrarMenuGerente(usuarioGerente);
								break;
							case "almoxarife":
								break;
							case "caixa eletronico":
								break;
							default:
								break;
						}
						
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