package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.Scanner;

import projeto.sistema.Formularios;
import projeto.sistema.Registro;
import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;

public class Almoxarife extends Funcionario {
    
    public Almoxarife(String nome, String email, String cargo, String login, String senha, String matricula){
        super(nome, email, cargo, login, senha, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros

    public void registarEntradaDeProduto(SistemaMercado sistema){

        Formularios formulario = new Formularios();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o código do produto: ");
        String codigo = scanner.next();
        for (Produto produto: sistema.getProdutosEmEstoque()){
            if(produto.getCodigo().equals(codigo)){
                Registro registro = formulario.solicitarDadosDeCompra(codigo);
                float valorUnitario = registro.getValor();
                produto.setValorUnitarioDeCompra(valorUnitario);
                produto.setUnidade(produto.getUnidade() + registro.getUnidades());
                sistema.getRegistrosDeCompra().add(registro);
            }
        }

    }
}
