package unit;

import org.junit.Test;
import static org.junit.Assert.*;

import fr.coffeeMachine.command.OrderType;
import fr.coffeeMachine.exceptions.UnknownProductException;

public class OrderTypeTest {

	@Test
	public void orderTypeChocolate() {
		assertEquals(OrderType.CHOCOLATE, OrderType.getOrderTypeByName("chocolate"));
	}

	@Test
	public void orderTypeTea() {
		assertEquals(OrderType.TEA, OrderType.getOrderTypeByName("tea"));
	}

	@Test
	public void orderTypeCoffee() {
		assertEquals(OrderType.COFFEE, OrderType.getOrderTypeByName("coffee"));
	}

	@Test(expected = UnknownProductException.class)
	public void unknownProductExceptionTest() {
		OrderType.getOrderTypeByName("unknown");
	}

}
