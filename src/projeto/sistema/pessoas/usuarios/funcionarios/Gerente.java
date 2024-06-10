package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.Scanner;

import projeto.sistema.utilitarios.Formularios;
import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;

public class Gerente extends Funcionario  {

    public Gerente(){

    }
    
    public Gerente(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }

    public void registrarValorUnitarioDeVendaDeProduto(SistemaMercado sistema){
        
        Formularios formulario = new Formularios();
        Scanner scanner = new Scanner(System.in);
        Produto produto;

        listarProdutos(sistema, false);

        while(true){
            System.out.print("Codigo do produto que deseja colocar o valor, ou digite sair para finalizar: ");
            
            String codigo = scanner.next();
            if(codigo.equals("sair")){
                break;
            }

            produto = sistema.buscarProdutoPorCodigo(codigo);
            if(produto == null){
                System.out.print("Produto não encontrado, tente novamente!");
                continue;
            }else{
                System.out.print("Valor unitario de venda: ");
                float valor = scanner.nextFloat();
                produto.setValorUnitarioDeVenda(valor);
                break;
            }
        }
    }
    
    public void gerarBalancoMensal(){
        
    }

    public void criarCupomDeDesconto(SistemaMercado sistema){
        sistema.getCupons().add(Formularios.criarCupom());
    }

}
