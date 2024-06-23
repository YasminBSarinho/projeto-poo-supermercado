package sistema.pessoas.usuarios.funcionarios;

public class Gerente extends Funcionario  {

    public Gerente(){

    }
    
    public Gerente(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }
}
