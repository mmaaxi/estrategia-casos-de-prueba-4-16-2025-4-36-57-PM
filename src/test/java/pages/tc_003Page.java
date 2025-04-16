package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_003Page {

    WebDriver driver;

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("loginButton");
    By errorMessage = By.id("errorMessage");

    public tc_003Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("http://example.com/login");
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(loginButton).click();
    }

    public void verifyLoginAttemptsRecorded(int attempts) {
        // Logic to verify that the system recorded `attempts` number of login attempts
    }

    public void verifyAccountLockedMessage() {
        String message = driver.findElement(errorMessage).getText();
        assert message.contains("Cuenta bloqueada temporalmente por seguridad");
    }

    public void waitForAccountUnlockTime() {
        // Logic to wait for the configured unlock time
    }

    public void verifyCanAttemptLoginAgain() {
        // Logic to verify that the login attempt is possible again
    }
}