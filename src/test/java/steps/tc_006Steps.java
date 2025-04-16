package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.tc_006Page;

public class tc_006Steps {
    tc_006Page page = new tc_006Page();

    @Given("the user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        page.navigateToLoginPage();
        page.enterCredentials("validUser", "validPassword");
        page.clickLoginButton();
        Assert.assertTrue(page.isLoggedIn());
    }

    @When("the user navigates through multiple sections of the application")
    public void user_navigates_through_sections() {
        page.navigateToSection("Dashboard");
        Assert.assertTrue(page.isSectionDisplayed("Dashboard"));
        page.navigateToSection("Profile");
        Assert.assertTrue(page.isSectionDisplayed("Profile"));
    }

    @Then("the session remains active during navigation")
    public void session_remains_active_during_navigation() {
        Assert.assertTrue(page.isSessionActive());
    }

    @When("the user closes and opens the browser without logging out")
    public void user_closes_and_opens_browser() {
        page.closeBrowser();
        page.openBrowser();
        page.navigateToHomePage();
    }

    @Then("the session persists and the user is still authenticated")
    public void session_persists_when_browser_reopened() {
        Assert.assertTrue(page.isLoggedIn());
    }
}