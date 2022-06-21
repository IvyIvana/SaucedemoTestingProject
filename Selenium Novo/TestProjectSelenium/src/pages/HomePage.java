package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);     // konstruktor ovaj driver prosledjuje BasePage
    }
    
    By headerTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");  //lokatori
    By numberOfItemsBy = By.xpath("//*[@class='inventory_item']");

    By buttonMenuBy = By.xpath("//*[@id='react-burger-menu-btn']");
    By button1 = By.xpath("//*[@id='inventory_sidebar_link']");
    By button2 = By.xpath("//*[@id='about_sidebar_link']");
    By button3 = By.xpath("//*[@id='logout_sidebar_link']");
    By cartButton = By.xpath( "//*[@id='menu_button_container']");

    String aboutURL = "https://saucelabs.com/";   //novo

    public HomePage verifyLogin ( String expectedText) {     //povratni tip ove metode je homePage
        String pageTitle = readText(headerTitleBy);
        assertStringEquals(pageTitle, expectedText);   //pageTitle je preuzeto sa homePage strane; expectedText
        return this;
    }
    public HomePage validateNumberOfProducts(int expectedNumberOfProducts){
        int actualNumberOFProducts = locateElements(numberOfItemsBy).size();
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOFProducts);
        return this;
    }

    public HomePage verifyMenuTitles ( String expectedText1, String expectedText2, String expectedText3) {
        String menuTitle1 = readText(button1);
        assertStringEquals(menuTitle1, expectedText1);

        String menuTitle2 = readText(button2);
        assertStringEquals(menuTitle2, expectedText2);

        String menuTitle3 = readText(button3);
        assertStringEquals(menuTitle3, expectedText3);
        
        return this;
    }
    public HomePage openMenu () {   // ovo bi trebalo da bude nova klasa tj strana
        click(buttonMenuBy);
        return this;
    }

    public HomePage openLogout(){    //novo test i metoda za about dugme
        click(button3);
        return this;
}  

    public HomePage openCartButton(){
        click(cartButton);
        return this;
    }
}