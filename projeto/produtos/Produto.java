package projeto.produtos;

public class Produto {
    private String codigo;
    private String nome;
    private int unidade;
    private float valorUnitarioDeCompra;
    private float valorUnitarioDeVenda;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
