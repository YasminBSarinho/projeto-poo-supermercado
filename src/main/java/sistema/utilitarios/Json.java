package sistema.utilitarios;
import java.io.FileReader;
import java.io.FileWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

import sistema.SistemaMercado;

public class Json {
    private ObjectMapper conversor = new ObjectMapper();

    public Json(){
        setConversor(conversor);
    }

    public SistemaMercado lerJson(){
        SistemaMercado sistema;
        try {
			FileReader leitor = new FileReader("sistema.json");
            sistema = conversor.readValue(leitor, SistemaMercado.class);
            leitor.close();
		}
		catch(Exception e){
            sistema = new SistemaMercado();
			System.out.println(e.getMessage());
		}
        return sistema;
    }
    public void escreverJson(SistemaMercado sistema){
        try{
            FileWriter escritor = new FileWriter("sistema.json");
            String jsonSistema = conversor.writerWithDefaultPrettyPrinter().writeValueAsString(sistema);
            escritor.write(jsonSistema);
            escritor.close();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
            
    }

    public ObjectMapper getConversor() {
        return conversor;
    }

    public void setConversor(ObjectMapper conversor) {
        this.conversor = conversor;
    }
    
}
