package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.tc_005Page;

import static org.junit.Assert.assertTrue;

public class tc_005Steps {
    WebDriver driver;
    tc_005Page page;

    @Given("el usuario ha iniciado sesión con credenciales válidas")
    public void el_usuario_ha_iniciado_sesion_con_credenciales_validas() {
        driver = new ChromeDriver();
        page = new tc_005Page(driver);
        page.iniciarSesion("usuario", "contraseña");
        assertTrue(page.isUsuarioLogueado());
    }

    @When("hace clic en el botón 'Cerrar sesión'")
    public void hace_clic_en_el_boton_cerrar_sesion() {
        page.cerrarSesion();
    }

    @Then("el usuario debe ser redirigido a la página de inicio")
    public void el_usuario_debe_ser_redirigido_a_la_pagina_de_inicio() {
        assertTrue(page.isRedirigidoAPaginaInicio());
        driver.quit();
    }

    @Given("el usuario no ha iniciado sesión")
    public void el_usuario_no_ha_iniciado_sesion() {
        driver = new ChromeDriver();
        page = new tc_005Page(driver);
    }

    @When("intenta acceder a una página protegida")
    public void intenta_acceder_a_una_pagina_protegida() {
        page.accederPaginaProtegida();
    }

    @Then("el sistema debe redirigir al usuario a la página de inicio de sesión")
    public void el_sistema_debe_redirigir_al_usuario_a_la_pagina_de_inicio_de_sesion() {
        assertTrue(page.isRedirigidoAPaginaInicioSesion());
        driver.quit();
    }
}