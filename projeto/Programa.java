package projeto;

import projeto.usuarios.SistemaMercado;

public class Programa{
    public static void main(String[] args) {
        SistemaMercado sistema = new SistemaMercado();
        try{
            if (sistema.verificarExistenciaGerente() == false){
                System.out.println("Sistema iniciado pela primeira vez, requer o cadastro de gerente");
                sistema.cadastrarUsuario("gerente");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

    }   
}