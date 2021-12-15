package fr.coffeeMachine.service;

import fr.coffeeMachine.command.Order;
import fr.coffeeMachine.command.OrderType;

public class CommandService implements CommandServiceInt {

	private Order order;
	private String makerCommand= "";
	private NotificationInt notificationInt;
	private String messageNotification;

	public CommandService(NotificationInt notificationInt) {
		super();
		this.notificationInt = notificationInt;
	}

	public CommandService() {
		super();
	}

	@Override
	public void addSugar(Integer sugarQuantity) {
		if (sugarQuantity == 0)
			return;
		order.setSugar(sugarQuantity);
		order.setStick(1);

	}

	public Order getOrder() {
		return this.order;
	}

	@Override
	public void choseProduct(String commandType) {
		OrderType orderTypeByName = OrderType.getOrderTypeByName(commandType);
		if (orderTypeByName == null) return;
		order = new Order(orderTypeByName);
	}

	@Override
	public void command(Double price) {
		Boolean orderAuthorized = priceCheck(order.getType(), price);
		if(!orderAuthorized) {
			messageNotification = notificationInt.sendMessage(order,price,TypeMessage.FAIL);
			return;
		}
		
		makerCommand = convertToMakerCommand(order);
		messageNotification = notificationInt.sendMessage(order,price,TypeMessage.SUCCES);
	}

	public String getMakerCommand() {
		return this.makerCommand;
	}
	
	/**
	 * 
	 * @param order
	 * @return message to be sent to the manufacturer
	 */
	public String convertToMakerCommand(Order order) {
		String infoStick = order.getSugar() > 0 ? "0" : "";
		String infoSugar = order.getSugar() > 0 ? order.getSugar().toString() : "";
		return order.getType().code + ":" + infoSugar + ":" + infoStick;
	}


	public String getMessageNotification() {
		return messageNotification;
	}

	public void setMakerCommand(String makerCommand) {
		this.makerCommand = makerCommand;
	}

	public void setMessageNotification(String messageNotification) {
		this.messageNotification = messageNotification;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public Boolean priceCheck(OrderType orderType, Double price) {
		return price >= orderType.price;
	}

	public NotificationInt getNotificationInt() {
		return notificationInt;
	}

	public void setNotificationInt(NotificationInt notificationInt) {
		this.notificationInt = notificationInt;
	}
}
