package sistema.produtos;
import sistema.SistemaMercado;

import java.math.BigDecimal;

public class Produto {
	private int identificador;
	private String codigo;
	private String nome;
	private int unidade;
	private BigDecimal valorUnitarioDeCompra;
	private BigDecimal valorUnitarioDeVenda;

	public Produto(){
	}

	public Produto(String nome, SistemaMercado sistema) {
		this.nome = nome;
		this.unidade = 0;
		this.valorUnitarioDeCompra = new BigDecimal("0");
		this.valorUnitarioDeVenda = new BigDecimal("0");
		this.identificador = sistema.getProdutosEmEstoque().size() + 1;
		this.setCodigo(this.identificador);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCodigo(int identificador) {
		this.codigo = gerarCodigo(identificador);
	}

	public static String gerarCodigo(int identificador){
		String ID = String.valueOf(identificador);
		String codigo;
		switch (ID.length()) {
			case 1:
				codigo =  "0000" + identificador;
				break;
			case 2:
				codigo = "000" + identificador;
				break;
			case 3:
				codigo = "00" + identificador;
				break;
			case 4:
				codigo = "0" + identificador;
				break;
			default:
				codigo = "" + identificador;
				break;
		}
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getUnidade() {
		return unidade;
	}
		
	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getValorUnitarioDeCompra() {
		return valorUnitarioDeCompra;
	}

	public void setValorUnitarioDeCompra(BigDecimal valorUnitarioDeCompra) {
		this.valorUnitarioDeCompra = valorUnitarioDeCompra;
	}

	public BigDecimal getValorUnitarioDeVenda() {
		return valorUnitarioDeVenda;
	}

	public void setValorUnitarioDeVenda(BigDecimal valorUnitarioDeVenda) {
		this.valorUnitarioDeVenda = valorUnitarioDeVenda;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
