package br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String address;
	private BigDecimal area;
	private BigDecimal propertyValue;
	
	public Property() {
		
	}

	public Property(String address, BigDecimal area, BigDecimal propertyValue) {
		this.address = address;
		this.area = area;
		this.propertyValue = propertyValue;
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

	@Override
	public int hashCode() {
		return Objects.hash(address, area, id, propertyValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Objects.equals(address, other.address) && Objects.equals(area, other.area)
				&& Objects.equals(id, other.id) && Objects.equals(propertyValue, other.propertyValue);
	}
	
	
	
	
	

}
