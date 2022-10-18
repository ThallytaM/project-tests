package br.edu.ifpb.dac.thallyta.projectdacbackend.business.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Client;
import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Contract;
import br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto.ClientDTO;
import br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto.ContractDTO;

class ContractServiceTest {
	
	@Autowired
	private ContractService contractService;

	@Autowired
	private ConverterService converterService;
	
	
	
	@Test
	@DisplayName("Conversao de cliente para DTO")
	void testConverterContractToDto() {
		Contract c = new Contract(); 
		
		
		
		ContractDTO cl = converterService.contractToDto(c);
		
				
	}
	
	

}
