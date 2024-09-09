package sistema;
import sistema.pessoas.Cliente;
import sistema.pessoas.usuarios.*;
import sistema.produtos.*;
import sistema.utilitarios.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Esta classe representa o Mercado em geral.
 * Ela é responsável pela permanencia de todos os itens referentes ao mercadinho.(produtos, usuarios, registros, cupons)
 * @author Lucas, Yasmin, Henrique
 */
public class SistemaMercado {
	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
	private ArrayList<Produto> produtosEmEstoque = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Registro> registrosDeCompra = new ArrayList<>();
	private ArrayList<Registro> registrosDeVenda = new ArrayList<>();
	private ArrayList<Cupom> cupons = new ArrayList<>();

	@JsonIgnore
	public boolean isSemGerente() {
        return listaDeUsuarios.isEmpty();
    }


	public Usuario getUsuarioLogado(String login, String senha) {
		for (Usuario usuario : this.getListaDeUsuarios()) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				 return usuario;
			}
		}
		return null;
	}

	public Cliente buscarCliente(String cpf){
		for(Cliente cliente : this.getClientes()){
			if(cliente.getCpf().equals(cpf)){
				return cliente;
			}
		}
		return null;
	}

	public Produto buscarProdutoPorNome(String nome){
		for (Produto produto : this.getProdutosEmEstoque()){
			if(produto.getNome().equalsIgnoreCase(nome)){
				return produto;
			}
		}
		return null;
	}

	public Produto buscarProdutoPorCodigo(String codigo){
		for (Produto produto : this.getProdutosEmEstoque()){
			if(produto.getCodigo().equals(codigo)){
				return produto;
			}
		}
		return null;
	}

	public Cupom validarCupom(String codigo){
		for(Cupom cupom : this.getCupons()){
			if(cupom.getCodigo().equals(codigo)){
				return cupom;
			}
		}
		return null;
	}

	public BigDecimal calcularTotalDeCompras(){
		BigDecimal total = new BigDecimal("0");
		for (Registro registro : registrosDeCompra){
			total = total.add(registro.getTotal());
		}
		return total;
	}

	public BigDecimal calcularTotalDeVendas(){
		BigDecimal total = new BigDecimal("0");
		for (Registro registro : registrosDeVenda){
			total = total.add(registro.getTotal());
		}
		return total;
	}

	public BigDecimal calcularTotalApurado(){
		return calcularTotalDeVendas().subtract(calcularTotalDeCompras());
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