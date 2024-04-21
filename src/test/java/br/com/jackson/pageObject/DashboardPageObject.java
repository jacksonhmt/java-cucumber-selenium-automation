package br.com.jackson.pageObject;


import br.com.jackson.utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject {

    private final Utils utils;
    private final WebDriver driver;
    private final By viewProductId = By.id("buttonVisualizarProdutos");

    public DashboardPageObject(WebDriver driver) {
        this.utils = new Utils(driver);
        this.driver = driver;
    }

    public void checkDashboardPageIsVibible() {
        String url = "https://jacksonteixeira.com/plataforma/painel";
        if (this.driver.getCurrentUrl().equals(url)) {
            Assert.assertTrue(true);
        }
    }

    public void clickOnTheViewProductButton() {
        this.utils.waitForElementPresent(this.viewProductId);
        this.utils.click(this.viewProductId);
    }
}
