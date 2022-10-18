package br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contracts")
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date contractDate = new Date();
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToOne
	@JoinColumn(name = "property_id")
	private Property property;
	
	private BigDecimal saleValue;

	
	public Contract() {
	}
	public Contract(Client client, Property property, BigDecimal saleValue) {
		this.client = client;
		this.property = property;
		this.saleValue = saleValue;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getContractDate() {
		return contractDate;
	}
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Property getProperty() {
		return property;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
		
	public BigDecimal getSaleValue() {
		return saleValue;
	}
	public void setSaleValue(BigDecimal saleValue) {
		this.saleValue = saleValue;
	}
	@Override
	public int hashCode() {
		return Objects.hash(client, id, property);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contract other = (Contract) obj;
		return Objects.equals(client, other.client)
				&& Objects.equals(id, other.id) && Objects.equals(property, other.property);
	}
	@Override
	public String toString() {
		return "\nID immobile: " + property.getId()+
				"\nAddress: " + property.getAddress()+
				"\nID Client: " + client.getId()+
				"\nClient name: " + client.getName();
		//		"\nContract date: " + this.getContractDate() + "\n";
		
	}
	
	

}
