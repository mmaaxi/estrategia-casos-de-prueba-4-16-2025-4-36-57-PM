package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.tc_002Page;

public class tc_002Steps {
    WebDriver driver;
    tc_002Page page = PageFactory.initElements(driver, tc_002Page.class);

    @Given("el usuario está en la página de inicio de sesión")
    public void elUsuarioEstaEnLaPaginaDeInicioSesion() {
        page.navigateToLoginPage();
    }

    @When("el usuario ingresa el nombre de usuario {string}")
    public void elUsuarioIngresaElNombreDeUsuario(String username) {
        page.enterUsername(username);
    }

    @When("el usuario ingresa la contraseña {string}")
    public void elUsuarioIngresaLaContrasena(String password) {
        page.enterPassword(password);
    }

    @When("el usuario hace clic en el botón {string}")
    public void elUsuarioHaceClicEnElBoton(String buttonLabel) {
        page.clickLoginButton(buttonLabel);
    }

    @Then("se muestra un mensaje de error indicando {string}")
    public void seMuestraUnMensajeErrorIndicando(String errorMessage) {
        Assert.assertTrue(page.isErrorMessageDisplayed(errorMessage));
    }
}