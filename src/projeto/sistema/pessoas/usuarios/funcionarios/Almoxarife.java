package projeto.sistema.pessoas.usuarios.funcionarios;

import java.util.Scanner;

import projeto.sistema.utilitarios.Registro;
import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;

public class Almoxarife extends Funcionario {
    public Almoxarife(){

    }
    public Almoxarife(String nome, String email, String cargo, String login, String senha, String matricula){
        super(nome, email, cargo, login, senha, matricula);
    }
    /*
    public void registarEntradaDeProduto(SistemaMercado sistema){

        Formularios formulario = new Formularios();
        Scanner scanner = new Scanner(System.in);

        listarProdutos(sistema, false);
        System.out.print("Código do produto que está entrando em: ");
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

    }*/
}
