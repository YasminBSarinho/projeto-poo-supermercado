package projeto;
import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaDeCadastro;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		SistemaMercado sistema = new SistemaMercado();
		Json json  = new Json();
		json.lerJson(sistema);
		JanelaDeCadastro janela = new JanelaDeCadastro(sistema);
	}
}