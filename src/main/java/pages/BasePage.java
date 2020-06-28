package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			elementToBeLocatedBy(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Error in finding element " + e.toString());
		}
		return element;

	}

	@Override
	public void elementToBeLocatedBy(By locator) {
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	catch (Exception e)
	{
		System.out.println("Timeout Occured....  " + e.toString());

	}
}
	
}

