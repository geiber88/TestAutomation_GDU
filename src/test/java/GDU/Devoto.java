package GDU;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import java.util.concurrent.TimeUnit;

public class Devoto {

    WebDriver driver;
    @BeforeTest
    public void setup1(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void inicializarUrlDevoto(){
        driver.get("https://www.devoto.com.uy/");
    }

    @BeforeMethod
    public void AutenticacionDevoto()  {
        WebElement Sucursal = driver.findElement(By.id("selec-suc-popup"));
        Select SucursalSeleccionada = new Select(Sucursal);
        SucursalSeleccionada.selectByValue("3");
        driver.findElement(By.id("btnConfirmaSucursal")).click();
        driver.findElement(By.id("btnMiPerfil")).click();
        driver.findElement(By.className("perfil-desktop")).click();
        driver.navigate().to("https://www.devoto.com.uy/login");
        //driver.findElement(By.xpath("//*[@href='/_secure/account']")).click();
        driver.findElement(By.id("loginWithUserAndPasswordBtn")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
        driver.findElement(By.id("classicLoginBtn")).click();

    }
    @Test
    public void ComprarDevoto() {

        driver.navigate().to("https://www.devoto.com.uy/frescos/frutas-y-verduras");
        //driver.findElement(By.xpath("//a[@class='d-none d-md-block']")).click();
        //driver.findElement(By.xpath("//*[@href='/frescos/frutas-y-verduras']")).click();
        int cantBanana;
        for (cantBanana=0; cantBanana < 49; cantBanana++){
            driver.findElement(By.xpath("//*[@class='Multiplier-button js-btn-mas listing']")).click();
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
        // driver.findElement(By.className("btn js-cerrar-mensaje-bolsas")).click();
        //driver.findElement(By.xpath("//*[@class='shp-method-option-text']")).click();
        driver.findElement(By.className("pac-target-input")).sendKeys("Avenida Doctor Francisco Soca 1318, entre Charrúa, 11300 Montevideo");
    }
}