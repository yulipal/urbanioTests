package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement inputUsername;

    public WebElement getInputUsername() {
        return inputUsername;
    }

    @FindBy(id = "password")
    private WebElement inputPassword;

    public WebElement getInputPassword() {
        return inputPassword;
    }

    @FindBy(xpath = "//button[@class='my-4 btn btn-primary']")
    private WebElement buttonSignIn;

    public WebElement getButtonSignIn() {
        return buttonSignIn;
    }

}
