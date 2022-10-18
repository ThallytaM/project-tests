package Exception;

@SuppressWarnings("serial")
public class AreaInvalidaException extends Exception {
	
	@Override
	public String getMessage() {
		return "Area invalida";
	}
}
