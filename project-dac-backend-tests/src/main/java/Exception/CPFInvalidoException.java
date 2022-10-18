package Exception;

@SuppressWarnings("serial")
public class CPFInvalidoException extends Exception {
	
	@Override
	public String getMessage() {
		return "CPF invalido";
	}
}
