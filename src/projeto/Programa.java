package projeto;

import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;
import projeto.sistema.visual.telas.JanelaCadastroCliente;
import projeto.sistema.visual.telas.JanelaCadastroProduto;
import projeto.sistema.visual.telas.JanelaCadastroUsuario;
import projeto.sistema.visual.telas.JanelaCupom;
import projeto.sistema.visual.telas.JanelaDeVendas;
import projeto.sistema.visual.telas.JanelaLogin;
import projeto.sistema.visual.telas.usuarios.JanelaUsuario;
import projeto.sistema.visual.telas.usuarios.funcionarios.JanelaFuncionario;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());
		JanelaFuncionario janela2 = new JanelaFuncionario(sistema);
	}
}