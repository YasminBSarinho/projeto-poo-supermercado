import sistema.SistemaMercado;
import sistema.pessoas.usuarios.CaixaEletronico;
import sistema.pessoas.usuarios.Usuario;
import sistema.pessoas.usuarios.funcionarios.Almoxarife;
import sistema.utilitarios.Json;
import sistema.visual.telas.JanelaCadastroUsuario;
import sistema.visual.telas.JanelaLogin;
import sistema.visual.telas.usuarios.JanelaCaixa;
import sistema.visual.telas.usuarios.funcionarios.JanelaAlmoxarife;
import sistema.visual.telas.usuarios.funcionarios.JanelaGerente;

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