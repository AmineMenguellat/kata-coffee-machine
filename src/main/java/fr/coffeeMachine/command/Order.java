package fr.coffeeMachine.command;

public class Order {

	private OrderType type;
	private Integer sugar = 0;
	private Integer stick = 0;
	public Order(OrderType type) {
		super();
		this.type = type;
	}
	
	public Order() {
	}
	

	public Order(OrderType type, Integer sugar) {
		super();
		this.type = type;
		this.sugar = sugar;
	}
	
	public Order(OrderType type, Integer sugar, Integer stick) {
		super();
		this.type = type;
		this.sugar = sugar;
		this.stick = stick;
	}

	public Integer getSugar() {
		return sugar;
	}

	public Integer getStick() {
		return stick;
	}

	public void setSugar(Integer sugar) {
		this.sugar = sugar;
	}

	public void setStick(Integer stick) {
		this.stick = stick;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}
	
}
