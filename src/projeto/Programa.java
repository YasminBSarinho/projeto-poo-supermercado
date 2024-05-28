package projeto;

import java.util.Scanner;
import java.io.FileReader;
import projeto.sistema.SistemaMercado;
import com.fasterxml.jackson.databind.ObjectMapper;
import projeto.sistema.telas.JanelaDeCadastro;


import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

public class Programa {
	public static void main(String[] args) {
		ObjectMapper conversor = new ObjectMapper();
		SistemaMercado sistema = new SistemaMercado();
		Scanner scanner = new Scanner(System.in);
		FileReader leitor;

		//tratamento do polimorfismo do json
		PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
				.allowIfSubType("projeto.sistema")
				.allowIfSubType("java.util.ArrayList")
				.build();
		conversor.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);

		// Verifica se existe arquivo json
		try {
			leitor = new FileReader("sistema.json");
			sistema = conversor.readValue(leitor, SistemaMercado.class);
			leitor.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		JanelaDeCadastro janela = new JanelaDeCadastro(sistema);
		scanner.close();
	}
}