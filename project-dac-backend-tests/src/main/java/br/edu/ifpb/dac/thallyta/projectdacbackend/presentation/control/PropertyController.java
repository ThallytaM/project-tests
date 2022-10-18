package br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.control;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.thallyta.projectdacbackend.business.service.ConverterService;
import br.edu.ifpb.dac.thallyta.projectdacbackend.business.service.PropertyService;
import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Property;
import br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto.PropertyDTO;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private ConverterService converterService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody PropertyDTO dto){
		try {
			Property entity = converterService.dtoToProperty(dto);
			entity = propertyService.save(entity);
			dto = converterService.propertyToDto(entity);
			
			return new ResponseEntity(dto, HttpStatus.CREATED);
		
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}		
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody PropertyDTO dto) {
		try {
			dto.setId(id);
			Property entity = converterService.dtoToProperty(dto);
			entity = propertyService.update(id,entity);
			dto = converterService.propertyToDto(entity);
			
			return ResponseEntity.ok(dto);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity deleteId(@PathVariable("id") Integer id) {
		try {
			propertyService.deleteId(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity find(
			@RequestParam(value = "id", required = false) Integer id, 
			@RequestParam(value = "address",required = false)String address,
			@RequestParam(value = "area",required = false) BigDecimal area,
			@RequestParam(value = "rentValue",required = false)BigDecimal rentValue){
		
		try {
			Property filter = new Property();
			filter.setId(id);
			filter.setAddress(address);

			List<Property> properties = propertyService.find(filter);
			List<PropertyDTO> dtos = converterService.propertyToDto(properties);

			
			return ResponseEntity.ok(dtos);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());		
		}		
		
	}
}
