package sistema.utilitarios;

public class Cupom {
    private String codigo;
    private float desconto;
    
    public Cupom(){
        
    }

    public Cupom(String codigo, float desconto){
        this.setCodigo(codigo);
        this.setDesconto(desconto);
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public float getDesconto(){
        return desconto;
    }

    public void setDesconto(float desconto){
        this.desconto = desconto;
    }
}
