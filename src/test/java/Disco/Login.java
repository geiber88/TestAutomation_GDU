package Disco;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        driver= InicializarWebDisco("https://www.disco.com.uy/");
        driver.manage().window().maximize();
        WebElement Sucursal = driver.findElement(By.id("selec-suc-popup"));
        Select SucursalSeleccionada = new Select(Sucursal);
        sleep(2000);
        SucursalSeleccionada.selectByValue("5");
        sleep(2000);
        driver.findElement(By.id("btnConfirmaSucursal")).click();
        driver.findElement(By.id("btnMiPerfil")).click();
        driver.findElement(By.className("perfil-desktop")).click();
        //driver.findElement(By.id("MiPerfil")).click();
        driver.findElement(By.xpath("//*[@href='/_secure/account']")).click();
        sleep(10000);
        driver.findElement(By.id("loginWithUserAndPasswordBtn")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
        driver.findElement(By.id("classicLoginBtn")).click();
        sleep(2000);
    }
    @Test
    public void Comprar() {
        driver.findElement(By.xpath("//*[@class='fas fa-chevron-down']")).click();
    }
}