package UI.Devoto;

import UI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DevotoPaymentPage extends BaseUITest {

    public DevotoPaymentPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void PaymentInformation() throws InterruptedException {
        String numero= "4453488777784597";
        driver.switchTo().frame("custom_iframe");
        driver.findElement(By.id("Titular")).sendKeys("Prueba Web Soporte");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys(numero);
        driver.findElement(By.id("expirationTxtBox")).sendKeys("09");
        driver.findElement(By.id("expirationTxtBox")).sendKeys("22");
        driver.findElement(By.id("cvvTextBox")).sendKeys("096");
        Thread.sleep(2000);

    }
}
