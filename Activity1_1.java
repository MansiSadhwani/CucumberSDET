Feature file:


@Activity1_1
Feature: First Test


  @tag1
  Scenario: Opening a webpage using Selenium
    Given User is on Google Home Page
     When User types in Cheese and hits ENTER
    Then Show how many search results were shown
    And Close the browser

----------------------------------------------------------------------
Step definition:

package stepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
	@Given("^User is on Google Home Page$")
	public void givenFunctionName() {
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/?gws_rd=ssl");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User types in Cheese and hits ENTER$")
	public void whenFunctionName() {
		driver.findElement(By.cssSelector("input[title=\'Search\']")).sendKeys("Cheese");
		driver.findElement(By.cssSelector("input[title=\'Search\']")).sendKeys(Keys.ENTER);
	}

	@Then("^Show how many search results were shown$")
	public void thenFunctionName() {
		System.out.println(driver.findElement(By.cssSelector("div[id=\'result-stats\']")).getText());
	}
	
	@And("^Close the browser$")
	public void andFunctionName() {
		driver.close();
	}

}
