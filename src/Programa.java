import sistema.SistemaMercado;
import sistema.utilitarios.Json;
import sistema.visual.telas.JanelaCadastroUsuario;
import sistema.visual.telas.JanelaLogin;

public class Programa {
	public static void main(String[] args) {
		Json json  = new Json();
		SistemaMercado sistema = json.lerJson();

		if(sistema.isSemGerente()){
			JanelaCadastroUsuario janelaCadastro =  new JanelaCadastroUsuario(sistema);
		}else{
			JanelaLogin  janelaDeLogin = new JanelaLogin(sistema);
		}   
		
	}
}