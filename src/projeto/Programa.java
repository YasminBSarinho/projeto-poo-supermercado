package projeto;
import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaDeCadastro;
import projeto.sistema.telas.JanelaDeLogin;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());
		JanelaDeCadastro JanelaCadastro =  new JanelaDeCadastro(sistema);
		JanelaDeLogin janelaLogin =  new JanelaDeLogin(sistema);
		
	}
}