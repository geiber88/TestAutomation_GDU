package TestGDU;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class Disco extends BaseTest {


    @BeforeClass
    public void inicializarUrlDisco(){
        driver.get("https://www.disco.com.uy/");
    }

    @BeforeMethod
    public void AutenticacionDisco()  {
        WebElement Sucursal = driver.findElement(By.id("selec-suc-popup"));
        Select SucursalSeleccionada = new Select(Sucursal);
        SucursalSeleccionada.selectByValue("5");
        driver.findElement(By.id("btnConfirmaSucursal")).click();
        driver.findElement(By.id("btnMiPerfil")).click();
        driver.findElement(By.className("perfil-desktop")).click();
        driver.navigate().to("https://www.disco.com.uy/login");
        //driver.findElement(By.id("MiPerfil")).click();
        //driver.findElement(By.xpath("//*[@href='/_secure/account']")).click();
        //driver.findElement(By.className("perfil-desktop")).click();
        driver.findElement(By.id("loginWithUserAndPasswordBtn")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
        driver.findElement(By.id("classicLoginBtn")).click();
        //sleep(2000);
    }
    @Test
    public void ComprarDisco() {
       // driver.findElement(By.xpath("//*[@class='fas fa-chevron-down']")).click();
    }
}