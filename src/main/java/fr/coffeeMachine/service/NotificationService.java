package fr.coffeeMachine.service;

import java.text.DecimalFormat;

import fr.coffeeMachine.command.Order;

public class NotificationService implements NotificationInt {

	private static final String WITH = " with ";
	private static final String SUGAR_AND_A_STICK = " sugar and a stick";
	private static final String WITH_NO_SUGAR_AND_THEREFORE_NO_STICK = " with no sugar - and therefore no stick";
	private static final String DRINK_MAKER_MAKES_1 = "Drink maker makes 1 ";

	
	public String sendMessageOK(Order order) {
		Integer sugar = order.getSugar();
		String infoSugarAnd = sugar > 0 ? WITH+sugar+SUGAR_AND_A_STICK :WITH_NO_SUGAR_AND_THEREFORE_NO_STICK;
		String  message = DRINK_MAKER_MAKES_1+order.getType().name+infoSugarAnd;
		return message;
	}

	public String sendMessageKO(Order order, Double price) {
		DecimalFormat df = new DecimalFormat("0.00");
		Double diff = order.getType().price - price;
		return "the "+order.getType().name+" order failed it misses: "+df.format(diff);
	}

	@Override
	public String sendMessage(Order order, Double price, TypeMessage typeMessage) {
		if(TypeMessage.FAIL.equals(typeMessage)) return sendMessageKO(order, price);

		return sendMessageOK(order);
	}


}
