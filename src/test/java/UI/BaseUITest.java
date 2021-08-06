package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void clickBtnClassName(String classname){
        driver.findElement(By.className(classname)).click();
    }
    public void scrollUpDown() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
        jsExecuter.executeScript("window.scrollBy(0,150)");
        Thread.sleep(2000);
    }
}
