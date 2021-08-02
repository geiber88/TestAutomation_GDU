package TestGDU;

import UI.Devoto.DevotoHomePage;
import UI.Devoto.DevotoLandingPage;
import UI.Devoto.DevotoLoginPage;
import com.github.javafaker.CreditCardType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Devoto extends BaseTest{

    @BeforeClass
    public void inicializar_Url_Devoto(){
        driver.get("https://www.devoto.com.uy/");
    }

    @BeforeMethod
    public void Autenticacion_Devoto()  {
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
    public void Comprar_Devoto() throws InterruptedException {
        Thread.sleep(5000);
        driver.navigate().to("https://www.devoto.com.uy/frescos/frutas-y-verduras");
        Thread.sleep(5000);
        JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
        jsExecuter.executeScript("window.scrollBy(0,150)");
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
            Thread.sleep(3000);
        }
        for (int i=0; i< count; i++) {
            String productName = products.get(i).getText();
            // esta seria la cantidad para el producto que se genera aleatorio entre 1 y 10
            Integer productCount = (int)(Math.random()*(10-5+1)+5);

            //Integer productCount = 14;
            for(int j=0; j< productCount; j++){
                plusButtons.get(i).click();
                Thread.sleep(500);
            }
            addButtons.get(i).click();
            // al final quedaran en este mapa los nombres de productos y cantidades agregados a la compra por si te hace falta saberlos
            itemsSelecList.put(productName, productCount);
        }
            //driver.findElement(By.xpath("//button[@class='Multiplier-button js-btn-mas listing']")).click();

        driver.findElement(By.id("btnMiniCart")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btn-finalizar-compra")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cart-to-orderform")).click();
        Thread.sleep(1000);

        Faker faker_data = new Faker();
       // String firstName = faker_data.name().firstName();
       // String lastName = faker_data.name().lastName();
       // String buildingNum = faker_data.address().buildingNumber();
       // String streetNumber = faker_data.address().streetAddressNumber();

        driver.findElement(By.id("client-first-name")).sendKeys("Prueba Web");
        driver.findElement(By.id("client-last-name")).sendKeys("Soporte");
        driver.findElement(By.id("client-document")).sendKeys("61732624");
        driver.findElement(By.id("client-phone")).sendKeys("095421236");
        driver.findElement(By.xpath("//*[@class='submit btn btn-large btn-success']")).click();
        driver.findElement(By.xpath("//button[@class='btn js-cerrar-mensaje-bolsas']")).click();
        driver.findElement(By.className("pac-target-input")).click();
        WebElement deliveryAddress = driver.findElement(By.className("pac-target-input"));
        deliveryAddress.sendKeys("Rambla República Argentina 1205 apartamento 1507 Barrio Sur Montevideo");
        Thread.sleep(2000);
        deliveryAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        deliveryAddress.sendKeys(Keys.ENTER);
        //driver.findElement(By.id("ship-number")).sendKeys("1205");
       // Thread.sleep(2000);
       // driver.findElement(By.id("ship-complement")).sendKeys("1507");
       // Thread.sleep(2000);
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
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@id='payment-data-submit'])[2]")).click();
       // driver.findElement(By.cssSelector("(#payment-data-submit)[2]")).click();

        driver.switchTo().frame("custom_iframe");
        driver.findElement(By.id("Titular")).sendKeys("Prueba Web Soporte");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("4453488777784597");
        //driver.findElement(By.xpath("//input[@autocomplete='cc-number']")).sendKeys("4453488777784597");
        driver.findElement(By.id("expirationTxtBox")).sendKeys("0922");
        driver.findElement(By.id("cvvTextBox")).sendKeys("096");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@id='btnPay']) ")).click();

    /*
        List<WebElement> products = driver.findElements(By.cssSelector("h3.Product-title"));
            for (int i = 0; i < products.size(); i++) {
                String name = products.get(i).getText();
                    if (name.contains("Frutilla")) {
                        List<WebElement> buttonAdd = driver.findElements(By.xpath("//span[text()='Agregar']"));
                        buttonAdd.get(i).click();
                        break;
                    }
            }
        for(int i=0; i<9; i++){
            WebElement addElements = driver.findElement(By.xpath("//button[@class='Multiplier-button js-btn-mas listing']"));
            Thread.sleep(3000);
            addElements.click();
        }
    */
    }
    /*
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }*/
}