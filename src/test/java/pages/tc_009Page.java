package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tc_009Page {
    WebDriver driver;

    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("loginButton");
    By errorMessage = By.id("errorMessage");

    public tc_009Page(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isUsernameValid() {
        // Implement logic to check username validation based on the policy
        return true; // Placeholder implementation
    }

    public boolean isPasswordMasked() {
        WebElement passwordInput = driver.findElement(passwordField);
        String typeAttribute = passwordInput.getAttribute("type");
        return "password".equals(typeAttribute);
    }

    public boolean isLoginErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isLoggedInSuccessfully() {
        // Implement logic to verify successful login
        return false; // Placeholder implementation
    }
}