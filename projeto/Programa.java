package projeto;

import projeto.usuarios.SistemaMercado;
import java.util.Scanner;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FileReader;

public class Programa{
    public static void main(String[] args) {
        SistemaMercado sistema = new SistemaMercado();
        Scanner scanner = new Scanner(System.in);
    	Gson json = new Gson();
    	String tipoDeUsuario;
    	FileWriter escritor;
    	FileReader leitor;
    	while (true){
    		
            try{
            	
                if (sistema.verificarExistenciaDeUsuarios() == false){
                    System.out.println("Sistema iniciado pela primeira vez, requer o cadastro de gerente");
                    sistema.cadastrarUsuario("gerente");
                    escritor = new FileWriter("sistema.json");   
                    String jsonSistema = json.toJson(sistema);
                    escritor.write(jsonSistema);
                    escritor.close();
                    
                }else{
                	leitor = new FileReader("sistema.json");
                	sistema = json.fromJson(leitor, SistemaMercado.class);
                	leitor.close();
                }
                
                System.out.print("Faça seu login: ");
                String login = scanner.next();
                System.out.print("Informe sua senha: ");
                String senha = scanner.next();
                
                if(sistema.validarLogin(login, senha)) {
                    System.out.println("Login efetuado.");
                    
                    break;
                    
                }else{
                    System.out.println("Credenciais informadas são inválidas");
                    continue;
                }

                
            }catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
    	}
    	
    	
     
    }   
}