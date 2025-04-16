package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_005Page {
    WebDriver driver;

    By usuarioField = By.id("user");
    By passwordField = By.id("pass");
    By loginButton = By.id("login");
    By logoutButton = By.id("logout");
    By protectedPageLink = By.id("protectedPage");

    public tc_005Page(WebDriver driver) {
        this.driver = driver;
    }

    public void iniciarSesion(String usuario, String contraseña) {
        driver.findElement(usuarioField).sendKeys(usuario);
        driver.findElement(passwordField).sendKeys(contraseña);
        driver.findElement(loginButton).click();
    }

    public boolean isUsuarioLogueado() {
        // Implementar lógica para verificar si el usuario está logueado
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void cerrarSesion() {
        driver.findElement(logoutButton).click();
    }

    public boolean isRedirigidoAPaginaInicio() {
        // Implementar lógica para verificar si el usuario está en la página de inicio
        return driver.getCurrentUrl().equals("http://example.com/home");
    }

    public void accederPaginaProtegida() {
        driver.findElement(protectedPageLink).click();
    }

    public boolean isRedirigidoAPaginaInicioSesion() {
        // Implementar lógica para verificar si el usuario está en la página de inicio de sesión
        return driver.getCurrentUrl().equals("http://example.com/login");
    }
}