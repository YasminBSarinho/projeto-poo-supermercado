package projeto.usuarios;

import projeto.produtos.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMercado {

	private ArrayList<Usuario> usuariosDoSistema = new ArrayList<Usuario>();
	
	private static ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>();

	public ArrayList<Usuario> getUsuariosDoSistema() {
		return usuariosDoSistema;
	}

	public void setUsuariosDoSistema(ArrayList<Usuario> usuariosDoSistema) {
		this.usuariosDoSistema = usuariosDoSistema;
	}

	public static ArrayList<Produto> getProdutosEmEstoque() {
		return produtosEmEstoque;
	}

	public void setProdutosEmEstoque(ArrayList<Produto> produtosEmEstoque) {
		this.produtosEmEstoque = produtosEmEstoque;
	}

	public boolean verificarExistenciaDeUsuarios() {

		if (usuariosDoSistema.isEmpty()) {
			return false;
		}
		return true;
	}

	public void cadastrarUsuario(String cargo) throws Exception {

		Scanner scanner = new Scanner(System.in);

		Usuario novoUsuario = null;
		
		System.out.print("Informe o nome: ");
		String nome = scanner.next();
		System.out.print("Informe o novo login: ");
		String login = scanner.next();
		System.out.print("Informe a nova senha: ");
		String senha = scanner.next();
		
		System.out.print("Deseja informar o email e NIS/PIS? sim(s) ou não(n): ");
		String escolha = scanner.next();
		
		String email, matricula;
		

	    if (escolha.equals("s")) {
	    	
	    	System.out.print("digite o email: ");
			email = scanner.next();
			System.out.print("Digite a matricula NIS/PIS: ");
			matricula = scanner.next();
			
	        if (cargo.equals("gerente")) {
	            novoUsuario = (Gerente) new  Gerente(nome, cargo, login, senha, email, matricula);
	        } else if (cargo.equals("almoxarife")) {
	            novoUsuario = (Almoxarife) new Almoxarife(nome, cargo, login, senha, email, matricula);
	        } else if (cargo.equals("caixa eletronico")) {
	            novoUsuario = (CaixaEletronico) new CaixaEletronico(nome, cargo, login, senha, email, matricula);
	        } else {
	            throw new Exception("O Tipo de usuario informado é inválido");
	        }
	        
	    } else if (escolha.equals("n")) {
	        if (cargo.equals("gerente")) {
	            novoUsuario = (Gerente) new Gerente(nome, cargo, login, senha);
	        } else if (cargo.equals("almoxarife")) {
	            novoUsuario = (Almoxarife) new Almoxarife(nome, cargo, login, senha);
	        } else if (cargo.equals("caixa eletronico")) {
	            novoUsuario = (CaixaEletronico) new CaixaEletronico(nome, cargo, login, senha);
	        } else {
	            throw new Exception("O Tipo de usuario informado é inválido");
	        }
	    } else {
	        throw new Exception("Escolha inválida. Use 's' para sim ou 'n' para não.");
	    }

	    usuariosDoSistema.add(novoUsuario);
	}
	

	public String getCargoUsuarioLogado(String login, String senha) {
		for (Usuario usuario : usuariosDoSistema) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario.getCargo();

			}
		}
		return null;
	}

	public void executarEscolha(int escolha, String cargo) {
		
		Scanner scanner = new Scanner(System.in);
		
		switch (escolha) {
		case 1:
			
			if (cargo.equals("gerente")) {
				System.out.print("Para cadastras digite: 'almoxarife' ou 'caixa eletronico': ");
				String tipo = scanner.nextLine();
				try {
					this.cadastrarUsuario(tipo.toLowerCase());
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("Você não possui cargo de gerente para isso");
			}
			
			
		case 2:
			
			if(cargo.equals("gerente") || cargo.equals("almoxarife") ) {
				
				Produto produto = new  Produto();
				produto.setCodigo();
				System.out.print("Digite o nome do produto desejado: ");
				produto.setNome(scanner.nextLine());
				System.out.print("Digite quantas unidades: ");
				produto.setUnidade(scanner.nextInt());
				System.out.print("Valor unitário de compra (R$): ");
				produto.setValorUnitarioDeCompra(scanner.nextFloat());
				System.out.print("Valor unitário de venda (R$): ");
				produto.setValorUnitarioDeVenda(scanner.nextFloat());
				System.out.print("Produto cadastrado. Código do produto: " + produto.getCodigo());
				produtosEmEstoque.add(produto);
				
			}
		}
	}
}