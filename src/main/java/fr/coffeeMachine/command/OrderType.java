package fr.coffeeMachine.command;

import fr.coffeeMachine.exceptions.UnknownProductException;

public enum OrderType {
	COFFEE("coffee", "C",0.6,true,true),
	CHOCOLATE("chocolate", "H",0.5,true,true),
	TEA("tea", "T",0.4,true,true),
	ORANGE_JUICE("orange juice","O",0.6,false,false);

	public String code;
	public String name;
	public Double price;
	public Boolean extraHot;
	public Boolean suggar;

	
	private OrderType(String name,String code, Double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}


	private OrderType(String name,String code, Double price, Boolean extraHot,Boolean suggar) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.suggar = suggar;
		this.extraHot = extraHot;
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


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	public Boolean getExtraHot() {
		return extraHot;
	}


	public Boolean getSuggar() {
		return suggar;
	}

	public void setExtraHot(Boolean extraHot) {
		this.extraHot = extraHot;
	}


	public void setSuggar(Boolean suggar) {
		this.suggar = suggar;
	}

}
