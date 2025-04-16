package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.tc_010Page;
import static org.junit.Assert.*;

public class tc_010Steps {
    WebDriver driver;
    tc_010Page loginPage;

    public void setUp() {
        // Initialize the WebDriver and page objects
        // This is a placeholder for WebDriver setup, e.g., using Selenium WebDriver
        loginPage = PageFactory.initElements(driver, tc_010Page.class);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Navigate to the login page
        loginPage.navigateToLoginPage();
    }

    @When("the user enters incorrect information into both fields")
    public void the_user_enters_incorrect_information_into_both_fields() {
        // Input incorrect user credentials
        loginPage.enterUsername("incorrectUser");
        loginPage.enterPassword("incorrectPass");
        loginPage.clickLoginButton();
    }

    @Then("the system shows error messages for both fields")
    public void the_system_shows_error_messages_for_both_fields() {
        // Verify error messages are displayed
        assertTrue(loginPage.isUsernameErrorDisplayed());
        assertTrue(loginPage.isPasswordErrorDisplayed());
    }

    @When("the user corrects the information and clicks 'Log In'")
    public void the_user_corrects_the_information_and_clicks_Log_In() {
        // Correct the user credentials
        loginPage.enterUsername("correctUser");
        loginPage.enterPassword("correctPass");
        loginPage.clickLoginButton();
    }

    @Then("the error messages disappear and the authentication proceeds")
    public void the_error_messages_disappear_and_the_authentication_proceeds() {
        // Verify error messages are not displayed and authentication is successful
        assertFalse(loginPage.isUsernameErrorDisplayed());
        assertFalse(loginPage.isPasswordErrorDisplayed());
        assertTrue(loginPage.isUserAuthenticated());
    }
}