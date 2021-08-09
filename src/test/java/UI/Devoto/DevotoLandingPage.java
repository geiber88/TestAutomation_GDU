package UI.Devoto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import UI.BaseUITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DevotoLandingPage extends BaseUITest {

    public DevotoLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public WebElement selectStore(){
        WebElement departamento = driver.findElement(By.id("selec-suc-popup"));
        Select SucursalSeleccionada = new Select(departamento);
        SucursalSeleccionada.selectByValue("3");
        return departamento;
    }
    public DevotoHomePage clickOnButton(){
        clickBtnID("btnConfirmaSucursal");
        DevotoHomePage nextPage = new DevotoHomePage(driver);
        return nextPage;
    }
}


