package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.tc_001Page;

public class tc_001Steps {
    
    WebDriver driver;
    tc_001Page page = new tc_001Page(driver);

    @Given("El usuario está en la página de inicio de sesión")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesion() {
        driver.get("http://url_de_tu_aplicacion.com/login");
    }

    @When("El usuario ingresa el nombre de usuario válido {string}")
    public void elUsuarioIngresaElNombreDeUsuario(String username) {
        page.enterUsername(username);
        Assert.assertEquals(username, page.getUsernameFieldValue());
    }

    @And("El usuario ingresa la contraseña válida {string}")
    public void elUsuarioIngresaLaContrasena(String password) {
        page.enterPassword(password);
        // Asumiendo que la contraseña se enmascara
        Assert.assertTrue(page.isPasswordMasked());
    }

    @And("El usuario hace clic en el botón 'Iniciar sesión'")
    public void elUsuarioHaceClicEnElBotonIniciarSesion() {
        page.clickLoginButton();
    }

    @Then("El usuario es redirigido a la página principal")
    public void elUsuarioEsRedirigidoALaPaginaPrincipal() {
        Assert.assertEquals("http://url_de_tu_aplicacion.com/home", driver.getCurrentUrl());
    }

    @And("Se muestra un mensaje de bienvenida")
    public void seMuestraUnMensajeDeBienvenida() {
        Assert.assertTrue(page.isWelcomeMessageDisplayed());
    }
}