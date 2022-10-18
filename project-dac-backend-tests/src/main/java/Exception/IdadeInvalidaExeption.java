package Exception;



@SuppressWarnings("serial")
public class IdadeInvalidaExeption extends Exception {

	@Override
	public String getMessage() {
		return "Idade invalida";
	}
}
