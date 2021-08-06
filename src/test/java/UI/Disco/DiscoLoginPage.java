package UI.Disco;

import UI.BaseUITest;
import UI.Devoto.DevotoProductSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscoLoginPage extends BaseUITest {

    public DiscoLoginPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void fillingRegistration(){
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
    }
    public DiscoProductSelection SelectProducts() {
        driver.navigate().to("https://www.disco.com.uy/frescos/frutas-y-verduras");
        DiscoProductSelection nextPage = new DiscoProductSelection(driver);
        return nextPage;
    }
}
