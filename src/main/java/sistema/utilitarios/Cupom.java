package sistema.utilitarios;

import java.math.BigDecimal;

public class Cupom {
    private String codigo;
    private BigDecimal desconto;
    
    public Cupom(){
        
    }

    public Cupom(String codigo, BigDecimal desconto){
        this.setCodigo(codigo);
        this.setDesconto(desconto);
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public BigDecimal getDesconto(){
        return desconto;
    }

    public void setDesconto(BigDecimal desconto){
        this.desconto = desconto;
    }
}
