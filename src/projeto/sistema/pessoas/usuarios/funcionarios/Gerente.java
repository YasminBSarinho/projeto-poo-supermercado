package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.Scanner;

import projeto.sistema.Formularios;
import projeto.sistema.Registro;
import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;

public class Gerente extends Funcionario  {

    public Gerente(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros

    public void registrarValorUnitarioDeVendaDeProduto(SistemaMercado sistema){
        Formularios formulario = new Formularios();
        Scanner scanner = new Scanner(System.in);

        listarProdutos(sistema, false);
        System.out.print("Codigo do produto que deseja colocar o valor: ");
        String codigo = scanner.next();

        for (Produto produto: sistema.getProdutosEmEstoque()){
            
            if(produto.getCodigo().equals(codigo)){
                Registro registro = formulario.solicitarValorDeVenda(codigo);
                float valorUnitarioDeVenda = registro.getValor();

                produto.setValorUnitarioDeVenda(valorUnitarioDeVenda);
                sistema.getRegistrosDeCompra().add(registro);
            }
        }

    }
    
    public void gerarBalancoMensal(){
        
    }

    public void enviarEmailComCupomDeDesconto(){

    }

}
