package projeto;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.pessoas.usuarios.funcionarios.Funcionario;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;
import projeto.sistema.telas.JanelaCadastroUsuario;
import projeto.sistema.telas.JanelaCupom;
import projeto.sistema.telas.JanelaLogin;
import projeto.sistema.telas.JanelaUsuario;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());

		JanelaCadastroUsuario janela = new JanelaCadastroUsuario(sistema);
	}

}