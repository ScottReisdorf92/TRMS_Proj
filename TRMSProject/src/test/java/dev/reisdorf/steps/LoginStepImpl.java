package dev.reisdorf.steps;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.reisdorf.page.LoginPage;
import dev.reisdorf.runners.Runner;

public class LoginStepImpl {

	public static LoginPage loginpage = Runner.loginpage;
	public static WebDriver driver = Runner.driver;
	
	@Given("^The user input username and password$")
	public void the_user_input_username_and_password() throws Throwable {
	    driver.get("http://localhost:8080/TRMSProject/");
	}

	@When("^The user types \"([^\"]*)\" and \"([^\"]*)\" and clicks login button$")
	public void the_user_types_and_and_clicks_login_button(String arg1, String arg2) throws Throwable {
		loginpage.userinput.sendKeys(arg1);
		loginpage.passinput.sendKeys(arg2);
		loginpage.loginbtn.click();
	}

	@Then("^The title of the page should be \"([^\"]*)\"$")
	public void the_title_of_the_page_should_be(String arg1) throws Throwable {
	    Assert.assertEquals(arg1, driver.getTitle());
	}
}
