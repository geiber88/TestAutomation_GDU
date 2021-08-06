package TestGDU;

import UI.Devoto.*;
import org.testng.annotations.*;


public class Devoto extends BaseTest{

    @BeforeClass
    public void inicializarUrlDevoto(){
        driver.get("https://www.devoto.com.uy/");
    }

    @BeforeMethod
    public void AutenticacionDevoto()  {
        //Page 1 Pagina para seleccionar Dpto Landing
        DevotoLandingPage devotoLandingPage=new DevotoLandingPage(driver);
        devotoLandingPage.selectStore();
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
    public void CompraDevoto() throws InterruptedException {
        DevotoLoginPage devotoLoginPage = new DevotoLoginPage(driver);
        DevotoProductSelection devotoProductSelection = devotoLoginPage.SelectProducts();
        //Page DevotoProductSelection
        devotoProductSelection.scrollUpDown();
        devotoProductSelection.agregarProductos();
        devotoProductSelection.clickBtnID("btnMiniCart");
        //Page DevotoCheckoutCart
        DevotoCheckoutCart devotoCheckoutCart = devotoProductSelection.checkoutCart();
        //Page DevotoCheckoutProfile
        DevotoCheckoutProfile devotoCheckoutProfile = devotoCheckoutCart.checkoutProfile();
        //Page Finalizar la compra profile
        devotoCheckoutProfile.IdentificationForm();
        DevotoCheckoutShipping devotoCheckoutShipping = devotoCheckoutProfile.checkoutShipping();
        //Page DevotoCheckoutShipping
        devotoCheckoutShipping.clickBtnXpath("//button[@class='btn js-cerrar-mensaje-bolsas']");
        devotoCheckoutShipping.clickBtnClassName("pac-target-input");
        devotoCheckoutShipping.deliveryAddress();
        DevotoPayment devotoPayment = devotoCheckoutShipping.payment();
        //Page Elija Tarjeta
        devotoPayment.visaCard();
        devotoPayment.failProduct();
        DevotoPaymentPage devotoPaymentPage = devotoPayment.buyNow();
        //Page new Pagar
        devotoPaymentPage.PaymentInformation();
        devotoPaymentPage.clickBtnXpath("//button[@id='btnPay']");
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