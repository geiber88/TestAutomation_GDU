package TestGDU;

import UI.Devoto.*;
import UI.Disco.*;
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
    public void inicializarUrlDisco(){
        driver.get("https://www.disco.com.uy/");
    }

    @BeforeMethod
    public void AutenticacionDisco()  {
        //Page 1 Pagina para seleccionar Dpto Landing
        DiscoLandingPage discoLandingPage = new DiscoLandingPage(driver);
        discoLandingPage.selectStore();
        DiscoHomePage discoHomePage = discoLandingPage.clickOnButton();

        //Page 2   Home
        discoHomePage.clickBtnID("btnMiPerfil");
        discoHomePage.clickBtnClassName("perfil-desktop");
        DiscoLoginPage discoLoginPage = discoHomePage.clickOnMiCuenta();

        //Page 3   Login
        discoLoginPage.clickBtnID("loginWithUserAndPasswordBtn");
        discoLoginPage.fillingRegistration();
        discoLoginPage.clickBtnID("classicLoginBtn");
    }
    @Test
    public void CompraDisco() throws InterruptedException {
        DiscoLoginPage discoLoginPage = new DiscoLoginPage(driver);
        DiscoProductSelection discoProductSelection = discoLoginPage.SelectProducts();

        //Page DiscoProductSelection
        discoProductSelection.scrollUpDown();
        discoProductSelection.agregarProductos();
        discoProductSelection.clickBtnID("btnMiniCart");

        //Page DevotoCheckoutCart
        DiscoCheckoutCart discoCheckoutCart = discoProductSelection.checkoutCart();

        //Page DevotoCheckoutProfile
        DiscoCheckoutProfile discoCheckoutProfile = discoCheckoutCart.checkoutProfile();

        //Page Finalizar la compra profile
        discoCheckoutProfile.clickBtnXpath("//button[@class='btn js-cerrar-mensaje-bolsas']");
        discoCheckoutProfile.IdentificationForm();
        DiscoCheckoutShipping discoCheckoutShipping = discoCheckoutProfile.checkoutShipping();
        //Page DevotoCheckoutShipping
        discoCheckoutShipping.clickBtnID("shipping-option-pickup-in-point");
        discoCheckoutShipping.clickBtnID("find-pickups-manualy-button");

        discoCheckoutShipping.deliveryAddress();
        DiscoPayment discoPayment= discoCheckoutShipping.payment();
        discoPayment.failProduct();
        discoPayment.clickBtnXpath("(//*[@id='payment-data-submit'])[2]");

/*
        driver.findElement(By.xpath("(//span[@class='payment-group-item-text'])[3]")).click();


        Thread.sleep(3000);
        WebElement radioSustituto = driver.findElement(By.xpath("//span[text()='No sustituir']"));
        if (radioSustituto.isSelected()==false){
            radioSustituto.click();
        }
        Thread.sleep(5000);
       // driver.findElement(By.xpath("(//*[@id='payment-data-submit'])[2]")).click();

 */
    }
   /* @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }*/
}