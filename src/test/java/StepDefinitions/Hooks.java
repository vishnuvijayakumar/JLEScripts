package StepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;


    @Before
    public void beforeScenario() {
        // Initialize the WebDriver only if it hasn't been initialized yet
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    @After
    public void afterScenario() {
        // Close the browser after each scenario
        if (driver != null) {
            try {
                Thread.sleep(3000); //so as to see the execution
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.quit();
            driver = null;  // Reset the driver instance after quitting
        }
    }

    // Getter method to access the WebDriver instance from other classes
    public static WebDriver getDriver() {
        return driver;
    }
}
