package br.com.jackson.config;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumDriverConfig {

    public final WebDriver driver;
    private static SeleniumDriverConfig _instance;

    public static SeleniumDriverConfig Instance() {
        if (SeleniumDriverConfig._instance == null) {
            SeleniumDriverConfig._instance = new SeleniumDriverConfig();
        }
        return SeleniumDriverConfig._instance;
    }

    private SeleniumDriverConfig() throws NoSuchElementException {
        this.driver = this.createWebDriver();
    }

    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
