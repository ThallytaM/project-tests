package br.edu.ifpb.dac.thallyta.projectdacbackend.presentation.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Client;

public class ClientDTO {
	
	private Integer id;
	private String name;
	private String cpf;
	private String telephone;
	private int age;
	
	public ClientDTO() {
		
	}
	
	
	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.telephone = client.getTelephone();
		this.age = client.getAge();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static List<ClientDTO> toConvert(List<Client> clients){
		return clients.stream().map(ClientDTO:: new).collect(Collectors.toList());
	}
}
