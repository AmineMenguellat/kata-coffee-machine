package fr.coffeeMachine.service;

import fr.coffeeMachine.command.Order;

public interface NotificationInt {
	
	/**
	 * this method is used to generate a notification to the client
	 * @param order
	 * @param price
	 * @param typeMessage
	 * @return
	 */
	public String sendMessage(Order order,Double price,TypeMessage typeMessage);

}
