package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_004Page {
    WebDriver driver;

    By forgotPasswordLink = By.id("forgot-password-link");
    By emailField = By.id("email");
    By sendButton = By.id("send-button");
    By confirmationMessage = By.id("confirmation-message");

    public tc_004Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://example.com/login");
    }

    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public boolean isOnPasswordRecoveryPage() {
        return driver.getCurrentUrl().equals("https://example.com/recovery");
    }

    public void enterValidEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public boolean isEmailFormatAccepted() {
        String emailValue = driver.findElement(emailField).getAttribute("value");
        return emailValue.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public void clickSendButton() {
        driver.findElement(sendButton).click();
    }

    public boolean isConfirmationMessageDisplayed() {
        return driver.findElement(confirmationMessage).isDisplayed();
    }
}