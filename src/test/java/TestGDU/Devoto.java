package TestGDU;

import UI.Devoto.DevotoHomePage;
import UI.Devoto.DevotoLandingPage;
import UI.Devoto.DevotoLoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import java.util.concurrent.TimeUnit;

public class Devoto extends BaseTest{

    @BeforeClass
    public void inicializarUrlDevoto(){
        driver.get("https://www.devoto.com.uy/");
    }

    @BeforeMethod
    public void AutenticacionDevoto()  {
        //Page 1 Pagina para seleccionar Dpto Landing
        DevotoLandingPage devotoLandingPage=new DevotoLandingPage(driver);
        devotoLandingPage.sucursal();
        DevotoHomePage devotoHomePage=devotoLandingPage.clickOnButton();
        //Page 2   Home
        devotoHomePage.clickBtnID("btnMiPerfil");
        DevotoLoginPage devotoLoginPage=devotoHomePage.clickOnMiCuenta();
        //Page 3   Login
        devotoLoginPage.clickBtnID("loginWithUserAndPasswordBtn");
        devotoLoginPage.fillingRegistration();
        devotoLoginPage.clickBtnID("classicLoginBtn");

    }
    @Test
    public void ComprarDevoto() {

        driver.navigate().to("https://www.devoto.com.uy/frescos/frutas-y-verduras");
        //driver.findElement(By.xpath("//a[@class='d-none d-md-block']")).click();
        //driver.findElement(By.xpath("//*[@href='/frescos/frutas-y-verduras']")).click();
        int cantBanana;
        for (cantBanana=0; cantBanana < 49; cantBanana++){
            driver.findElement(By.xpath("//*[@class='Multiplier-button js-btn-mas listing'][2]")).click();
        }
        driver.findElement(By.xpath("//*[@class='Button js-btn-agregar listing']"))  .click();
        driver.findElement(By.id("btnMiniCart")).click();
        driver.findElement(By.id("btn-finalizar-compra")).click();
        driver.findElement(By.id("cart-to-orderform")).click();
        Faker faker_data = new Faker();
        String nombre = faker_data.name().firstName();
        String apellido = faker_data.name().lastName();
        //String direccion = faker_data.address().streetAddress();
        //String nropuerta = faker_data.address().buildingNumber();
        //String nropuiso = faker_data.address().streetAddressNumber();
        driver.findElement(By.id("client-first-name")).sendKeys(nombre);
        driver.findElement(By.id("client-last-name")).sendKeys(apellido);
        driver.findElement(By.id("client-document")).sendKeys("61732624");
        driver.findElement(By.id("client-phone")).sendKeys("095421236");
        driver.findElement(By.xpath("//*[@class='submit btn btn-large btn-success']")).click();
        driver.findElement(By.xpath("//button[@class='btn js-cerrar-mensaje-bolsas']")).click();
        driver.findElement(By.className("pac-target-input")).sendKeys("Avenida Doctor Francisco Soca 1318, entre Charrúa, 11300 Montevideo");
    }
}