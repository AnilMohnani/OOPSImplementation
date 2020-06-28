package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() throws InterruptedException {
		p.getInstance(LoginPage.class).doLogin("ak2058546@gmail.com", "Anil6746");
		String expected = p.getInstance(HomePage.class).getheader().getText();
		Assert.assertEquals("Sales Dashboard", expected);
	}
}
