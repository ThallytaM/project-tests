package br.edu.ifpb.dac.thallyta.projectdacbackend.business.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Client;
import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Property;
import br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto.PropertyDTO;

@SpringBootTest
class PropertyServiceTest {
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private ConverterService converterService;
	
	@Autowired
	private static Property p;
	
	
	@BeforeAll
	static void initAll() {
		p = new Property();
		p.setAddress("Rua 1");
		p.setPropertyValue(new BigDecimal(2.200));		
		p.setArea(new BigDecimal(2));
	}	

	@DisplayName("Teste validação de Area")
	@ParameterizedTest
	@ValueSource(strings = {"2.1", "2"})
	void TestValidAreaValue(String valor) {
		p.setArea(new BigDecimal(valor));
		assertDoesNotThrow(()-> propertyService.save(p));
	}
	
	@Test
	@DisplayName("Conversao DTO para Property")
	void conversionTestDtoToProperty() {
		PropertyDTO p = new PropertyDTO();
		
		Property p1 = converterService.dtoToProperty(p);
		
		assertEquals(p.getAddress(), p1.getAddress());
		assertEquals(p.getArea(),p1.getArea());
		assertEquals(p.getPropertyValue(),p1.getPropertyValue());
		assertEquals(Property.class, p1.getClass());
	}
	
	@Test
	@DisplayName("Conversao Property para DTO")
	void conversionTestPropertyToDto() {
		
		PropertyDTO p1 = converterService.propertyToDto(p);
		
		assertEquals(p.getAddress(), p1.getAddress());
		assertEquals(p.getArea(),p1.getArea());
		assertEquals(p.getPropertyValue(),p1.getPropertyValue());
		
		assertEquals(PropertyDTO.class, p1.getClass());
	}
	
	

}
