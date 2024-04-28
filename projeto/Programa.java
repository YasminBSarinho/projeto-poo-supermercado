package projeto;

import projeto.usuarios.SistemaMercado;
import java.util.Scanner;
public class Programa{
    public static void main(String[] args) {

        SistemaMercado sistema = new SistemaMercado();
        Scanner scanner = new Scanner(System.in);

       while (true){
            try{
                if (sistema.verificarExistenciaDeUsuarios() == false){
                    System.out.println("Sistema iniciado pela primeira vez, requer o cadastro de gerente");
                    sistema.cadastrarUsuario("gerente");
                }

            }catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
       }

    }   
}