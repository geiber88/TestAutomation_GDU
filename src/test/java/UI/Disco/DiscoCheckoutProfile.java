package UI.Disco;

import UI.BaseUITest;
import UI.Devoto.DevotoCheckoutShipping;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscoCheckoutProfile extends BaseUITest {

    public DiscoCheckoutProfile(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void IdentificationForm(){
        driver.findElement(By.id("client-first-name")).click();
        driver.findElement(By.id("client-first-name")).sendKeys("Prueba Web");
        driver.findElement(By.id("client-first-name")).sendKeys("Prueba Web");
        driver.findElement(By.id("client-last-name")).sendKeys("Soporte");
        WebElement cldocument = driver.findElement(By.id("client-document"));
        cldocument.sendKeys("61732624");
        driver.findElement(By.id("client-phone")).sendKeys("095421236");
    }
    public DiscoCheckoutShipping checkoutShipping() {
        driver.findElement(By.xpath("//*[@class='submit btn btn-large btn-success']")).click();
        DiscoCheckoutShipping nextPage = new DiscoCheckoutShipping(driver);
        return nextPage;
    }
}
