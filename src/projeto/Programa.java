package projeto;

import javax.swing.JOptionPane;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.produtos.Produto;
import projeto.sistema.visual.telas.JanelaCadastroUsuario;
import projeto.sistema.visual.telas.JanelaListarProdutos;
import projeto.sistema.visual.telas.JanelaLogin;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());
		JanelaListarProdutos janela = new JanelaListarProdutos(sistema, sistema.getUsuarioLogado("a", "a"));
	}
}