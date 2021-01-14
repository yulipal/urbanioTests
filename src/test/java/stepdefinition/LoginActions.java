package stepdefinition;

import configsdriver.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageobject.LoginPage;

import java.io.IOException;

public class LoginActions extends BaseDriver {

    @Given("I open Urbanio webpage in a new webBrowser")
    public void iOpenUrbanioWebpageInANewWebBrowser() throws IOException {
        driver = newbornWebDriver();
        driver.get("http://localhost:3001/");
    }

    @And("I login with the credentials username (.+) and password (.+) in the login page$")
    public void iLoginWithTheCredentialsUsernameAndPasswordInTheLoginPage(String username,
                                                                          String pass) {
        LoginPage loginPage = new LoginPage(driver);
        waiter.until(ExpectedConditions.elementToBeClickable(loginPage.getInputUsername()));

        loginPage.getInputUsername().sendKeys(username);
        loginPage.getInputPassword().sendKeys(pass);
        loginPage.getButtonSignIn().click();
    }

    @Then("I see the main dashboard as a current user")
    public void iSeeTheMainDashboardAsACurrentUser() {
        System.out.println("helloworld");

    }

    @Then("I see the main dashboard as an admin")
    public void iSeeTheMainDashboardAsAnAdmin() {
    }
}
