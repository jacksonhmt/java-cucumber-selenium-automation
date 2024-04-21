package br.com.jackson.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Utils {

    private final WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By element) {
        this.driver.findElement(element).click();
    }

    public void waitForElementPresent(By element) {
        WebDriverWait esperarElemento = new WebDriverWait(this.driver, Duration.ofSeconds(60));
        esperarElemento.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForTextPresentInElement(By element, String text) {
        WebDriverWait waitElement = new WebDriverWait(this.driver, Duration.ofSeconds(60));
        waitElement.until(ExpectedConditions.textToBePresentInElement(driver.findElement(element), text));
    }

    public void fillField(By element, String value) {
        this.driver.findElement(element).sendKeys(value);
    }

    public void backToLoginPage() {
        this.driver.get("https://www.jacksonteixeira.com/plataforma/");
    }

    public void insertImageFileInField(By element, String imageFilePath){
        this.driver.findElement(element).sendKeys(imageFilePath);
    }

    public void insertValueInCKEditorField(By element, String value){
        WebElement iframe = driver.findElement(element).findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement tinymce = driver.findElement(By.tagName("body"));
        tinymce.clear();
        tinymce.sendKeys(value);
    }

    public void tirarPrintDaPagina() throws IOException {
        File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment("Visualizar Print", FileUtils.openInputStream(screenshotAs));
    }
}
