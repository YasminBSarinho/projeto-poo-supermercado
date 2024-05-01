package projeto.usuarios;

import projeto.produtos.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMercado {

	private ArrayList<Usuario> usuariosDoSistema = new ArrayList<Usuario>();
	
	private ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>();

	public ArrayList<Usuario> getUsuariosDoSistema() {
		return usuariosDoSistema;
	}

	public void setUsuariosDoSistema(ArrayList<Usuario> usuariosDoSistema) {
		this.usuariosDoSistema = usuariosDoSistema;
	}

	public boolean verificarExistenciaDeUsuarios() {

		if (usuariosDoSistema.isEmpty()) {
			return false;
		}
		return true;
	}

	public void cadastrarUsuario(String tipoDeUsuario) throws Exception {

		Scanner scanner = new Scanner(System.in);

		Usuario novoUsuario = null;

		if (tipoDeUsuario.equals("gerente")) {
			novoUsuario = (Gerente) new Gerente();
			novoUsuario.setCargo("gerente");
		} else if (tipoDeUsuario.equals("almoxarife")) {
			novoUsuario = (Almoxarife) new Almoxarife();
			novoUsuario.setCargo("almafarife");
		} else if (tipoDeUsuario.equals("caixa eletronico")) {
			novoUsuario = (CaixaEletronico) new CaixaEletronico();
			novoUsuario.setCargo("caixa eletronico");
		} else {
			Exception tipoInvalido = new Exception("O Tipo de usuario informado é inválido");
			throw tipoInvalido;
		}

		System.out.print("Informe o nome: ");
		novoUsuario.setNome(scanner.next());
		System.out.print("Informe o novo login: ");
		novoUsuario.setLogin(scanner.next());
		System.out.print("Informe a nova senha: ");
		novoUsuario.setSenha(scanner.next());

		System.out.print("Deseja informar o email e NIS/PIS? sim(s) ou não(n): ");
		String escolha = scanner.next();

		if (escolha.equals("s")) {
			System.out.print("digite o email: ");
			novoUsuario.setEmail(scanner.next());
			System.out.print("Digite a matricula NIS/PIS: ");
			novoUsuario.setMatricula(scanner.next());

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