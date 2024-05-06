package projeto.sistema.pessoas.usuarios.funcionarios;

public class Almoxarife extends Funcionario {
    public Almoxarife(String nome, String cargo, String login, String senha){
        super(nome, cargo, login, senha);
    }

    public Almoxarife(String nome, String email, String cargo, String login, String senha, String matricula){
        super(nome, email, cargo, login, senha, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros

    public void registarEntradaDeProduto(){

    }
}
