package projeto;

import javax.swing.JOptionPane;

import projeto.sistema.SistemaMercado;
import projeto.sistema.visual.telas.JanelaCadastroUsuario;
import projeto.sistema.visual.telas.JanelaLogin;
import projeto.sistema.utilitarios.Json;

public class Programa {
	public static void main(String[] args) {
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();
		System.out.println(sistema.getListaDeUsuarios().size());

		if(sistema.isSemGerente()){	
			JanelaCadastroUsuario janelaCadastro =  new JanelaCadastroUsuario(sistema);	
		}else{	
			JanelaLogin  janelaDeLogin = new JanelaLogin(sistema);	
		}
	}
}