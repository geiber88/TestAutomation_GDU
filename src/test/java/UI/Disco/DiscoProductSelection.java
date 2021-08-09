package UI.Disco;

import UI.BaseUITest;
import UI.Devoto.DevotoCheckoutCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscoProductSelection extends BaseUITest {

    public DiscoProductSelection(WebDriver remoteDriver){
        driver = remoteDriver;
    }
    public void agregarProductos() throws InterruptedException {
        //mapa clave-valor de productos agregados a la compra, donde la clave es el nombre del producto y el valor su cantidad
        Map<String, Integer> itemsSelecList = new HashMap<String, Integer>();
        // lista de productos
        List<WebElement> products = driver.findElements(By.cssSelector("h3.Product-title"));
        // lista de botones +
        List<WebElement> plusButtons = driver.findElements(By.xpath("//button[@class='Multiplier-button js-btn-mas listing']"));
        //lista de botones agregar
        List<WebElement> addButtons = driver.findElements(By.xpath("//span[text()='Agregar']"));
        // cantidad de productos a agregar
        Integer productsCount = 3;
        Integer count = productsCount;
        if(productsCount > products.size()) {
            count = products.size();
        }
        for (int i=0; i< count; i++) {
            String productName = products.get(i).getText();
            // esta seria la cantidad para el producto que se genera aleatorio entre 1 y 10
            Integer productCount = (int)(Math.random()*(9-7+1)+7);

            //Integer productCount;
            for(int j=0; j< productCount; j++){
                plusButtons.get(i).click();
                Thread.sleep(500);
            }
            Thread.sleep(1000);
            addButtons.get(i).click();
            // al final quedaran en este mapa los nombres de productos y cantidades agregados a la compra por si te hace falta saberlos
            itemsSelecList.put(productName, productCount);
        }
    }
    public DiscoCheckoutCart checkoutCart() {
        driver.findElement(By.id("btn-finalizar-compra")).click();
        DiscoCheckoutCart nextPage = new DiscoCheckoutCart(driver);
        return nextPage;
    }
}
