package projeto.usuarios;

public class Funcionario extends Usuario{

    public Funcionario(String nome, String cargo, String login, String senha){
        super(nome, cargo, login, senha);
    }

    public Funcionario(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros

    public void cadastrarProduto(){

    }

    public void listarProdutos(){

    }

    public void exibirDetalhesDeUmProduto(){

    }

    public void editarProduto(){

    }

}
