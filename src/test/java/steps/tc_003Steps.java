package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.*;

import pages.tc_003Page;

public class tc_003Steps {

    WebDriver driver;
    tc_003Page loginPage;

    public tc_003Steps() {
        this.driver = Hooks.getDriver();
        loginPage = PageFactory.initElements(driver, tc_003Page.class);
    }

    @Given("el usuario está en la página de inicio de sesión")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesion() {
        loginPage.navigateToLoginPage();
    }

    @When("el usuario ingresa credenciales incorrectas tres veces consecutivas")
    public void elUsuarioIngresaCredencialesIncorrectasTresVecesConsecutivas() {
        for (int i = 0; i < 3; i++) {
            loginPage.enterCredentials("incorrectUser", "incorrectPassword");
            loginPage.submitLogin();
        }
    }

    @Then("el sistema registra cada intento fallido")
    public void elSistemaRegistraCadaIntentoFallido() {
        loginPage.verifyLoginAttemptsRecorded(3);
    }

    @When("el usuario intenta iniciar sesión con la misma cuenta")
    public void elUsuarioIntentaIniciarSesionConLaMismaCuenta() {
        loginPage.enterCredentials("incorrectUser", "incorrectPassword");
        loginPage.submitLogin();
    }

    @Then("se muestra mensaje de error 'Cuenta bloqueada temporalmente por seguridad'")
    public void seMuestraMensajeDeErrorCuentaBloqueada() {
        loginPage.verifyAccountLockedMessage();
    }

    @When("el usuario espera el tiempo configurado para desbloqueo")
    public void elUsuarioEsperaElTiempoConfiguradoParaDesbloqueo() {
        loginPage.waitForAccountUnlockTime();
    }

    @Then("el sistema permite intentar iniciar sesión nuevamente")
    public void elSistemaPermiteIntentarIniciarSesionNuevamente() {
        loginPage.verifyCanAttemptLoginAgain();
    }
}