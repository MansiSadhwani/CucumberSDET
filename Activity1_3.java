Feature file:


@activity1_3
Feature: Testing with Tags


  @SimpleAlert @SmokeTest
  Scenario: Testing with Simple Alert
    Given User is on the page
		When User clicks the Simple Alert button
		Then Alert opens
		And Read the text from it and print it
		And Close alert
		And Close Browser
    
 @ConfirmAlert
  Scenario: Testing with Confirm Alert
    Given User is on the page
		When User clicks the Confirm Alert button
		Then Alert opens
		And Read the text from it and print it
		And Close the alert
		And Close Browser
    

  @PromptAlert
  Scenario: Testing with Prompt Alert
    Given User is on the page
		When User clicks the Prompt Alert button
		Then Alert opens
		And Read the text from it and print it
		And Write a custom message in it
		And Close the alert
		And Close Browser

 
---------------------------------------------------------------------
Runner file:

package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@PromptAlert",
    plugin = {"html: test-reports"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}

-----------------------------------------------------------------
AlertActivity.java:

package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertActivity 
{

	WebDriver driver;
	Alert alert;
	
	@Given("^User is on the page$")
	public void login()
	{
	driver = new FirefoxDriver();
	driver.get("https://www.training-support.net/selenium/javascript-alerts");
	}
	
	@When("^User clicks the Simple Alert button$")
	public void simpleAlert()
	{
		driver.findElement(By.xpath("//button[@id='simple']")).click();
	}
	@When("^User clicks the Confirm Alert button$")
	public void confirmAlert()
	{
		driver.findElement(By.xpath("//button[@id='confirm']")).click();
	}
	@When("^User clicks the Prompt Alert button$")
	public void promptAlert()
	{
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
	}
	
	@Then("^Alert opens$")
	public void alert()
	{
		alert = driver.switchTo().alert();
	}
	
	@And("^Read the text from it and print it$")
	public void printfromAlert()
	{
		System.out.println(alert.getText());
	}
	
	@And("^Write a custom message in it$")
	public void writetoAlert()
	{
		alert.sendKeys("Cucumber activity");
	}
	
	@And("^Close alert$")
	public void closeAlert()
	{
		alert.accept();
	}
	@And("^Close the alert$")
	public void dismissAlert()
	{
		alert.dismiss();
	}
	@And("^Read the result text$")
	public void getResult()
	{
		driver.findElement(By.cssSelector("p[id=\'result\']"));
	}
	@And("^Close Browser$")
	public void closeBrowser()
	{
		driver.close();
	}
}
