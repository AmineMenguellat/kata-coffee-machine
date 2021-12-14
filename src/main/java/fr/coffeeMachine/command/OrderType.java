package fr.coffeeMachine.command;

import fr.coffeeMachine.exceptions.UnknownProductException;

public enum OrderType {
	COFFEE("coffee", "C"), CHOCOLATE("chocolate", "H"), TEA("tea", "T");

	public String code;
	public String name;

	private OrderType(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public static OrderType getOrderTypeByName(String name) {
		for (OrderType currentOrderType : OrderType.values()) {
			if (name.equals(currentOrderType.name))
				return currentOrderType;
		}
		throw new UnknownProductException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
