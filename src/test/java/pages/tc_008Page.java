package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_008Page {

    WebDriver driver;

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By submitButton = By.id("loginButton");
    By usernameErrorMessage = By.id("usernameError");
    By passwordErrorMessage = By.id("passwordError");

    public tc_008Page(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("https://example.com/login");
    }

    public void clearUsernameField() {
        driver.findElement(usernameField).clear();
    }

    public void clearPasswordField() {
        driver.findElement(passwordField).clear();
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isUsernameErrorMessageDisplayed() {
        return driver.findElement(usernameErrorMessage).isDisplayed();
    }

    public boolean isPasswordErrorMessageDisplayed() {
        return driver.findElement(passwordErrorMessage).isDisplayed();
    }
}