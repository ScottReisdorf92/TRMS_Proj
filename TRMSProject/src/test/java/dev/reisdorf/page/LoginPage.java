package dev.reisdorf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(id = "username")
	public WebElement userinput;
	
	@FindBy(id = "password")
	public WebElement passinput;
	
	@FindBy(id = "loginBtn")
	public WebElement loginbtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
