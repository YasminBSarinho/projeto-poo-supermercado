package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.Scanner;

import projeto.sistema.utilitarios.Formularios;
import projeto.sistema.utilitarios.Registro;
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

    public void criarCupomDeDesconto(SistemaMercado sistema){
        sistema.getCupons().add(Formularios.criarCupom());
    }

}
