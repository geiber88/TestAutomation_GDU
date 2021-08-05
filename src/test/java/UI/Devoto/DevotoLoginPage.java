package UI.Devoto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import UI.BaseUITest;

public class DevotoLoginPage extends BaseUITest {

    public DevotoLoginPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
   /*
    public void clickOnUserPass(){
        driver.findElement(By.id("loginWithUserAndPasswordBtn")).click();
    }
    */

    public void fillingRegistration(){
        driver.findElement(By.id("inputEmail")).sendKeys("grey@disco.com.uy");
        driver.findElement(By.id("inputPassword")).sendKeys("Internet0.");
    }
   /*
    public void clickOnConfirmar(){
        driver.findElement(By.id("classicLoginBtn")).click();
    }
   */

}
