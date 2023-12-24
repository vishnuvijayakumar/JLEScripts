package GeneralFunctions;


import StepDefinitions.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = Hooks.getDriver();  // Use the driver instance from Hooks
    }


    /**
     * To launch the web page accessing url from config
     */
    public void launchWebPage() {
        Properties props = null;
        try {
            props = new PropertyManager().getProps();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // driver = new ChromeDriver();
        driver.get(props.getProperty("URL"));
        driver.manage().window().maximize();
    }

    /**
     * Get the locator and retun corresponding web element
     * @param by element locator
     * @return web element located using the locator
     */
    public WebElement getElement(By by) {
        waitForElement(by);
        return driver.findElement(by);
    }

    /**
     * Wait for element until its present or timeout
     * @param by xpath of element that needs to be waited for
     * @param waitInSeconds Time out till which wait needs to be done
     */
    public void waitForElement(By by, int waitInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSeconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail("Failed waiting for element located by " + by);
        }
    }

    /**
     * Wait for element with a defined time out of 120 seconds
     * @param by Xpath of element to be waited for
     */
    public void waitForElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail("Failed waiting for element located by " + by);
        }
    }

    /**
     * Actions to send backspace
     * @param numberofTimes times the backspace to be pressed
     */
    public void useActionsToPressBackSpace(int numberofTimes) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        for (int i = 0; i < numberofTimes; i++) {
            actions.sendKeys(Keys.BACK_SPACE).perform();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Scroll using Javascript
     * @param by xpath of element for which scroll to be done
     */
    public void scrollToElementJS(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(by));
    }

    /**
     * Pass a string with double quotes at the start and end. Get the quotes trimmed.
     * @param input String to be trimmed
     * @return String after trimming
     */
    public String trimQuotes(String input) {
        // Check if the input has at least two characters (for the first and last double quotes)
        if (input.length() >= 2 && input.startsWith("\"") && input.endsWith("\"")) {
            // Trim the first and last double quotes
            return input.substring(1, input.length() - 1);
        } else {
            // Input doesn't have the expected format, return as is
            return input;
        }
    }

    /**
     * Hover over the element using actions
     * @param by xpath of element to be hovered over
     */
    public void hoverOverElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(getElement(by)).perform();
    }

}
