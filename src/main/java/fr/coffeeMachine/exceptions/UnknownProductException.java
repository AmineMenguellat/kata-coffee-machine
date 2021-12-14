package fr.coffeeMachine.exceptions;

public class UnknownProductException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownProductException() {
		super("##The selected product is unknown");
	}
	
}
