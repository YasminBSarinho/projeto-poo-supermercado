package projeto.sistema.utilitarios;

public class Registro {
    private String codigo;
    private int unidades;
    private float valor;
    private String data;

    public Registro(){
        
    }
    
    public Registro(String tipo, int unidades, float valor, String data){
        this.codigo = tipo;
        this.unidades = unidades;
        this.valor = valor;
        this.data = data;
    }

    public Registro(float valor, String data){
        this.valor = valor;
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String tipo) {
        this.codigo = tipo;
    }
    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
