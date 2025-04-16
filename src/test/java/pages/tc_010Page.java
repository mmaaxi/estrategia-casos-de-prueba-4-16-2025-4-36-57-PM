package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class tc_010Page {
    WebDriver driver;

    // Locate web elements for username and password fields, and error messages
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(id = "usernameError")
    WebElement usernameError;

    @FindBy(id = "passwordError")
    WebElement passwordError;

    public tc_010Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        // Navigate to the login page
        driver.get("http://example.com/login");
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isUsernameErrorDisplayed() {
        return usernameError.isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }

    public boolean isUserAuthenticated() {
        // Implement logic to verify if user is authenticated successfully
        // For example, checking if a certain element that only appears when authenticated is visible
        // This is a placeholder, assuming a method isAuthenticationSuccessful exists
        return true;
    }
}