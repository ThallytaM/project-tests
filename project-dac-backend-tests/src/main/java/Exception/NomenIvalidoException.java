package Exception;

@SuppressWarnings("serial")
public class NomenIvalidoException extends Exception {
	
	@Override
	public String getMessage() {
		return "Nome invalido";
	}
}
