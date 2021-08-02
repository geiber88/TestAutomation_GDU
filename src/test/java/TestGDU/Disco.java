package TestGDU;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class Disco extends BaseTest {


    @BeforeClass
    public void inicializar_Url_Disco(){
        driver.get("https://www.disco.com.uy/");
    }

    @BeforeMethod
    public void Autenticacion_Disco()  {
        WebElement Sucursal = driver.findElement(By.id("selec-suc-popup"));
        Select SucursalSeleccionada = new Select(Sucursal);
        SucursalSeleccionada.selectByValue("4");
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
    }
    @Test
    public void Comprar_Disco() throws InterruptedException {
        Thread.sleep(5000);
        driver.navigate().to("https://www.disco.com.uy/frescos/frutas-y-verduras");
        Thread.sleep(5000);
        JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
        jsExecuter.executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        //mapa clave-valor de productos agregados a la compra, donde la clave es el nombre del producto y el valor su cantidad
        Map<String, Integer> itemsSelecList = new HashMap<String, Integer>();
        // lista de productos
        List<WebElement> products = driver.findElements(By.cssSelector("h3.Product-title"));
        // lista de botones +
        List<WebElement> plusButtons = driver.findElements(By.xpath("//button[@class='Multiplier-button js-btn-mas listing']"));
        //lista de botones agregar
        List<WebElement> addButtons = driver.findElements(By.xpath("//span[text()='Agregar']"));
        // cantidad de productos a agregar
        Integer productsCount = 5;
        Integer count = productsCount;
        if(productsCount > products.size()) {
            count = products.size();
            Thread.sleep(2000);
        }
        for (int i=0; i< count; i++) {
            String productName = products.get(i).getText();
            // esta seria la cantidad para el producto que se genera aleatorio entre 1 y 10
            Integer productCount = (int)(Math.random()*(9-5+1)+5);

            //Integer productCount;
            for(int j=0; j< productCount; j++){
                plusButtons.get(i).click();
                Thread.sleep(500);
            }
            addButtons.get(i).click();
            // al final quedaran en este mapa los nombres de productos y cantidades agregados a la compra por si te hace falta saberlos
           itemsSelecList.put(productName, productCount);
        }
        driver.findElement(By.id("btnMiniCart")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btn-finalizar-compra")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cart-to-orderform")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn js-cerrar-mensaje-bolsas']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("client-first-name")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("client-first-name")).sendKeys("Prueba Web");
        Thread.sleep(3000);
        driver.findElement(By.id("client-first-name")).sendKeys("Prueba Web");
        Thread.sleep(3000);
        driver.findElement(By.id("client-last-name")).sendKeys("Soporte");
        Thread.sleep(3000);
        WebElement cldocument = driver.findElement(By.id("client-document"));
        Thread.sleep(3000);
        cldocument.sendKeys("61732624");
        driver.findElement(By.id("client-phone")).sendKeys("095421236");
        Thread.sleep(1000);
        driver.findElement(By.id("go-to-shipping")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("shipping-option-pickup-in-point")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("find-pickups-manualy-button")).click();
        Thread.sleep(1000);
        WebElement deliveryAddress = driver.findElement(By.className("pac-target-input"));
        Thread.sleep(1000);
        deliveryAddress.sendKeys("Disco Fresh Market 8 de octubre");
        Thread.sleep(1000);
        deliveryAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        deliveryAddress.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='vtex-pickup-points-modal-3-x-pickupPointInfo pkpmodal-pickup-point-info'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Recogida en este punto']")).click();
        Thread.sleep(2000);
        WebElement selectDay = driver.findElement(By.xpath("//button[@class='vtex-omnishipping-1-x-dateLink shp-datepicker-button scheduled-delivery-choose']"));
        selectDay.click();
        selectDay.sendKeys(Keys.ENTER);
        driver.findElement(By.id("btn-go-to-payment")).click();
        WebElement radioCard = driver.findElement(By.id("card-430251"));
        if (radioCard.isSelected()==false){
            radioCard.click();
        }
        Thread.sleep(3000);
        WebElement radioSustituto = driver.findElement(By.xpath("//span[text()='No sustituir']"));
        if (radioSustituto.isSelected()==false){
            radioSustituto.click();
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@id='payment-data-submit'])[2]")).click();
    }
   /* @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }*/
}