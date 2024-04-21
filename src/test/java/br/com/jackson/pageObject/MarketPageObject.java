package br.com.jackson.pageObject;

import br.com.jackson.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketPageObject {

    private final Utils utils;
    private final By marketButtonId = By.id("menuMercado");
    private final By marketTitleXpath = By.xpath("//h4[contains(text(),\"Mercado\")]");
    private final By productSearchFieldId = By.id("pesquisar_produto");

    public MarketPageObject(WebDriver driver) {
        this.utils = new Utils(driver);
    }

    public void clickOnTheMarketButton(){
        this.utils.waitForElementPresent(this.marketButtonId);
        this.utils.click(this.marketButtonId);
    }

    public void itsOnTheMarketScreen(){
        this.utils.waitForTextPresentInElement(this.marketTitleXpath, "Mercado");
    }

    public void toFillInTheProductSearchField(String productName){
        this.utils.waitForElementPresent(this.productSearchFieldId);
        this.utils.fillField(this.productSearchFieldId, productName);
    }

    public void checkReturnedProduct(String productName){
        String productXpath = "//h5[contains(text(),\"" + productName + "\")]";
        By returnedProductXpath = By.xpath(productXpath);

        this.utils.waitForTextPresentInElement(returnedProductXpath, productName);
    }
}
