package projeto.sistema.pessoas.usuarios;

import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;

public class CaixaEletronico extends Usuario {
    public CaixaEletronico(){

    }
    public CaixaEletronico(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros

    public void realizarVenda(){
        // lucas vai fazer
    }
}
