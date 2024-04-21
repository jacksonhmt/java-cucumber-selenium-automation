package br.com.jackson.steps;

import br.com.jackson.config.SeleniumDriverConfig;
import br.com.jackson.pageObject.DashboardPageObject;
import br.com.jackson.pageObject.LoginPageObject;
import br.com.jackson.utils.Utils;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginSteps {

    private final WebDriver driver = SeleniumDriverConfig.Instance().driver;
    private final Utils utils = new Utils(driver);
    LoginPageObject loginPageObject = new LoginPageObject(driver);
    DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);

    @Given("that the user is login page")
    public void i_am_on_the_login_page() throws IOException {
        this.loginPageObject.verifyLoginPageVisible();
        this.utils.tirarPrintDaPagina();
    }

    @When("that the user fill in the login data with {string} and {string}")
    public void filling_with_and(String email, String password) throws IOException {
        this.loginPageObject.fillEmail(email);
        this.loginPageObject.fillPassword(password);
        this.utils.tirarPrintDaPagina();
    }

    @When("to click the enter button")
    public void click_the_enter_button() throws IOException {
        this.loginPageObject.clickEnterButton();
        this.utils.tirarPrintDaPagina();
    }

    @Then("the system directs to the dashboard")
    public void the_system_directs_you_to_the_home_pages() throws IOException {
        this.dashboardPageObject.checkDashboardPageIsVibible();
        this.utils.tirarPrintDaPagina();
    }

    @Then("the system display the message {string}")
    public void the_system_display_the_message(String errorMessage) throws IOException {
        this.loginPageObject.verifyLoginInvalidMessage(errorMessage);
        this.utils.tirarPrintDaPagina();
    }

    @When("that the user does not fill in the required field")
    public void not_filling_the_required_field() throws IOException {
        this.loginPageObject.clickOnTheFieldToSeeTheRequiredFieldMessage();
        this.utils.tirarPrintDaPagina();
    }

    @Then("the system displays the message {string} and {string}")
    public void the_system_displays_the_message_and(String emailErrorMessage, String passwordErrorMessage) throws IOException  {
        this.loginPageObject.checkLoginRequiredMessage(emailErrorMessage, passwordErrorMessage);
        this.utils.tirarPrintDaPagina();
    }
}
