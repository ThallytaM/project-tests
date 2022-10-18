package br.edu.ifpb.dac.thallyta.projectdacbackend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.thallyta.projectdacbackend.model.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer>  {

}
