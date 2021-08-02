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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='jss7 jss19 custom-root jss21 jss24 styles__Button-bhlbst-0 kAGoCB styles__Wrapper-sc-1osc43k-0 kPkfZV']")).click();
        Thread.sleep(1000);
        driver.navigate().to("https://www.geant.com.uy/frescos");
        Thread.sleep(5000);
        //mapa clave-valor de productos agregados a la compra, donde la clave es el nombre del producto y el valor su cantidad
        Map<String, Integer> itemsSelecList = new HashMap<String, Integer>();
        // lista de productos
        List<WebElement> products = driver.findElements(By.cssSelector("p.styles__Brand-sc-1oqmf3r-0 fExUwT styles__Brand-tbq658-13 fHVoCq"));
        // lista de botones +
        List<WebElement> plusButtons = driver.findElements(By.xpath("//button[@class='jss36 jss73 styles__IconButton-q0mhzs-0 cjbrvb styles__QuantityButtonBase-sc-8x7pwc-0 styles__Plus-sc-8x7pwc-2 dIaBSD']"));
        //lista de botones agregar
        List<WebElement> addButtons = driver.findElements(By.xpath("//span[text()='Agregar']"));
        // cantidad de productos a agregar
        Integer productsCount = 10;
        Integer count = productsCount;
        if(productsCount > products.size()) {
            count = products.size();
            Thread.sleep(3000);
        }
        for (int i=0; i< count; i++) {
            addButtons.get(i).click();
            String productName = products.get(i).getText();
            // esta seria la cantidad para el producto que se genera aleatorio entre 1 y 10
            Integer productCount = (int)(Math.random()*(20-10+1)+10);
            //Integer productCount = 14;
            for(int j=0; j< productCount; j++){
                plusButtons.get(i).click();
                Thread.sleep(500);
            }
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
        String firstName = faker_data.name().firstName();
        String lastName = faker_data.name().lastName();
        String buildingNum = faker_data.address().buildingNumber();
        String streetNumber = faker_data.address().streetAddressNumber();

        driver.findElement(By.id("client-first-name")).sendKeys(firstName);
        driver.findElement(By.id("client-last-name")).sendKeys(lastName);
        driver.findElement(By.id("client-document")).sendKeys("61732624");
        driver.findElement(By.id("client-phone")).sendKeys("095421236");
        driver.findElement(By.xpath("//*[@class='submit btn btn-large btn-success']")).click();
        driver.findElement(By.xpath("//button[@class='btn js-cerrar-mensaje-bolsas']")).click();
        driver.findElement(By.className("pac-target-input")).click();
        WebElement deliveryAddress = driver.findElement(By.className("pac-target-input"));
        deliveryAddress.sendKeys("Rambla República Argentina");
        Thread.sleep(2000);
        deliveryAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        deliveryAddress.sendKeys(Keys.ENTER);
        driver.findElement(By.id("ship-number")).sendKeys(buildingNum);
        Thread.sleep(2000);
        driver.findElement(By.id("ship-complement")).sendKeys(streetNumber);
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
        // driver.findElement(By.cssSelector("(#payment-data-submit)[2]")).click();


        driver.findElement(By.id("Titular")).sendKeys(firstName);

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
