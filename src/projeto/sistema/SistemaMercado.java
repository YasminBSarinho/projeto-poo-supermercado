package projeto.sistema;

import projeto.sistema.pessoas.usuarios.CaixaEletronico;
import projeto.sistema.pessoas.usuarios.Usuario;
import projeto.sistema.pessoas.usuarios.funcionarios.Almoxarife;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;
import projeto.sistema.produtos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMercado {

	private ArrayList<Gerente> gerentes = new ArrayList<>();
	private ArrayList<Almoxarife> almoxarifes = new ArrayList<>();
	private ArrayList<CaixaEletronico> caixas = new ArrayList<>();
	private static ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>();

	public ArrayList<Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(ArrayList<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public ArrayList<Almoxarife> getAlmoxarifes() {
		return almoxarifes;
	}

	public void setAlmoxarifes(ArrayList<Almoxarife> almoxarifes) {
		this.almoxarifes = almoxarifes;
	}

	public ArrayList<CaixaEletronico> getCaixas() {
		return caixas;
	}

	public void setCaixas(ArrayList<CaixaEletronico> caixas) {
		this.caixas = caixas;
	}

	public static ArrayList<Produto> getProdutosEmEstoque() {
		return produtosEmEstoque;
	}

	public static void setProdutosEmEstoque(ArrayList<Produto> produtosEmEstoque) {
		SistemaMercado.produtosEmEstoque = produtosEmEstoque;
	}

	public boolean verificarExistenciaDeUsuarios() {

		if (gerentes.isEmpty()) {
			return false;
		}
		return true;
	}

	public void cadastrarUsuario(String cargo) throws Exception {
		Scanner scanner = new Scanner(System.in);
	
		System.out.print("Informe o nome: ");
		String nome = scanner.next();
		System.out.print("Informe o novo login: ");
		String login = scanner.next();
		System.out.print("Informe a nova senha: ");
		String senha = scanner.next();
		
		String email = "";
		String matricula = "";
		
		System.out.print("Deseja informar o email e NIS/PIS? sim(s) ou não(n): ");
		String escolha = scanner.next();
	
		if (escolha.equals("s")) {
			System.out.print("Digite o email: ");
			email = scanner.next();
			System.out.print("Digite a matricula NIS/PIS: ");
			matricula = scanner.next();
		}
	
		
		switch (cargo) {
			case "gerente":
				Gerente gerente = new Gerente(nome, cargo, login, senha, email, matricula);
				gerentes.add(gerente);
				break;
			case "almoxarife":
				Almoxarife almoxarife = new Almoxarife(nome, cargo, login, senha, email, matricula);
				almoxarifes.add(almoxarife);
				break;
			case "caixa eletronico":
				CaixaEletronico caixa = new CaixaEletronico(nome, cargo, login, senha, email, matricula);
				caixas.add(caixa);
				break;
				
			default:
				throw new Exception("O Tipo de usuário informado é inválido.");
		}

	}
	

	public Usuario getUsuarioLogado(String login, String senha) {
		ArrayList<Usuario> todosUsuarios = new ArrayList<>();
		todosUsuarios.addAll(gerentes);
		todosUsuarios.addAll(almoxarifes);
		todosUsuarios.addAll(caixas);

		for (Usuario usuario : todosUsuarios) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

}