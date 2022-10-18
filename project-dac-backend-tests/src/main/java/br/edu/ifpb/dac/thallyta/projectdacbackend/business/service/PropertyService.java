package br.edu.ifpb.dac.thallyta.projectdacbackend.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import Exception.AreaInvalidaException;
import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Property;
import br.edu.ifpb.dac.thallyta.projectdacbackend.model.repository.PropertyRepository;


@Service
public class PropertyService {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	public Property save(Property property) throws AreaInvalidaException {
		ValidationService.valdarArea(property.getArea());
		return propertyRepository.save(property);
	}
	
	public Property update(Integer id,Property property) {
		Property propertyUp = findById(id);
		propertyUp.setAddress(property.getAddress());
		propertyUp.setArea(property.getArea());
		propertyUp.setPropertyValue(property.getPropertyValue());
		return propertyRepository.save(property);
	}
	
	
	public void deleteId(Integer id) {
		Property propertyUp = findById(id);
		propertyRepository.deleteById(id);
	}
	
	public void deleteAll() {
		propertyRepository.deleteAll();
	}

	public Property findById(Integer id) {
		if(id == null)			
			throw new IllegalStateException();
		return propertyRepository.findById(id).get();
	}

	public List<Property> find(Property filter) {
		
		Example<Property> example = Example.of(filter,
				ExampleMatcher.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		
		return propertyRepository.findAll(example);
	}
	

}
