package projeto;

import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaCadastroFuncionario;
import projeto.sistema.telas.JanelaLogin;
import projeto.sistema.telas.JanelaUsuario;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());

		JanelaUsuario janela = new JanelaUsuario(sistema);
	}

}