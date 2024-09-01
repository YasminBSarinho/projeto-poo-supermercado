package sistema.utilitarios;

import java.math.BigDecimal;

public class Registro {
    private String codigo;
    private int unidades;
    private String nome;
    private BigDecimal valor;
    private String data;
    private BigDecimal total;

    public Registro(){
        
    }
    
    public Registro(String codigo, String nome, int unidades, BigDecimal valor, String data, BigDecimal total){
        this.codigo = codigo;
        this.nome = nome;
        this.unidades = unidades;
        this.valor = valor;
        this.data = data;
        this.total = total;
    }



    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}