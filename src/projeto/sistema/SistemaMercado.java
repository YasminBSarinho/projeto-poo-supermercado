package projeto.sistema;

import projeto.sistema.pessoas.usuarios.funcionarios.*;
import projeto.sistema.pessoas.Cliente;
import projeto.sistema.pessoas.usuarios.*;
import projeto.sistema.produtos.*;
import java.util.ArrayList;

public class SistemaMercado {

	private Gerente gerente;
	private ArrayList<Almoxarife> almoxarifes = new ArrayList<>();
	private ArrayList<CaixaEletronico> caixas = new ArrayList<>();
	private ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Registro> registrosDeCompra = new ArrayList<>();
	private ArrayList<Registro> registrosDeVenda = new ArrayList<>();

	public boolean verificarExistenciaDeUsuarios() {
		if (gerente == null) {
			return false;
		}
		return true;
	}

	public void cadastrarFuncionario() throws Exception {
			Formularios formulario = new Formularios();
			Gerente gerente;
			gerente = (Gerente) formulario.pedirDadosFuncionario("gerente");
			this.setGerente(gerente);
		}

	public void cadastrarFuncionario(String cargo) throws Exception {

		Formularios formulario = new Formularios();
		switch (cargo) {
			case "almoxarife":
				Almoxarife almoxarife;
				almoxarife = (Almoxarife) formulario.pedirDadosFuncionario(cargo);
				almoxarifes.add(almoxarife);
				break;
			case "caixa eletronico":
				CaixaEletronico caixa;
				caixa = (CaixaEletronico) formulario.pedirDadosFuncionario(cargo);
				caixas.add(caixa);
				break;
			default:
				throw new Exception("O Tipo de usuário informado é inválido.");
		}
	}

	public Usuario getUsuarioLogado(String login, String senha) {

		ArrayList<Usuario> todosUsuarios = new ArrayList<>();
		todosUsuarios.add(gerente);
		todosUsuarios.addAll(almoxarifes);
		todosUsuarios.addAll(caixas);

		for (Usuario usuario : todosUsuarios) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

	public Produto buscarProduto(String codigo){
		for (Produto produto : getProdutosEmEstoque()){
			if(produto.getCodigo().equals(codigo)){
				return produto;
			}
		}
		return null;
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

	public ArrayList<Produto> getProdutosEmEstoque() {
		return produtosEmEstoque;
	}

	public void setProdutosEmEstoque(ArrayList<Produto> produtosEmEstoque) {
		this.produtosEmEstoque = produtosEmEstoque;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	public void setClientes(ArrayList<Cliente> clientes){
		this.clientes = clientes;
	}

	public ArrayList<Registro> getRegistrosDeVenda() {
		return registrosDeVenda;
	}

	public void setRegistrosDeVenda(ArrayList<Registro> registrosDeVenda) {
		this.registrosDeVenda = registrosDeVenda;
	}

	public ArrayList<Registro> getRegistrosDeCompra() {
		return registrosDeCompra;
	}

	public void setRegistrosDeCompra(ArrayList<Registro> registrosDeCompra) {
		this.registrosDeCompra = registrosDeCompra;
	}
}