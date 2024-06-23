package sistema.pessoas.usuarios.funcionarios;

import sistema.pessoas.usuarios.Usuario;

public abstract class Funcionario extends Usuario{
    public Funcionario(){

    }
    public Funcionario(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }
}
