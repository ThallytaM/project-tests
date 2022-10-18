package br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Property;


public class PropertyDTO {
	
	private Integer id;
	private String address;
	private BigDecimal area;
	private BigDecimal propertyValue;
	
	public PropertyDTO() {
	}

	public PropertyDTO(Property property) {
		this.id = property.getId();
		this.address = property.getAddress();
		this.area = property.getArea();
		this.propertyValue = property.getPropertyValue();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}


	public BigDecimal getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(BigDecimal propertyValue) {
		this.propertyValue = propertyValue;
	}

	public static List<PropertyDTO> toConvert(List<Property> properties){
		return properties.stream().map(PropertyDTO:: new).collect(Collectors.toList());
	}
	
	
	
	

}
