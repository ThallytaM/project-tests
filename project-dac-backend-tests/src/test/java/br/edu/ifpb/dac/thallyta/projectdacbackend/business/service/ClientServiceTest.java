package br.edu.ifpb.dac.thallyta.projectdacbackend.business.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import org.junit.jupiter.api.DynamicTest;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Client;
import br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto.ClientDTO;

@SpringBootTest
class ClientServiceTest {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private static Client c;
	
	
	@BeforeAll
	static void initAll() {
		c = new Client();
		c.setName("Thallyta Maria");
		c.setCpf("357.672.271-87");
		c.setTelephone("(83)99821-0724");
		c.setAge(19);
	}
	
	@Test
	@DisplayName("Validacaoo de Idade")
	void testarIdadeValida() throws Exception {
	
		c.setAge(20);
		assertDoesNotThrow(()-> clientService.save(c));
	//	assertThrows(IdadeInvalidaExeption.class,()-> clientService.save(cl));	
	}
	
	@Test
	@DisplayName("Conversao de DTO para Client")
	void testConverterDtoToClient() {
		ClientDTO c = new ClientDTO();		
		Client cl = converterService.dtoToClient(c);
		
		assertEquals(c.getName(), cl.getName());
		assertEquals(c.getTelephone(), cl.getTelephone());
		assertEquals(c.getAge(), cl.getAge());
		assertEquals(c.getCpf(), cl.getCpf());
		
		assertEquals(Client.class, cl.getClass());
	}
	
	@Test
	@DisplayName("Conversao de cliente para DTO")
	void testConverterClientToDto() {
		
		ClientDTO cl = converterService.clientToDto(c);
		
		assertEquals(c.getName(), cl.getName());
		assertEquals(c.getTelephone(), cl.getTelephone());
		assertEquals(c.getAge(), cl.getAge());
		assertEquals(c.getCpf(), cl.getCpf());
		
		assertEquals(ClientDTO.class, cl.getClass());
				
	}
	
	
	@DisplayName("Test CPF Format")
	@ParameterizedTest
	@ValueSource(strings = {"357.672.271-87"}) //"357.672.271-87",  
	void cpfFormat(String cpf) {
		c.setCpf(cpf);
		assertDoesNotThrow(()-> clientService.save(c));
	//	assertThrows(CPFInvalidoException.class,()-> clientService.save(c));
	}

	@TestFactory
	@DisplayName("Teste tamanho do CPF")	
	Stream<DynamicTest> cpfSize() {
		 return Stream.of("357.672.271-87") //, "123", "1234567" "1234345634534234", 
		      	    .map(text -> dynamicTest(text, () -> assertDoesNotThrow(()-> clientService.save(c))));
		
	  //  return Stream.of("24353565461", "123", "1234567", "1234345634534234") //, "123", "1234567" "1234345634534234", 
	 //     	    .map(text -> dynamicTest(text, () -> assertThrows(CPFInvalidoException.class, ()-> clientService.save(c))));
	    }
	
	
	@DisplayName("Teste validacao do Telefone")
	@ParameterizedTest
	@ValueSource(strings = {"(83)99821-0724"}) //"(83)99821-0724","83998210724","98210724", "(83)9 9821-0724", "99821-0724", " "
	void validacaoTelefone(String tel) {
		
		c.setTelephone(tel);
		
		assertDoesNotThrow(()-> clientService.save(c));

		
		//assertThrows(TelefoneInvalidoException.class,()-> clientService.save(c));
		
	}
	
	@DisplayName("Teste validacao do Nome")
	@ParameterizedTest
	@ValueSource(strings = {"Tarcizo Leite"}) //"Tarcizo Leite",
	void validacaoNome(String nome) {	
		
		c.setName(nome);		
		
		assertDoesNotThrow(()-> clientService.save(c));

	//	assertThrows(NomenIvalidoException.class,()-> clientService.save(c));	
	}
}
