package br.edu.ifpb.dac.thallyta.projectdacbackend.business.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Contract;
import br.edu.ifpb.dac.thallyta.projectdacbackend.model.repository.ContractRepository;

 

@Service
public class ContractService {
	
	@Autowired
	private ContractRepository contractRepository;
	
	public Contract save(Contract contract){	
		return contractRepository.save(contract);
	}
	
	public Contract update(Integer id, Contract contract) {
		Contract contractUp = findById(id);
		contractUp.setClient(contract.getClient());
		contractUp.setContractDate(contract.getContractDate());
		contractUp.setProperty(contract.getProperty());
		return contractRepository.save(contractUp);
	}

	public List<Contract> find(Contract filter){
		
		Example<Contract> example = Example.of(filter,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		
		return contractRepository.findAll(example);
		
	}
	
	public void deleteId(Integer id) {
		Contract contractUp = findById(id);
		contractRepository.deleteById(id);
		
	}
	
	public Contract findById(Integer id) {
		return contractRepository.findById(id).get();
	}

}
