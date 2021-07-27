package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseUITest {

    public WebDriver driver;

    public String getTitleTest(){
        return driver.getTitle();
    }

    public String getCurrentUrlTest(){
        return driver.getCurrentUrl();
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
