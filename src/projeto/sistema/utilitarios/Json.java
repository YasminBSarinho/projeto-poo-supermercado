package projeto.sistema.utilitarios;
import java.io.FileReader;
import java.io.FileWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

import projeto.sistema.SistemaMercado;
import projeto.sistema.pessoas.usuarios.funcionarios.Gerente;

public class Json {
    private ObjectMapper conversor;

    public Json(){
        conversor = new ObjectMapper();
        setConversor(conversor);

        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
        .allowIfSubType("projeto.sistema")
        .allowIfSubType("java.util.ArrayList")
        .build();
    getConversor().activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
    }

    public void lerJson(SistemaMercado sistema){
        try {
			FileReader leitor = new FileReader("sistema.json");
			sistema = conversor.readValue(leitor, SistemaMercado.class);
			leitor.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

    }
    public void escreverJson(SistemaMercado sistema){
        try{
            FileWriter escritor = new FileWriter("sistema.json");
            String jsonSistema = conversor.writeValueAsString(sistema);
            escritor.write(jsonSistema);
            escritor.close();
        }catch(Exception error){
            System.out.println(error.getMessage());
        }
            
    }

    public ObjectMapper getConversor() {
        return conversor;
    }

    public void setConversor(ObjectMapper conversor) {
        this.conversor = conversor;
    }
    
}
