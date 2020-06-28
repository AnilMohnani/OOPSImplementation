package testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITest;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.Page;

public class BaseTest {

	protected WebDriver driver;
	public Page p;

	@Parameters(value = { "browser" })
	@BeforeMethod
	public void setup(String browserName) {
		if (browserName.contains("chrome")) {
			//to suppress warnings of timeouts
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
					WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.contains("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get("https://app.hubspot.com/login");
		p = new BasePage(driver);
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		try {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Anil\\OOPsImplementationFramework\\screenshots\\" + result.getName() +".png");
		
			FileHandler.copy(src,dest);
			System.out.println("Middle");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
		
		

}
