package sistema.produtos;
import sistema.SistemaMercado;

public class Produto {
	private int identificador;
	private String codigo;
	private String nome;
	private int unidade;
	private float valorUnitarioDeCompra;
	private float valorUnitarioDeVenda;

	public Produto(){
	}

	public Produto(String nome, int unidade, SistemaMercado sistema) {
		this.nome = nome;
		this.unidade = unidade;
		this.identificador = sistema.getProdutosEmEstoque().size() + 1;
		this.setCodigo();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCodigo() {

		String idProduto = String.valueOf(identificador);

		switch (idProduto.length()) {
		case 1:
			this.codigo = "0000" + identificador;
			break;
		case 2:
			this.codigo = "000" + identificador;
			break;
		case 3:
			this.codigo = "00" + identificador;
			break;
		case 4:
			this.codigo = "0" + identificador;
			break;
		default:
			this.codigo = "" + identificador;
			break;
		}
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

	public float getValorUnitarioDeCompra() {
		return valorUnitarioDeCompra;
	}

	public void setValorUnitarioDeCompra(float valorUnitarioDeCompra) {
		this.valorUnitarioDeCompra = valorUnitarioDeCompra;
	}

	public float getValorUnitarioDeVenda() {
		return valorUnitarioDeVenda;
	}

	public void setValorUnitarioDeVenda(float valorUnitarioDeVenda) {
		this.valorUnitarioDeVenda = valorUnitarioDeVenda;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
