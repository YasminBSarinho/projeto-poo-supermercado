package projeto.usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMercado {

    private ArrayList<Usuario> usuariosDoSistema = new ArrayList<Usuario>();

    public ArrayList<Usuario> getUsuariosDoSistema() {
        return usuariosDoSistema;
    }

    public void setUsuariosDoSistema(ArrayList<Usuario> usuariosDoSistema) {
        this.usuariosDoSistema = usuariosDoSistema;
    }

    public boolean verificarExistenciaDeUsuarios(){
        
        if(usuariosDoSistema.isEmpty()){
            return false;
        }
        return true;
    }         
    public void cadastrarUsuario(String tipoDeUsuario) throws Exception{ 

        Scanner scanner = new Scanner(System.in);

        Usuario novoUsuario = null;
        if(tipoDeUsuario.equals("gerente")){
            novoUsuario = new Gerente();
        }
        else if(tipoDeUsuario.equals("almoxarife")){
            novoUsuario = new Almoxarife();
        }
        else if(tipoDeUsuario.equals("caixaeletronico")){
            novoUsuario = new CaixaEletronico();
        }else{
            Exception tipoInvalido = new Exception("O Tipo de usuario informa é inválido");
            throw tipoInvalido;
        }

        System.out.print("Informe seu nome:");
        novoUsuario.setNome(scanner.next());
        System.out.print("Informe seu novo login:");
        novoUsuario.setLogin(scanner.next());
        System.out.print("Informe sua nova senha:");
        novoUsuario.setSenha(scanner.next());


        System.out.print("Deseja informar seu email e NIS/PIS? sim(s) ou não(n)");
        String escolha = scanner.next();

        if(escolha.equals("s")){
            System.out.print("digite seu email: ");
            novoUsuario.setEmail(scanner.next());
            System.out.print("Digite ssua matricula NIS/PIS: ");
            novoUsuario.setMatricula(scanner.next());

        }
        usuariosDoSistema.add(novoUsuario);
    }
    
    public boolean validarLogin(String login, String senha) {
        for(Usuario usuario : usuariosDoSistema){
            if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }

}
           