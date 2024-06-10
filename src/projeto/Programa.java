package projeto;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.telas.JanelaCadastroProduto;
import projeto.sistema.visual.telas.JanelaCadastroUsuario;
import projeto.sistema.visual.telas.JanelaLogin;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());

	
		JanelaCadastroProduto janela = new JanelaCadastroProduto(sistema);

	}
}