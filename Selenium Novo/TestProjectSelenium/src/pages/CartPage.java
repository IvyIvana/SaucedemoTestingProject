package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);     
    }
By headerCartBy = By.xpath("//*[@id='header_container']/div[2]/span");  

public CartPage verifyCartPage(String expectedTextCart){
    String pageTitle = readText(headerCartBy);   //kad stoji accepted text?
    assertStringEquals(pageTitle, expectedTextCart);
    return this;     
}
}