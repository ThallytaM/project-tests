package br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Contract;


public class ContractDTO {

	private Integer id;
	private Date contractDate = new Date();
	private String clientId;
	private String propertyId;
	private BigDecimal saleValue;

	public ContractDTO() {
	}
	
	public ContractDTO(Contract contract) {
		this.id = contract.getId();
		this.contractDate = contract.getContractDate();
		this.clientId = Integer.toString(contract.getClient().getId());
		this.propertyId = Integer.toString(contract.getProperty().getId());
		this.saleValue = contract.getSaleValue();
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	
	
	public BigDecimal getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(BigDecimal saleValue) {
		this.saleValue = saleValue;
	}

	public static List<ContractDTO> toConvert(List<Contract> contracts){
		return contracts.stream().map(ContractDTO:: new).collect(Collectors.toList());
	}
	
	
}
