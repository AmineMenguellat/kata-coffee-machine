package unit;

import org.junit.Test;

import fr.coffeeMachine.command.Order;
import fr.coffeeMachine.command.OrderType;
import fr.coffeeMachine.service.NotificationInt;
import fr.coffeeMachine.service.NotificationService;
import fr.coffeeMachine.service.TypeMessage;

import static org.junit.Assert.*;

import org.junit.Before;

public class NotificationTest {
	NotificationInt notification;
	
	@Before
	public  void init() {
		notification = new NotificationService();
	}
	
	@Test
	public void message_for_chocolate_and_one_sugar() {
		Order order = new Order(OrderType.CHOCOLATE, 1,1);
		String actualMessage = notification.sendMessage(order,OrderType.CHOCOLATE.price,TypeMessage.SUCCES);
		String expectedMessage = "Drink maker makes 1 chocolate with 1 sugar and a stick";
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void message_for_chocolate_without_sugar() {
		Order order = new Order(OrderType.CHOCOLATE, 0,0);
		String actualMessage = notification.sendMessage(order,OrderType.CHOCOLATE.price,TypeMessage.SUCCES);
		String expectedMessage = "Drink maker makes 1 chocolate with no sugar - and therefore no stick";
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void message_for_coffee_without_sugar() {
		Order order = new Order(OrderType.COFFEE, 0,0);
		String actualMessage = notification.sendMessage(order,OrderType.COFFEE.price,TypeMessage.SUCCES);
		String expectedMessage = "Drink maker makes 1 coffee with no sugar - and therefore no stick";
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void message_for_coffee_and_one_sugar() {
		Order order = new Order(OrderType.COFFEE, 1,1);
		String actualMessage = notification.sendMessage(order,OrderType.COFFEE.price,TypeMessage.SUCCES);
		String expectedMessage = "Drink maker makes 1 coffee with 1 sugar and a stick";
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void message_for_tea_without_sugar() {
		Order order = new Order(OrderType.TEA, 0,0);
		String actualMessage = notification.sendMessage(order,OrderType.TEA.price,TypeMessage.SUCCES);
		String expectedMessage = "Drink maker makes 1 tea with no sugar - and therefore no stick";
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void message_for_tea_and_one_sugar() {
		Order order = new Order(OrderType.TEA, 1,1);
		String actualMessage = notification.sendMessage(order,OrderType.TEA.price,TypeMessage.SUCCES);
		String expectedMessage = "Drink maker makes 1 tea with 1 sugar and a stick";
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void message_ko_for_tea_() {
		Order order = new Order(OrderType.TEA, 1,1);
		String actualMessage = notification.sendMessage(order,0.3d,TypeMessage.FAIL);
		String expectedMessage = "the tea order failed it misses: 0,10";
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void message_ko_for_cofee_() {
		Order order = new Order(OrderType.COFFEE, 1,1);
		String actualMessage = notification.sendMessage(order,0.3d,TypeMessage.FAIL);
		String expectedMessage = "the coffee order failed it misses: 0,30";
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void message_ko_for_chocolate_() {
		Order order = new Order(OrderType.CHOCOLATE, 1,1);
		String actualMessage = notification.sendMessage(order,0.3d,TypeMessage.FAIL);
		String expectedMessage = "the chocolate order failed it misses: 0,20";
		assertEquals(expectedMessage, actualMessage);
	}
}
