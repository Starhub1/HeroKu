package TestCase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Initialize.ExcelReader;
import Initialize.Init;
import Pages.LoginPage;

public class Login extends Init {

	@Test(dataProvider = "loginData")
	public void verifyLoginFunctionality(String userName, String password, String expected) throws Exception {
		System.out.println("Test - The thread id is" + Thread.currentThread().getId());
		ExtentTest logger = setLogger("Verify the LoginPage Functionality").assignAuthor("Mohammed Nasir");

		getDriver().get("http://the-internet.herokuapp.com/login");
		LoginPage loginPage = new LoginPage(getDriver());

		logger.log(Status.INFO, "UserName: " + userName + " Password " + password + "Expected is" + expected);

		loginPage.enterUserName(userName).andPassword(password).andThenLogin();
		Assert.assertEquals(loginPage.isLoginSuccesful(), expected.toLowerCase());

		logger.log(Status.PASS, "Login test Passed");
	}

	@DataProvider(name = "loginData", parallel = true)
	public Object[][] loginData() throws IOException, InvalidFormatException {
		return ExcelReader.read("test.xlsx");
	}
}
