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
	public void convertToMakerCommand_an_extra_hot_tea_two_sugar() {
		String expectedMessage = "Th:2:0";
		Order order = new Order(OrderType.TEA, 2,true);
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
	public void convertToMakerCommand_an_extra_hot_coffee_two_sugar() {
		String expectedMessage = "Ch:2:0";
		Order order = new Order(OrderType.COFFEE, 2,true);
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
	
	@Test
	public void convertToMakerCommand_an_extra_hot_chocolate_two_sugar() {
		String expectedMessage = "Hh:2:0";
		Order order = new Order(OrderType.CHOCOLATE, 2,true);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void convertToMakerCommand_orange_juice() {
		String expectedMessage = "O::";
		Order order = new Order(OrderType.ORANGE_JUICE);
		String actualMessage = commandService.convertToMakerCommand(order);
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void priceCheck_chocolate_lower_price () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.CHOCOLATE,0.4);
		assertEquals(false, orderAuthorized);
	}
	
	@Test
	public void priceCheck_chocolate_exact_price () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.CHOCOLATE,0.5);
		assertEquals(true, orderAuthorized);
	}
	@Test
	public void priceCheck_chocolate_higher_price  () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.CHOCOLATE,0.8);
		assertEquals(true, orderAuthorized);
	}
	@Test
	public void priceCheck_coffee_lower_price () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.COFFEE,0.5);
		assertEquals(false, orderAuthorized);
	}
	
	@Test
	public void priceCheck_coffee_exact_price () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.COFFEE,0.6);
		assertEquals(true, orderAuthorized);
	}
	@Test
	public void priceCheck_cofee_higher_price  () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.COFFEE,0.8);
		assertEquals(true, orderAuthorized);
	}
	
	@Test
	public void priceCheck_tea_lower_price () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.TEA,0.3);
		assertEquals(false, orderAuthorized);
	}
	
	@Test
	public void priceCheck_tea_exact_price () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.TEA,0.4);
		assertEquals(true, orderAuthorized);
	}
	@Test
	public void priceCheck_tea_higher_price  () {
		Boolean orderAuthorized =  commandService.priceCheck(OrderType.TEA,0.6);
		assertEquals(true, orderAuthorized);
	}
	
}
