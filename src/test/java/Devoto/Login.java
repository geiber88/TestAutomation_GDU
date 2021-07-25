package Devoto;

import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class Login {

    WebDriver driver;

    //Método que devuelve un objeto de tipo WebDriver para e instanciar el ChromeDriver y setear las property donde está el driver y acceder a la Web deDisco//
    private WebDriver InicializarWebDisco(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get(url);
        return driver;
    }

    //Método que permite seleccionar la Sucursal//
    @BeforeClass
    public void Autenticacion() throws InterruptedException {
        driver= InicializarWebDisco("https://www.devoto.com.uy/");
        driver.manage().window().maximize();
        WebElement Sucursal = driver.findElement(By.id("selec-suc-popup"));
        Select SucursalSeleccionada = new Select(Sucursal);
        sleep(2000);
        SucursalSeleccionada.selectByValue("3");
        sleep(2000);
        driver.findElement(By.id("btnConfirmaSucursal")).click();


        driver.findElement(By.id("btnMiPerfil")).click();
        driver.findElement(By.className("perfil-desktop")).click();
        driver.findElement(By.xpath("//*[@href='/_secure/account']")).click();
        sleep(4000);
        driver.findElement(By.id("loginWithUserAndPasswordBtn")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
        driver.findElement(By.id("classicLoginBtn")).click();
        sleep(2000);


    }
    @Test
    public void Comprar() throws InterruptedException {

        Faker faker_data = new Faker();
        String nombre = faker_data.name().firstName();
        String apellido = faker_data.name().lastName();
        //String direccion = faker_data.address().streetAddress();
        //String nropuerta = faker_data.address().buildingNumber();
        //String nropuiso = faker_data.address().streetAddressNumber();

        driver.findElement(By.xpath("//*[@class='fas fa-chevron-down']")).click();
        driver.findElement(By.xpath("//*[@href='/frescos/frutas-y-verduras']")).click();
        int cantBanana;
        for (cantBanana=0; cantBanana < 4; cantBanana++){
            driver.findElement(By.xpath("//*[@class='Multiplier-button js-btn-mas listing']")).click();
        }
        driver.findElement(By.xpath("//*[@class='Button js-btn-agregar listing']"))  .click();
        driver.findElement(By.id("btnMiniCart")).click();
        sleep(2000);
        driver.findElement(By.id("btn-finalizar-compra")).click();
        sleep(2000);
        driver.findElement(By.id("cart-to-orderform")).click();
        driver.findElement(By.id("client-pre-email")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("btn-client-pre-email")).click();
        driver.findElement(By.id("client-first-name")).sendKeys(nombre);
        driver.findElement(By.id("client-last-name")).sendKeys(apellido);
        driver.findElement(By.id("client-document")).sendKeys("61732624");
        driver.findElement(By.id("client-phone")).sendKeys("095421236");
        sleep(2000);
        driver.findElement(By.xpath("//*[@class='submit btn btn-large btn-success']")).click();
        /*driver.findElement(By.xpath("//*[@class='go-to-shipping']")).click();
        driver.findElement(By.xpath("//*[@class='shp-method-option-text']")).click();
        driver.findElement(By.xpath()).sendKeys("Avenida Doctor Francisco Soca 1318, entre Charrúa, 11300 Montevideo");
        driver.findElement(By.id("ship-number")).sendKeys("1318");
        driver.findElement(By.id("ship-complement")).sendKeys("1507");
        */
    }
}
