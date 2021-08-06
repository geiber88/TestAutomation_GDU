package UI.Disco;

import UI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscoHomePage extends BaseUITest {

    public DiscoHomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public DiscoLoginPage clickOnMiCuenta(){
        driver.navigate().to("https://www.disco.com.uy/login");
        DiscoLoginPage nextPage = new DiscoLoginPage(driver);
        return nextPage;
    }
}
