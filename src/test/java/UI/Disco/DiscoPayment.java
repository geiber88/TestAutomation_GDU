package UI.Disco;

import UI.BaseUITest;
import UI.Devoto.DevotoPaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscoPayment extends BaseUITest {

    public DiscoPayment(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void failProduct() throws InterruptedException {
        Thread.sleep(2000);
        WebElement radioSustitution = driver.findElement(By.xpath("//span[text()='No sustituir']"));
        if (radioSustitution.isSelected()==false){
            radioSustitution.click();
        }
    }

}
