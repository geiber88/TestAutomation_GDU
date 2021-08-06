package UI.Devoto;

import UI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DevotoCheckoutCart extends BaseUITest {

    public DevotoCheckoutCart(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public DevotoCheckoutProfile checkoutProfile() {
        driver.findElement(By.id("cart-to-orderform")).click();
        DevotoCheckoutProfile nextPage = new DevotoCheckoutProfile(driver);
        return nextPage;
    }

}
