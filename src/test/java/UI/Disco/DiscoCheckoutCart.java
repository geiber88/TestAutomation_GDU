package UI.Disco;

import UI.BaseUITest;
import UI.Devoto.DevotoCheckoutProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscoCheckoutCart extends BaseUITest {

    public DiscoCheckoutCart(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public DiscoCheckoutProfile checkoutProfile() {
        driver.findElement(By.id("cart-to-orderform")).click();
        DiscoCheckoutProfile nextPage = new DiscoCheckoutProfile(driver);
        return nextPage;
    }

}
