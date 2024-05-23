package projeto.sistema;

import projeto.sistema.pessoas.Cliente;
import projeto.sistema.pessoas.usuarios.*;
import projeto.sistema.produtos.*;
import projeto.sistema.utilitarios.*;
import java.util.ArrayList;

public class SistemaMercado {
	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
	private ArrayList<Produto> produtosEmEstoque = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Registro> registrosDeCompra = new ArrayList<>();
	private ArrayList<Registro> registrosDeVenda = new ArrayList<>();
	private ArrayList<Cupom> cupons = new ArrayList<>();

	public boolean verificarExistenciaDeUsuarios() {
        return listaDeUsuarios.isEmpty();
    }


	public void cadastrarFuncionario(String cargo) throws Exception {
		Formularios formulario = new Formularios();
		Usuario usuario = formulario.pedirDadosFuncionario(cargo);
		getListaDeUsuarios().add(usuario);
	}

	public Usuario getUsuarioLogado(String login, String senha) {
		for (Usuario usuario : this.getListaDeUsuarios()) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				 return usuario;
			}
		}
		return null;
	}

	public Produto buscarProduto(String codigo){
		for (Produto produto : this.getProdutosEmEstoque()){
			if(produto.getCodigo().equals(codigo)){
				return produto;
			}
		}
		return null;
	}

	public ArrayList<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public void setListaDeUsuarios(ArrayList<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	public ArrayList<Produto> getProdutosEmEstoque() {
		return produtosEmEstoque;
	}

	public void setProdutosEmEstoque(ArrayList<Produto> produtosEmEstoque) {
		this.produtosEmEstoque = produtosEmEstoque;
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

	public ArrayList<Cupom> getCupons(){
		return cupons;
	}

	public void setCupons(ArrayList<Cupom> cupons){
		this.cupons = cupons;
	}
}