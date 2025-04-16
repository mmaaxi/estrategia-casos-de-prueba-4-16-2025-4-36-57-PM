package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.tc_004Page;

public class tc_004Steps {
    tc_004Page page = new tc_004Page();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        page.navigateToLoginPage();
    }

    @When("the user clicks on \"Forgot password\" link")
    public void the_user_clicks_on_forgot_password_link() {
        page.clickForgotPasswordLink();
    }

    @Then("the user is redirected to the password recovery page")
    public void the_user_is_redirected_to_the_password_recovery_page() {
        Assert.assertTrue(page.isOnPasswordRecoveryPage());
    }

    @When("the user enters a valid email")
    public void the_user_enters_a_valid_email() {
        page.enterValidEmail("test@example.com");
    }

    @Then("the system accepts the email format")
    public void the_system_accepts_the_email_format() {
        Assert.assertTrue(page.isEmailFormatAccepted());
    }

    @When("the user clicks on the \"Send\" button")
    public void the_user_clicks_on_the_send_button() {
        page.clickSendButton();
    }

    @Then("a confirmation message is displayed and a recovery email is sent")
    public void a_confirmation_message_is_displayed_and_a_recovery_email_is_sent() {
        Assert.assertTrue(page.isConfirmationMessageDisplayed());
    }
}