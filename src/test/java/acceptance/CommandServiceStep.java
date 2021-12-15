package acceptance;

import static org.junit.Assert.*;

import fr.coffeeMachine.command.Order;
import fr.coffeeMachine.service.CommandService;
import fr.coffeeMachine.service.NotificationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommandServiceStep {

	private NotificationService notificationService = new NotificationService();
	private CommandService commandService = new CommandService(notificationService);
	private Order order;

	@Given("The drink maker should receive the correct instructions for my {string} order")
	public void the_drink_maker_should_receive_the_correct_instructions_for_my_order(String command) {
		commandService.choseProduct(command);
	}

	@When("I want to add  {string} sugar to my order")
	public void i_want_to_add_sugar_to_my_order(String sugar) {
		commandService.addSugar(Integer.parseInt(sugar));
	}
	
	@When("I pay my order with the {string}")
	public void i_pay_my_order_with_the(String price) {
		commandService.command(Double.parseDouble(price));
	}

	@Then("my order {string} has been transferred")
	public void my_order_has_been_transferred(String string) {
		order = commandService.getOrder();
		String typeOrder = order.getType().getName();

		assertTrue(string.equals(typeOrder));
	}

	@Then("{string} of sugar added")
	public void of_sugar_added(String sugar) {
		Integer sugarQuantity = order.getSugar();

		assertTrue(Integer.parseInt(sugar) == sugarQuantity);
	}

	@Then("{string} of stick added")
	public void of_stick_added(String stick) {
		Integer stickNumber = order.getStick();
		assertTrue(Integer.parseInt(stick) == stickNumber);
	}

	@Then("the {string} is sent to the beverage manufacturer")
	public void the_is_sent_to_the_beverage_manufacturer(String excpectedMessage) {
		String actualMessage = commandService.getMakerCommand();
		assertEquals(excpectedMessage, actualMessage);
	}

	@Then("the client receives the message {string}")
	public void the_client_receives_the_message(String expectedClientMessage) {
		String actuelClientMessage = commandService.getMessageNotification();
		assertEquals(expectedClientMessage, actuelClientMessage);
	}
}
