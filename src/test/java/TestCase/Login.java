package TestCase;

import static Pages.LoginLocator.btnLogin;
import static Pages.LoginLocator.header;
import static Pages.LoginLocator.txtInvalidMsg;
import static Pages.LoginLocator.txtPassword;
import static Pages.LoginLocator.txtUsername;
import static Pages.LoginLocator.txtValidMsg;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginLocator;
import iniitialize.Init;

public class Login extends Init {
	
	LoginLocator loginpage;
	String username, password, expected;
	
	@org.testng.annotations.Factory(dataProvider="login")
	public  Login(String username, String password, String expected) {
		this.expected =expected;
		this.password=password;
		this.username=username;
	}
	
	@BeforeMethod(firstTimeOnly=true)
	public void navigatetoURL() {
		logger = report.startTest("THis is login to test with positive and negative scenarios","testLogin");
		driver.get("http://the-internet.herokuapp.com/login");
		loginpage = new LoginLocator(driver);
		
	}
	@Test()
	public void testLogin() {
		
		assertEquals(header.getText(),"Login Page");
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();
		if(expected.equalsIgnoreCase("fail")) {
			assertTrue(txtInvalidMsg.getText().contains("Your username is invalid!"));
		}
		else
			assertTrue(txtValidMsg.getText().contains("You logged into a secure area!"));
		
	}
	
	@Parameters({"sUserName","sPassword"})
	@Test
	public void testLoginusingParameter(String susername,String spassword) {
		assertEquals(header.getText(),"Login Page");
		txtUsername.sendKeys(susername);
		txtPassword.sendKeys(spassword);
		btnLogin.click();
		
	}

@DataProvider(name ="login",parallel=true)
public static Object[][] dataforLogin() {
	return new Object[][]{
		{"test","test","fail"},
		{"tomsmith","SuperSecretPassword!","pass"}
		
	};
	
}


}
