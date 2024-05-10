package projeto.sistema.pessoas;

public class Cliente extends Pessoa{
    protected String cpf;
    protected String endereco;

    public Cliente(String nome, String cpf, String endereco){
        super(nome);
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente(String nome, String email, String cpf, String endereco){
        super(nome, email);
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void realizarvenda(){

    }

    public void registrarDataEHora(){}
    
    public void emitirNotaDeVenda(){}


}
