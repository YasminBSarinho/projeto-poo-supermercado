package projeto;

import projeto.sistema.SistemaMercado;
import projeto.sistema.telas.JanelaDeCadastro;
import projeto.sistema.telas.JanelaDeCadastroCliente;
import projeto.sistema.telas.JanelaDeLogin;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());

		if(sistema.isSemGerente()){
			JanelaDeCadastro janelaCadastro =  new JanelaDeCadastro(sistema);
		}else{
			JanelaDeLogin  janelaDeLogin = new JanelaDeLogin(sistema);
		}
	}

}