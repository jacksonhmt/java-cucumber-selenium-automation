package br.com.jackson.steps;

import br.com.jackson.config.SeleniumDriverConfig;
import br.com.jackson.pageObject.DashboardPageObject;
import br.com.jackson.pageObject.ProductPageObject;
import br.com.jackson.utils.Utils;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ProductSteps {

    private final WebDriver driver = SeleniumDriverConfig.Instance().driver;
    private final Utils utils = new Utils(driver);
    private final ProductPageObject productPageObject = new ProductPageObject(driver);
    private final DashboardPageObject dashboardPageObject = new DashboardPageObject(driver);

    @When("click on the Product Option")
    public void click_on_the_product_option() throws IOException {
        this.productPageObject.clickOnTheProductButton();
        this.utils.tirarPrintDaPagina();
    }

    @Then("the system directs to the product page")
    public void the_system_directs_to_the_product_page() throws IOException{
        this.productPageObject.itsOnTheProductScreen();
        this.utils.tirarPrintDaPagina();
    }

    @Given("that the user is on the product search page")
    public void that_the_user_is_on_the_product_search_page() throws IOException {
        this.dashboardPageObject.checkDashboardPageIsVibible();
        this.productPageObject.clickOnTheProductButton();
        this.productPageObject.itsOnTheProductScreen();
        this.utils.tirarPrintDaPagina();
    }

    @When("to click on the new product button")
    public void to_click_on_the_new_product_button() throws IOException {
        this.productPageObject.clickOnTheNewProductButton();
        this.utils.tirarPrintDaPagina();
    }

    @When("fill form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void fill_form_with(String productName, String theAmount, String purchasePrice, String salePrice, String productType, String description) throws IOException {
        this.productPageObject.fillAllFields(productName, theAmount, purchasePrice, salePrice, productType);
        this.productPageObject.fillFileField();
        this.productPageObject.fillCKEditorField(description);
        this.utils.tirarPrintDaPagina();
    }
}
