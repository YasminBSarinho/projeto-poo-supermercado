package projeto;

import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;
import projeto.sistema.visual.telas.JanelaCadastroCliente;
import projeto.sistema.visual.telas.JanelaCadastroProduto;
import projeto.sistema.visual.telas.JanelaCadastroUsuario;
import projeto.sistema.visual.telas.JanelaCupom;
import projeto.sistema.visual.telas.JanelaDeVendas;
import projeto.sistema.visual.telas.JanelaLogin;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());

		Produto produto1 = new Produto("Batata", 20);
		Produto produto2 = new Produto("Banana",23);
		produto1.setValorUnitarioDeVenda(100.50F);
		produto2.setValorUnitarioDeVenda(10.5F);
		sistema.getProdutosEmEstoque().add(produto1);
		sistema.getProdutosEmEstoque().add(produto2);
		JanelaCupom cupom = new JanelaCupom(sistema);
		JanelaDeVendas janela = new JanelaDeVendas(sistema);
	}
}