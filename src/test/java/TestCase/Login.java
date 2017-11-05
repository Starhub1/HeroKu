package TestCase;

import Initialize.ExcelReader;
import Initialize.Init;
import Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends Init {


    @Test(dataProvider = "loginData")
    public void verifyLoginFunctionality(String userName, String password, String expected) throws Exception {
        ExtentTest logger = setLogger("Verify the LoginPage Functionality").assignAuthor("Mohammed Nasir");

        getDriver().get("http://the-internet.herokuapp.com/login");
        LoginPage loginPage = new LoginPage();

        logger.log(LogStatus.INFO,"UserName: " + userName + " Password " + password + "Expected is" + expected);

        loginPage.enterUserName(userName).andPassword(password).andThenLogin();
        Assert.assertEquals(loginPage.isLoginSuccesful(),expected.toLowerCase());

        logger.log(LogStatus.PASS,"Login test Passed");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException, InvalidFormatException {
        return ExcelReader.read("test.xlsx");
    }
}
