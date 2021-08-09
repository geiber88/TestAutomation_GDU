package UI.Devoto;

import UI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevotoCheckoutShipping  extends BaseUITest {

    public DevotoCheckoutShipping(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void deliveryAddress() throws InterruptedException {
        WebElement deliveryAddress = driver.findElement(By.className("pac-target-input"));
        deliveryAddress.sendKeys("Rambla República Argentina 1205 apartamento 1507 Barrio Sur Montevideo");
        Thread.sleep(1000);
        deliveryAddress.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        deliveryAddress.sendKeys(Keys.ENTER);
        WebElement selectDay = driver.findElement(By.xpath("//button[@class='vtex-omnishipping-1-x-dateLink shp-datepicker-button scheduled-delivery-choose']"));
        selectDay.click();
        selectDay.sendKeys(Keys.ENTER);
    }
    public DevotoPayment payment(){
        driver.findElement(By.id("btn-go-to-payment")).click();
        DevotoPayment nextPage = new DevotoPayment(driver);
        return nextPage;
    }

}
