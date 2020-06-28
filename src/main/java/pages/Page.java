package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	public WebDriver driver;
	WebDriverWait wait;
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(this.driver,15);
	}
	
	public abstract String getPageTitle();
	public abstract WebElement getElement(By locator);
	public abstract void elementToBeLocatedBy(By locator);
	public <TPage extends BasePage> TPage getInstance(Class<TPage> page)
	{
		try {
			return page.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			return null;

		}
	}
}
