package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class tc_006Page {

    WebDriver driver;

    public tc_006Page() {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    public void navigateToLoginPage() {
        driver.get("https://application-url.com/login");
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id("loginButton")).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(By.id("logoutButton")).isDisplayed();
    }

    public void navigateToSection(String section) {
        driver.findElement(By.linkText(section)).click();
    }

    public boolean isSectionDisplayed(String section) {
        return driver.findElement(By.tagName("h1")).getText().contains(section);
    }

    public boolean isSessionActive() {
        return isLoggedIn();
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void openBrowser() {
        driver = new ChromeDriver();
    }

    public void navigateToHomePage() {
        driver.get("https://application-url.com");
    }
}