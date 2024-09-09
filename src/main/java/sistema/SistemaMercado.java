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
 * Ela é responsável pela permanencia de todos os itens referentes ao mercadinho.
 * Itens que a classe armazena: {@link Produto}, {@link Usuario}, {@link Cliente}, {@link Registro}, {@link Cupom}.
 * @author Lucas, Yasmin, Henrique
 */
public class SistemaMercado {
	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
	private ArrayList<Produto> produtosEmEstoque = new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private ArrayList<Registro> registrosDeCompra = new ArrayList<>();
	private ArrayList<Registro> registrosDeVenda = new ArrayList<>();
	private ArrayList<Cupom> cupons = new ArrayList<>();

	/**
	 *
	 * Ele valida se já foi cadastrado algum cliente.
	 * Leva-se em conta que o Gerente é o primeiro usuário a ser cadastrado, sempre.
	 * @return Retorna true caso o ArrayList listaDeUsuarios estiver vazio (sem usuários)
     */
	@JsonIgnore
	public boolean isSemGerente() {
        return listaDeUsuarios.isEmpty();
    }

	/**
	 * Método utilizado para validar o login de um usuário
	 * @param login em String
	 * @param senha em String
	 * @return retorna o usuário com as credenciais informadas. Caso não encontre, retorna null.
	 */
	public Usuario getUsuarioLogado(String login, String senha) {
		for (Usuario usuario : this.getListaDeUsuarios()) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				 return usuario;
			}
		}
		return null;
	}

	/**
	 *
	 * Método utilizado para buscar os clientes através de seu cpf.
	 * @param cpf em String
	 * @return Caso encontrado, retorna o dono do CPF informado. Caso não, retorna null.
	 */
	public Cliente buscarCliente(String cpf){
		for(Cliente cliente : this.getClientes()){
			if(cliente.getCpf().equals(cpf)){
				return cliente;
			}
		}
		return null;
	}

	/**
	 * Método utilizado para buscar produtos, porém a partir de seu nome.
	 * @param nome em String
	 * @return Caso encontrado, retorna o dono do CPF informado. Caso não, retorna null.
	 */
	public Produto buscarProdutoPorNome(String nome){
		for (Produto produto : this.getProdutosEmEstoque()){
			if(produto.getNome().equalsIgnoreCase(nome)){
				return produto;
			}
		}
		return null;
	}
	/**
	 * Método utilizado para buscar produtos, porém a partir de seu código.
	 * @param codigo em String
	 * @return Caso encontrado, retorna {@link Produto} com o código informado. Caso não, retorna null.
	 */
	public Produto buscarProdutoPorCodigo(String codigo){
		for (Produto produto : this.getProdutosEmEstoque()){
			if(produto.getCodigo().equals(codigo)){
				return produto;
			}
		}
		return null;
	}

	/**
	 * Método utilizado para validar se o código de um cupom é válido
	 * @param codigo - em String
	 * @return retorna {@link Cupom}, caso o código seja válido. Caso não, retorna null
	 */
	public Cupom validarCupom(String codigo){
		for(Cupom cupom : this.getCupons()){
			if(cupom.getCodigo().equals(codigo)){
				return cupom;
			}
		}
		return null;
	}

	/**
	 * O método calcula o total de todos os registros de compras feitas pelo estoque do mercado.
	 * @return retorna um {@link BigDecimal} com o total de compras
	 */
	public BigDecimal calcularTotalDeCompras(){
		BigDecimal total = new BigDecimal("0");
		for (Registro registro : registrosDeCompra){
			total = total.add(registro.getTotal());
		}
		return total;
	}
	/**
	 * O método calcula o total de todos os registros de vendas que o mercado fez
	 * @return retorna um {@link BigDecimal} com o total de vendas
	 */
	public BigDecimal calcularTotalDeVendas(){
		BigDecimal total = new BigDecimal("0");
		for (Registro registro : registrosDeVenda){
			total = total.add(registro.getTotal());
		}
		return total;
	}
	/**
	 * Calcula o balanço mensal, subtraindo o total de compras do total de vendas.
	 * @return retorna um {@link BigDecimal} com o valor total apurado pelo mercado.
	 */
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