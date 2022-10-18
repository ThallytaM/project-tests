package br.edu.ifpb.dac.thallyta.projectdacbackend.business.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import Exception.AreaInvalidaException;
import Exception.CPFInvalidoException;
import Exception.IdadeInvalidaExeption;
import Exception.NomenIvalidoException;
import Exception.TelefoneInvalidoException;
import br.com.caelum.stella.validation.CPFValidator;

@Service
public interface ValidationService {
	
	public static void ageValidation(int age) throws IdadeInvalidaExeption  {
		if(age < 18){
			throw new IdadeInvalidaExeption();
		}

	}
	
	public static void invalidCPFFormat(String cpf) throws CPFInvalidoException {
		CPFValidator cpfValidator = new CPFValidator(); 
	    try{ 
	    	cpfValidator.assertValid(cpf); 
	    
	    }catch(Exception e){ 
	        e.getMessage(); 
	        throw new CPFInvalidoException(); 
	        } 
		
	}
	
	public static void invalidCPFSize(String cpg) throws CPFInvalidoException {
		if(cpg.length() == 11) {
			throw new CPFInvalidoException();
		}
	}
	
	public static void validarTelefone(String s) throws TelefoneInvalidoException {
		
		boolean validar = s.matches("\\([0-9]{2}\\)\\d{5}\\-\\d{4}");
		System.out.println(s + " " + validar);
		if (validar != true) {
			throw new TelefoneInvalidoException();
		}
	}
	
	public static void validarNome(String s) throws NomenIvalidoException {
		
		boolean validar = s.matches("^(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*(?: (?:(?:e|y|de(?:(?: la| las| lo| los))?|do|dos|da|das|del|van|von|bin|le) )?(?:(?:(?:d'|D'|O'|Mc|Mac|al\\-))?(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+|(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*))+(?: (?:Jr\\.|II|III|IV))?$");
		System.out.println(s + " " + validar);
		if (validar != true) {
			throw new NomenIvalidoException();
		}
	}
	
//================================= Validar Property ========================
	
	public static void valdarArea(BigDecimal area) throws AreaInvalidaException {
		BigDecimal a = new BigDecimal(2);
		
		if(area.compareTo(a) == -1) {			
			throw new AreaInvalidaException();
		}
	}

}
