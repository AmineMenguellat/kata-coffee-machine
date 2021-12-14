package unit;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import fr.coffeeMachine.command.Order;
import fr.coffeeMachine.command.OrderType;
import fr.coffeeMachine.service.CommandService;

public class CommandServiceTest {

	private CommandService commandService;

	@Before
	public void init() {
		commandService = new CommandService();
	}
	
	@Test
	public void chocolate_without_Sugar() {
		getOrder("chocolate", 0);
		Order order = commandService.getOrder();
		Integer actualSugar = order.getSugar();
		Integer actualStick = order.getStick();
		checkEquals(actualSugar, 0, actualStick, 0);
	}

	
	@Test
	public void chocolate_with_OneSugar() {
		getOrder("chocolate", 1);
		Order order = commandService.getOrder();
		Integer actualSugar = order.getSugar();
		Integer actualStick = order.getStick();
		checkEquals(actualSugar, 1, actualStick, 1);

	}
	
	@Test
	public void chocolate_with_TwoSugar() {
		getOrder("chocolate", 2);
		Order order = commandService.getOrder();
		Integer actualSugar = order.getSugar();
		Integer actualStick = order.getStick();
		checkEquals(actualSugar, 2, actualStick, 1);

	}
	
	private void checkEquals(Integer actuelSugar,Integer expectedSugar, Integer actualStick,Integer expectedStick) {
		assertTrue(expectedSugar == actuelSugar);
		assertTrue(expectedStick == actualStick);
	}
	
	private void getOrder(String type,Integer nbSugar) {
		commandService.choseProduct(type);
		commandService.addSugar(nbSugar);
	}
	
	@Test
	public void convertToMakerCommand_tea_one_sugar() {
		String expectedMessage = "T:1:0";
		Order order = new Order(OrderType.TEA, 1);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_tea_Zero_sugar() {
		String expectedMessage = "T::";
		Order order = new Order(OrderType.TEA, 0);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_tea_Two_sugar() {
		String expectedMessage = "T:2:0";
		Order order = new Order(OrderType.TEA, 2);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_coffee_one_sugar() {
		String expectedMessage = "C:1:0";
		Order order = new Order(OrderType.COFFEE, 1);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_coffee_Zero_sugar() {
		String expectedMessage = "C::";
		Order order = new Order(OrderType.COFFEE, 0);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_coffee_Two_sugar() {
		String expectedMessage = "C:2:0";
		Order order = new Order(OrderType.COFFEE, 2);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_chocolate_one_sugar() {
		String expectedMessage = "H:1:0";
		Order order = new Order(OrderType.CHOCOLATE, 1);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_chocolate_zero_sugar() {
		String expectedMessage = "H::";
		Order order = new Order(OrderType.CHOCOLATE, 0);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void convertToMakerCommand_chocolate_two_sugar() {
		String expectedMessage = "H:2:0";
		Order order = new Order(OrderType.CHOCOLATE, 2);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}
}
