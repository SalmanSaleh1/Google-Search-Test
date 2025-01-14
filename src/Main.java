import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // Set up WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com/");

        // Locate the search box
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter search term
        searchBox.sendKeys("Salman");

        // Wait for the suggestions to load and dismiss them by clicking outside
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK"))); // Ensure the button is present

        // Re-locate the submit button to ensure it is clickable
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));

        // Click the submit button
        submitButton.click();

        // Wait for the next page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search"))); // Wait for search results

        // Pause for 3 seconds
        try {
            Thread.sleep(3000); // Sleep for 3000 milliseconds (3 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
