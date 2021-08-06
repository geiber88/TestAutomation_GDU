package UI.Devoto;

import UI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DevotoCheckoutProfile extends BaseUITest {

    public DevotoCheckoutProfile(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void IdentificationForm(){
        driver.findElement(By.id("client-first-name")).sendKeys("Prueba Web");
        driver.findElement(By.id("client-last-name")).sendKeys("Soporte");
        driver.findElement(By.id("client-document")).sendKeys("61732624");
        driver.findElement(By.id("client-phone")).sendKeys("095421236");
    }
    public DevotoCheckoutShipping checkoutShipping() {
        driver.findElement(By.xpath("//*[@class='submit btn btn-large btn-success']")).click();
        DevotoCheckoutShipping nextPage = new DevotoCheckoutShipping(driver);
        return nextPage;
    }
}
