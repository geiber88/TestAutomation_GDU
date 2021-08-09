package UI.Disco;

import UI.BaseUITest;
import UI.Devoto.DevotoPayment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscoCheckoutShipping extends BaseUITest {

    public DiscoCheckoutShipping(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void deliveryAddress() throws InterruptedException {
        Thread.sleep(1000);
        WebElement deliveryAddress = driver.findElement(By.xpath("//*[@class='pac-target-input']"));
        deliveryAddress.click();
        System.out.println("Prueba");
        Thread.sleep(1000);
        deliveryAddress.sendKeys("Disco Fresh Market 8 de octubre");
        Thread.sleep(1000);
        deliveryAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        deliveryAddress.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@class='vtex-pickup-points-modal-3-x-pickupPointInfo pkpmodal-pickup-point-info'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Recogida en este punto']")).click();
        Thread.sleep(2000);
        WebElement selectDay = driver.findElement(By.xpath("//button[@class='vtex-omnishipping-1-x-dateLink shp-datepicker-button scheduled-delivery-choose']"));
        selectDay.click();
        selectDay.sendKeys(Keys.ENTER);
    }
    public DiscoPayment payment(){
        driver.findElement(By.id("btn-go-to-payment")).click();
        DiscoPayment nextPage = new DiscoPayment(driver);
        return nextPage;
    }

}
