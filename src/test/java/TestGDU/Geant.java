package TestGDU;

import UI.Devoto.DevotoHomePage;
import UI.Devoto.DevotoLandingPage;
import UI.Devoto.DevotoLoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Geant extends BaseTest{

    @BeforeClass
    public void inicializar_Url_Disco(){
        driver.get("https://www.geant.com.uy/");
    }

    @BeforeMethod
    public void Autenticacion_Geant() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/w-div/span")).click();
        driver.findElement(By.xpath("(//button[@class='jss7 jss19 custom-root jss21 jss24 styles__Button-bhlbst-0 kAGoCB styles__Wrapper-sc-42ogtn-0 kGPgYa'])[1]")).click();
        WebElement addressStore = driver.findElement(By.xpath(("(//input[@class='jss68 jss53 native-input'])[3]")));
        addressStore.sendKeys("Rambla República Argentina 1205 apartamento 1507 Barrio Sur Montevideo");
        Thread.sleep(1000);
        addressStore.sendKeys(Keys.ARROW_DOWN);
        addressStore.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='jss7 jss19 custom-root jss30 jss31 jss33 jss34 styles__Button-bhlbst-0 kAGoCB styles__Button-sc-1xkqa5v-6 eKifnE']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='jss7 jss19 custom-root jss21 jss24 styles__Button-bhlbst-0 kAGoCB styles__Button-xqo98n-0 ftWIgs']")).click();
        driver.findElement(By.xpath("//button[@class='jss7 jss19 custom-root jss21 jss24 styles__Button-bhlbst-0 kAGoCB styles__Button-urqn1t-3 icYDKy']")).click();
        driver.findElement(By.id("loginWithUserAndPasswordBtn")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
        driver.findElement(By.id("classicLoginBtn")).click();
        driver.findElement(By.xpath("(//button[@class='btn btn-large btn-success pull-right'])[1]"));
    }
    @Test
    public void Comprar_Geant() throws InterruptedException {
      //  Thread.sleep(1000);
       // driver.findElement(By.xpath("//div[@class='styles__Wrapper-ids5ve-0 eTZxxO']")).click();
       // Thread.sleep(1000);
        driver.navigate().to("https://www.geant.com.uy/perfumeria-y-limpieza");
        Thread.sleep(1000);
        /*driver.findElement(By.xpath("(//div[@class='styles__Wrapper-hkhrxq-0 gtSLAe styles__AddToCart-tbq658-2 kwbema'])[1]")).click();
        System.out.println("Boton agregar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='jss36 jss73 styles__IconButton-q0mhzs-0 cjbrvb styles__QuantityButtonBase-sc-8x7pwc-0 styles__Plus-sc-8x7pwc-2 dIaBSD']")).click();
        System.out.println("Boton +");
        */

        //mapa clave-valor de productos agregados a la compra, donde la clave es el nombre del producto y el valor su cantidad
        Map<String, Integer> itemsSelecList = new HashMap<String, Integer>();
        // lista de productos
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='styles__Title-tbq658-14 ePkRgH']"));
        // lista de botones agregar
        List<WebElement> addButtons = driver.findElements(By.xpath("//div[@class='styles__Wrapper-hkhrxq-0 gtSLAe styles__AddToCart-tbq658-2 kwbema']"));

        // cantidad de productos a agregar
        Integer productsCount = 5;
        Integer count = productsCount;
        if(productsCount > products.size()) {
            count = products.size();
            Thread.sleep(3000);
        }
        for (int i=0; i< count; i++) {
            addButtons.get(i).click();
            Thread.sleep(3000);
            String productName = products.get(i).getText();
            Integer productCount = (int)(Math.random()*(2-1+1)+1);
            List<WebElement> plusButtons = driver.findElements(By.xpath("//button[@class='jss36 jss73 styles__IconButton-q0mhzs-0 cjbrvb styles__QuantityButtonBase-sc-8x7pwc-0 styles__Plus-sc-8x7pwc-2 dIaBSD']"));
            Thread.sleep(3000);
            for(int j=0; j< plusButtons.size(); j++){
                for(int k=0; k< productCount; k++){
                    plusButtons.get(i).click();
                    Thread.sleep(3000);
                }
            }

            // al final quedaran en este mapa los nombres de productos y cantidades agregados a la compra por si te hace falta saberlos
            itemsSelecList.put(productName, productCount);
        }
        driver.findElement(By.xpath("//button[@class='jss36 jss10 custom-root jss12 jss15 styles__Button-bhlbst-0 kAGoCB styles__Button-sc-1hiosjg-3 jlREgB']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='jss36 jss10 custom-root jss21 jss22 jss24 jss25 styles__Button-bhlbst-0 kAGoCB styles__GoCheckoutButton-sc-1hiosjg-18 kqQGAo']")).click();
        Thread.sleep(1000);
        WebElement radioSustituto = driver.findElement(By.xpath("(//input[@class='jss18'])[1]"));
        if (radioSustituto.isSelected()==false){
            radioSustituto.click();
        }
        //driver.findElement(By.xpath("//button[@class='styles__AddNote-sc-2ai53j-4 fClhcv']")).click();
       // driver.findElement(By.xpath("//button[@class='styles__TextArea-sc-2ai53j-2 blCZll']")).sendKeys("Esto es una Prueba Web Soporte");
        driver.findElement(By.xpath("//button[@class='jss25 jss58 custom-root jss69 jss70 jss72 jss73 styles__Button-bhlbst-0 kAGoCB styles__BaseButton-suauvr-0 styles__Checkout-suauvr-6 bDNVCl']")).click();

        //driver.findElement(By.xpath("(//input[@id='client-first-name'])[4]")).click();
        driver.findElement(By.xpath("//input[@class='input-small error']")).sendKeys("Prueba Web");
        driver.findElement(By.xpath("//input[@class='input-small']")).sendKeys("Soporte");
        driver.findElement(By.xpath("(//input[@id='client-document'])[4]")).sendKeys("61732624");
        driver.findElement(By.xpath("(//input[@id='client-phone'])[6]")).sendKeys("095421236");
        driver.findElement(By.xpath("(//input[@id='go-to-shipping'])[2]")).click();
        WebElement deliveryAddress = driver.findElement(By.className("pac-target-input"));
        deliveryAddress.sendKeys("Rambla República Argentina 1205 Apto 1507 Barrio Sur, Montevideo");
        Thread.sleep(2000);
        deliveryAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        deliveryAddress.sendKeys(Keys.ENTER);
       // driver.findElement(By.id("ship-number")).sendKeys(buildingNum);
        Thread.sleep(2000);
       // driver.findElement(By.id("ship-complement")).sendKeys(streetNumber);
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
        driver.findElement(By.xpath("(//*[@id='payment-data-submit'])[2]")).click();



        driver.findElement(By.id("cardNumber")).sendKeys("4453488777784597");

        driver.findElement(By.id("expirationTxtBox")).sendKeys("09/22");

        driver.findElement(By.id("cvvTextBox")).sendKeys("096");

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
}
