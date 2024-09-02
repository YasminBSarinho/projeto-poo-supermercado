package sistema.utilitarios;

import javax.swing.JTextField;

public class CampoPersonalizado extends JTextField {
    private Tipos tipo;
    private int tamanho;

    public CampoPersonalizado(Tipos tipo){
        this.tipo = tipo;
        this.tamanho = -1;
    }
    public CampoPersonalizado(Tipos tipo, int tamanho){
        this.tipo = tipo;
        this.tamanho = tamanho;
    }
    public Tipos getTipo() {
        return tipo;
    }
    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
