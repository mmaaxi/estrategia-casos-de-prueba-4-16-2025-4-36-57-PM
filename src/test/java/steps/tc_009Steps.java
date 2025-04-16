package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.tc_009Page;
import static org.junit.Assert.*;

public class tc_009Steps {
    WebDriver driver;
    tc_009Page loginPage;

    @Given("el usuario está en la página de login")
    public void el_usuario_esta_en_la_pagina_de_login() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");
        loginPage = new tc_009Page(driver);
    }

    @When("ingresa caracteres especiales en el campo de nombre de usuario")
    public void ingresa_caracteres_especiales_en_el_campo_de_nombre_de_usuario() {
        loginPage.enterUsername("!@#$%^&*()");
    }

    @Then("el sistema debe aceptar o rechazar caracteres especiales según la política de validación")
    public void el_sistema_debe_aceptar_o_rechazar_caracteres_especiales_segun_la_politica_de_validacion() {
        assertTrue(loginPage.isUsernameValid());
    }

    @When("ingresa caracteres especiales en el campo de contraseña")
    public void ingresa_caracteres_especiales_en_el_campo_de_contraseña() {
        loginPage.enterPassword("!@#$%^&*()");
    }

    @Then("el campo debe aceptar la entrada y enmascarar los caracteres ingresados")
    public void el_campo_debe_aceptar_la_entrada_y_enmascarar_los_caracteres_ingresados() {
        assertTrue(loginPage.isPasswordMasked());
    }

    @When("el usuario hace clic en 'Iniciar sesión'")
    public void el_usuario_hace_clic_en_iniciar_sesion() {
        loginPage.clickLoginButton();
    }

    @Then("el sistema muestra un mensaje de error en caso de formato inválido o acepta la autenticación si es correcto")
    public void el_sistema_muestra_un_mensaje_de_error_en_caso_de_formato_invalido_o_acepta_la_autenticacion_si_es_correcto() {
        assertTrue(loginPage.isLoginErrorMessageDisplayed() || loginPage.isLoggedInSuccessfully());
        driver.quit();
    }
}