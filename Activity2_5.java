Feature file:

@activity2_5
Feature: Login Test


  @tag2
  Scenario Outline: Title of your scenario outline
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation message
    And Close the Browser

    Examples: 
      | Usernames | Passwords |
      | admin     | password  |
      | user      | password  |
-------------------------------------------------------------------------
Runner file:

package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = {"@activity2_5"},
    strict = true
)

public class ActivitiesRunner {
    //empty
}

---------------------------------------------------------------------
LoginTestSteps.java:

package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {
	
	WebDriver driver;
	
	@Given("^User is on Login page$")
	public void login()
	{
	driver = new FirefoxDriver();
	driver.get("https://www.training-support.net/selenium/login-form");
	}
	@When("^User enters username and password$")
	public void enterCredentials()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class='ui button']")).click();
	}
	@Then("^Read the page title and confirmation message$")
	public void checkTitle()
	{
		System.out.println(driver.getTitle());
		//System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Login Form')]")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
	}
	@And("^Close the Browser$")
	public void logout()
	{
		driver.close();
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void enterCredentials(String username, String password)
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='ui button']")).click();
	}
}
