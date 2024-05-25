package projeto.sistema.pessoas.usuarios;

import java.util.Scanner;

import projeto.sistema.SistemaMercado;
import projeto.sistema.produtos.Produto;
import projeto.sistema.utilitarios.Cupom;
import projeto.sistema.utilitarios.Registro;

public class CaixaEletronico extends Usuario {
    public CaixaEletronico(){

    }
    public CaixaEletronico(String nome, String cargo, String login, String senha, String email, String matricula){
    	super(nome, cargo, login, senha, email, matricula);
    }

    // todos os metodos estao sem retorno pois ainda serao feitos, entao quando for fazer, 
    // reescreva o tipo de retorno e os parametros ou isso pode causar erros

    public void realizarVenda(SistemaMercado sistema){
        
        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        float total = 0;
        
        System.out.print("CPF: ");
        String cpf = scanner.next();
        if (sistema.buscarCliente(cpf) == null) {
            System.out.print("Cliente não cadastrado, prosseguindo com cadastro.");
            this.cadastrarCliente(sistema);
        }

        while(!escolha.toLowerCase().equals("sair")){
            
            System.out.print("Digite o codigo do produto que pegou: ");
            String codigo = scanner.next();
            Produto produto = sistema.buscarProduto(codigo);
            if(produto == null){
                continue;
            }
            System.out.print("Digite a quantidade comprada do produto: ");
            int quantidade = scanner.nextInt();
            produto.setUnidade(produto.getUnidade() - quantidade);
            total += produto.getValorUnitarioDeVenda() * quantidade;
            
            System.out.print("Digite sair para finalizar ou digite qualquer entrada para continuar: ");
            escolha = scanner.next();
        }
        
        System.out.print("Deseja adicionar cupom de desconto, (s)/(n): ");
        String resposta = scanner.next();
        
        if(resposta.toLowerCase().equals("s")){
            while (true) {
                
                System.out.println("Digite o codigo do cupom ou sair para finalizar: ");
                String codigo = scanner.next();
                if(codigo.equals("sair")){
                    break;
                }
                
                Cupom cupom = sistema.validarCupom(codigo);
                if(cupom == null){
                    System.out.print("Codigo não é valido! Tente novamente!");
                }else{
                    total -= total * cupom.getDesconto();
                    break;
                }
            }
        }
        System.out.printf("A sua compra deu R$ %.2f\n", total);
        Registro registroDeVenda = new Registro(total, "");
        sistema.getRegistrosDeVenda().add(registroDeVenda);
    }
}
