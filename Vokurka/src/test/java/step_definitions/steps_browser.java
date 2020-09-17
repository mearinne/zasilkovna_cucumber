package step_definitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class steps_browser {

    WebDriver driver = new ChromeDriver();

    @Given("Open browser Chrome")
    public void openning(){
        driver.get("https://www.seznam.cz");
    }

    @Then("^Write out this word \"([^\"]*)\"$")
    public void writeOut(String val){
        System.out.println("-------- "+val);
    }


}
