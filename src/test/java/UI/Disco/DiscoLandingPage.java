package UI.Disco;

import UI.BaseUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DiscoLandingPage extends BaseUITest {

    public DiscoLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public WebElement selectStore(){
        WebElement Sucursal = driver.findElement(By.id("selec-suc-popup"));
        Select SucursalSeleccionada = new Select(Sucursal);
        SucursalSeleccionada.selectByValue("4");
        return Sucursal;
    }
    public DiscoHomePage clickOnButton(){
        clickBtnID("btnConfirmaSucursal");
        DiscoHomePage nextPage = new DiscoHomePage(driver);
        return nextPage;
    }
}


