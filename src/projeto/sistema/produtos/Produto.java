package projeto.sistema.produtos;

public class Produto {
	private static int quantiaDeInstancias = 0;
	private String codigo;
	private String nome;
	private int unidade;
	private float valorUnitarioDeCompra;
	private float valorUnitarioDeVenda;

	public Produto() {
		quantiaDeInstancias += 1;
		this.setCodigo();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCodigo() {

		String idProduto = String.valueOf(Produto.quantiaDeInstancias);

		switch (idProduto.length()) {
		case 1:
			this.codigo = "0000" + Produto.quantiaDeInstancias;
			break;
		case 2:
			this.codigo = "000" + Produto.quantiaDeInstancias;
			break;
		case 3:
			this.codigo = "00" + Produto.quantiaDeInstancias;
			break;
		case 4:
			this.codigo = "0" + Produto.quantiaDeInstancias;
			break;
		default:
			this.codigo = "" + Produto.quantiaDeInstancias;
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

}
