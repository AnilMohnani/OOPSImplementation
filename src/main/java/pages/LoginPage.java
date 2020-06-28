package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private By username = By.id("username");
	private By password = By.id("password");
	private By lgnBtn=By.id("loginBtn");

	public WebElement getUsername() {

		return getElement(username);

	}

	public WebElement getPassword() {
		return getElement(password);
	}
	public WebElement getloginBtn()
	{
		return getElement(lgnBtn);
	}
	
	public String getTitle()
	{
		return getPageTitle();
	}
	public void doLogin(String username, String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getloginBtn().click();
		
	}
	
	}


