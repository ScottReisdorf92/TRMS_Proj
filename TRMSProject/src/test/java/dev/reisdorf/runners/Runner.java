package dev.reisdorf.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dev.reisdorf.page.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "dev.reisdorf.steps")
public class Runner {
	
	public static WebDriver driver;
	public static LoginPage loginpage;
	
	@BeforeClass
	public static void setUp() {
		File file = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver = new FirefoxDriver();
		loginpage = new LoginPage(driver);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
