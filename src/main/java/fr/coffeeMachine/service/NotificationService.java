package fr.coffeeMachine.service;

import fr.coffeeMachine.command.Order;

public class NotificationService implements NotificationInt {

	private static final String WITH = " with ";
	private static final String SUGAR_AND_A_STICK = " sugar and a stick";
	private static final String WITH_NO_SUGAR_AND_THEREFORE_NO_STICK = " with no sugar - and therefore no stick";
	private static final String DRINK_MAKER_MAKES_1 = "Drink maker makes 1 ";

	@Override
	public String sendMessage(Order order) {
		Integer sugar = order.getSugar();
		String infoSugarAnd = sugar > 0 ? WITH+sugar+SUGAR_AND_A_STICK :WITH_NO_SUGAR_AND_THEREFORE_NO_STICK;
		String  message = DRINK_MAKER_MAKES_1+order.getType().name+infoSugarAnd;
		return message;
	}

}
