package br.com.jackson.hooks;

import br.com.jackson.config.Browser;
import br.com.jackson.config.SeleniumDriverConfig;
import br.com.jackson.utils.Utils;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @BeforeAll
    public static void beforeExecutionOpenBrowserAndPutURL() {
        Browser browser = new Browser();
        browser.putURL();
    }

    @After
    public void afterScenarioReturnLoginPage(Scenario scenario) {
        WebDriver driver = SeleniumDriverConfig.Instance().driver;
        Utils utils = new Utils(driver);
        utils.backToLoginPage();
    }

//    @AfterStep
//    public void antesdecadacenario(Scenario scenario){
//        WebDriver driver = SeleniumDriverConfig.Instance().driver;
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//        scenario.attach(src, "image/png", "[" + scenario.getStatus().toString() + "] - "+ scenario.getName());
//    }

    @AfterAll
    public static void afterExecutionCloseBrowser() {
        Browser browser = new Browser();
        browser.closeBrowser();
    }
}
