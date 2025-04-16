package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tc_007Page {
    private WebDriver driver;

    private By paginaInicioSesionLocator = By.id("login-page");
    private By mensajeErrorLocator = By.id("error-message");

    public tc_007Page(WebDriver driver) {
        this.driver = driver;
    }

    public void navegarPaginaProtegida() {
        driver.get("https://example.com/protected");
    }

    public boolean esPaginaInicioSesion() {
        return driver.findElement(paginaInicioSesionLocator).isDisplayed();
    }

    public void intentarAccionSinAutenticacion() {
        // Try performing an action that requires authentication
        // This method depends on the application and should be implemented according to its specifics
    }

    public boolean esMensajeDeErrorVisible() {
        return driver.findElement(mensajeErrorLocator).isDisplayed();
    }
}