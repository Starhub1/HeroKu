package Pages;

import Initialize.Init;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() throws Exception {
        PageFactory.initElements(Init.getDriver(),this);
    }

    @FindBy(id = "username")
    private WebElement txtUserName;

    @FindBy(id="password")
    private WebElement txtPassword;

    @FindBy(tagName = "button")
    private  WebElement btnLogin;

    @FindBy(css = "h2")
    private WebElement header;

    public LoginPage enterUserName(String user) {
        txtUserName.sendKeys(user);
        return this;
    }

    public LoginPage andPassword(String pwd) {
        txtPassword.sendKeys(pwd);
        return this;
    }

    public void andThenLogin(){
        btnLogin.click();
    }

    public String isLoginSuccesful(){
        if (header.getText().equals("Secure Area"))
            return "true";
        else
            return "false";
    }

}
