package Exception;

@SuppressWarnings("serial")
public class TelefoneInvalidoException extends Exception {
	@Override
	public String getMessage() {
		return "Idade invalida";
	}

}
