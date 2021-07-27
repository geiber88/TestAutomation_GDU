package TestGDU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverUtilities {

    WebDriver driver;

    public DriverUtilities(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void clickBtnXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickBtnSelector(String cssSelector){
        driver.findElement(By.cssSelector(cssSelector)).click();
    }
    public void clickBtnID(String id){
        driver.findElement(By.id(id)).click();
    }
    public void clickBtnName(String name){
        driver.findElement(By.name(name)).click();
    }

}
