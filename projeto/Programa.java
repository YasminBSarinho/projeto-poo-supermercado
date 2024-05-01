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
    	FileWriter escritor;
    	FileReader leitor;
    	String cargo;
    	
    	while (true){
    		
	    	try {
				leitor = new FileReader("sistema.json");
		        sistema = json.fromJson(leitor, SistemaMercado.class);
		        leitor.close();
			}
	    	catch (Exception e) {
					System.out.println("Não há arquivo por enquanto");
				}

            try{
            	

                if (sistema.verificarExistenciaDeUsuarios() == false){
                	System.out.println("Sistema iniciado pela primeira vez, requer o cadastro de gerente");
                    sistema.cadastrarUsuario("gerente");
                    escritor = new FileWriter("sistema.json");   
                    String jsonSistema = json.toJson(sistema);
                    escritor.write(jsonSistema);
                    escritor.close();
                    
                }else{
                	
            		System.out.print("Digite o seu login: ");
            		String login = scanner.next();
            		System.out.print("Digite o sua Senha: ");
            		String senha = scanner.next();
            		 
        			cargo = sistema.getCargoUsuarioLogado(login, senha);
        			 
            		if(cargo != null) {
            			 System.out.println("Login efetuado");

            		}
            		else {
            			System.out.println("Credenciais informadas são inválidas");
            			continue;
            		}
            		
            		while(true) {
            			System.out.print("""
            			 		
        			 		---Opções--- 
        			 	[1] - Cadastrar um usuário.
        			 	[5] - Sair
        			 		""");
            			int escolha = scanner.nextInt();
            			if(escolha == 5) {
            				break;
            			}
            			sistema.executarEscolha(escolha, cargo);
            			
                        escritor = new FileWriter("sistema.json");   
                        String jsonSistema = json.toJson(sistema);
                        escritor.write(jsonSistema);
                        escritor.close();
            		}
            		
                }
            }
            catch(Exception e){
            	System.out.println("Erro: " + e.getMessage());
            }
            
    	}
    	
    }   
}