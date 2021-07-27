package UI.Devoto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import UI.BaseUITest;

import java.util.List;

public class DevotoHomePage extends BaseUITest {

    public DevotoHomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    /*
    public void clickOnMiPerfil(){
        driver.findElement(By.id("btnMiPerfil")).click();
    }
     */

    public DevotoLoginPage clickOnMiCuenta(){
        driver.navigate().to("https://www.devoto.com.uy/login");
        DevotoLoginPage nextPage = new DevotoLoginPage(driver);
        return nextPage;
    }
}
