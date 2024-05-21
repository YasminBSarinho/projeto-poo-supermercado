package projeto.sistema.utilitarios;

import projeto.sistema.pessoas.usuarios.CaixaEletronico;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;

public class Menu {

    public static void mostrarMenuCaixa(CaixaEletronico caixaEletronico){
        System.out.print("""
                --- Menu ---
            [1] - Cadastrar Cliente
            [2] - Realizar venda 
            [3] - trocar usuario
            [4] - sair
            "Digite o numero equivalente a opção selecionada: """);
    }

    public static void mostrarMenuAlmoxarife(Almoxarife almoxarife){
        System.out.print("""
                --- Menu ---
            [1] - Cadastrar Cliente
            [2] - Cadastrar Produto
            [3] - Listar Produto
            [4] - Registrar entrada de produto
            [5] - Trocar usuario
            [6] - Sair
            Digite o numero equivalente a opção selecionada: """);
    }

    public static void mostrarMenuGerente(Gerente gerente){
        System.out.print("""
                --- Menu ---
            [1] - Cadastrar Cliente
            [2] - Cadastrar Produto
            [3] - Cadastrar funcionario
            [4] - Listar Produto
            [5] - Registrar valor unitario de venda
            [6] - Enviar cupom de desconto por email
            [7] - Gerar relatório de balanço mensal
            [8] - Trocar usuario
            [9] - Sair
            Digite o numero equivalente a opção selecionada: """);
    }
}
