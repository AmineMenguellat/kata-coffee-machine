package acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:target/site/index.htm"},
		features = {"src/test/resources"},
		monochrome = true,
		publish = true
		
		)
public class AllAcceptanceTest {

}
