package UI.Devoto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import UI.BaseUITest;

public class DevotoLoginPage extends BaseUITest {

    public DevotoLoginPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void fillingRegistration(){
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
    }
    public DevotoProductSelection SelectProducts() {
        driver.navigate().to("https://www.devoto.com.uy/perfumeria-y-limpieza/perfumeria");
        DevotoProductSelection nextPage = new DevotoProductSelection(driver);
        return nextPage;
    }
}
