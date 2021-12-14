package fr.coffeeMachine.service;

public interface CommandServiceInt {
	
	/**
	 * this method is used to choose a product 
	 * @param commandType
	 */
	void choseProduct(String commandType);
	
	/**
	 * this method is used to add sugar to my order  
	 * @param sugarQuantity
	 */
	void addSugar(Integer sugarQuantity);
	
	/**
	 * this method is used to confirm my order
	 * and notify the customer that his order is taken into account
	 */
	void command();

}
