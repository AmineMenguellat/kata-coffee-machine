package fr.coffeeMachine.command;

import fr.coffeeMachine.exceptions.UnknownProductException;

public enum OrderType {
	COFFEE("coffee", "C",0.6), CHOCOLATE("chocolate", "H",0.5), TEA("tea", "T",0.4);

	public String code;
	public String name;
	public Double price;

	
	private OrderType(String name,String code, Double price) {
		this.code = code;
		this.name = name;
		this.price = price;
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
