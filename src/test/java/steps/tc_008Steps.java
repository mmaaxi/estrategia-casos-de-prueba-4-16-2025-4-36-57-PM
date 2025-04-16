package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.tc_008Page;

public class tc_008Steps {

    WebDriver driver = new ChromeDriver();
    tc_008Page loginPage = new tc_008Page(driver);

    @Given("el usuario está en la página de inicio de sesión")
    public void usuarioEnPaginaLogin() {
        loginPage.openLoginPage();
    }

    @When("deja el campo de nombre de usuario vacío y envía el formulario")
    public void dejaUsuarioVacioYEnviaFormulario() {
        loginPage.clearUsernameField();
        loginPage.submitForm();
    }

    @Then("el sistema muestra un mensaje de error solicitando el ingreso del nombre de usuario")
    public void verificaMensajeErrorNombreUsuario() {
        Assert.assertTrue(loginPage.isUsernameErrorMessageDisplayed());
    }

    @When("deja el campo de contraseña vacío y envía el formulario")
    public void dejaContrasenaVaciaYEnviaFormulario() {
        loginPage.clearPasswordField();
        loginPage.submitForm();
    }

    @Then("el sistema muestra un mensaje de error solicitando el ingreso de la contraseña")
    public void verificaMensajeErrorContrasena() {
        Assert.assertTrue(loginPage.isPasswordErrorMessageDisplayed());
    }
}