package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_001Page {

    WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginButton");
    private By welcomeMessage = By.id("welcomeMessage");

    public tc_001Page(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public String getUsernameFieldValue() {
        return driver.findElement(usernameField).getAttribute("value");
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public boolean isPasswordMasked() {
        // Comprobación ficticia; la lógica real debe verificar el atributo de tipo del campo
        return "password".equals(driver.findElement(passwordField).getAttribute("type"));
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isWelcomeMessageDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();
    }
}