package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pages.tc_007Page;
import static org.junit.Assert.assertTrue;

public class tc_007Steps {
    private WebDriver driver;
    private WebDriverWait wait;
    private tc_007Page page;

    public tc_007Steps() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, 10);
        this.page = new tc_007Page(driver);
    }

    @Given("^un usuario anónimo$")
    public void usuarioAnonimo() {
        // No action needed as user is implicitly anonymous
    }

    @When("^el usuario ingresa la URL de una página protegida$")
    public void ingresarURLPaginaProtegida() {
        page.navegarPaginaProtegida();
    }

    @Then("^el sistema redirige al usuario a la página de inicio de sesión$")
    public void verificarRedireccionAPaginaDeInicioDeSesion() {
        assertTrue("No fue redirigido a la página de inicio de sesión", page.esPaginaInicioSesion());
    }

    @Given("^un usuario en la página protegida, pero no autenticado$")
    public void usuarioPaginaProtegidaNoAutenticado() {
        page.navegarPaginaProtegida();
    }

    @When("^el usuario intenta realizar una acción en la página$")
    public void intentarRealizarAccion() {
        page.intentarAccionSinAutenticacion();
    }

    @Then("^el sistema muestra un mensaje de error y no permite la acción$")
    public void verificarMensajeDeErrorYNoPermitirAccion() {
        assertTrue("No se mostró el mensaje de error o se permitió la acción", page.esMensajeDeErrorVisible());
    }
}