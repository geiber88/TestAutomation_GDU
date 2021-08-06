package UI.Devoto;

import UI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevotoPayment extends BaseUITest {

    public DevotoPayment(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void visaCard() {
        WebElement radioCard = driver.findElement(By.id("card-430251"));
        if (radioCard.isSelected()==false){
            radioCard.click();
        }
    }
    public void failProduct() throws InterruptedException {
        Thread.sleep(2000);
        WebElement radioSustitution = driver.findElement(By.xpath("//span[text()='No sustituir']"));
        if (radioSustitution.isSelected()==false){
            radioSustitution.click();
        }
    }
    public DevotoPaymentPage buyNow() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@id='payment-data-submit'])[2]")).click();
        DevotoPaymentPage nextPage = new DevotoPaymentPage(driver);
        return nextPage;
    }
}
