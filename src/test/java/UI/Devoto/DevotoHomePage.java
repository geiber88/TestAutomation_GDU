package UI.Devoto;

import org.openqa.selenium.WebDriver;
import UI.BaseUITest;

import java.util.List;

public class DevotoHomePage extends BaseUITest {

    public DevotoHomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public DevotoLoginPage clickOnMiCuenta(){
        driver.navigate().to("https://www.devoto.com.uy/login");
        DevotoLoginPage nextPage = new DevotoLoginPage(driver);
        return nextPage;
    }
}
