package sistema.pessoas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import sistema.pessoas.usuarios.CaixaEletronico;
import sistema.pessoas.usuarios.funcionarios.Almoxarife;
import sistema.pessoas.usuarios.funcionarios.Funcionario;
import sistema.pessoas.usuarios.funcionarios.Gerente;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Almoxarife.class),
        @JsonSubTypes.Type(value = Funcionario.class),
        @JsonSubTypes.Type(value = Gerente.class),
        @JsonSubTypes.Type(value = CaixaEletronico.class),
        @JsonSubTypes.Type(value = Funcionario.class)})

public abstract class Pessoa {
    protected String nome;
    protected String email;

    public Pessoa(){

    }
    public Pessoa(String nome){
        this.nome = nome;
    }

    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
