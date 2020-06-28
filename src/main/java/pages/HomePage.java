package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	private By header=By.cssSelector("h1.private-page__title");
	
	public WebElement getheader() {
		return getElement(header);
	}

}
