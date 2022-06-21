package tests;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class CartTest extends BaseTest{
    
    public LoginPage loginPage; //definisem ove promenljive jer mi trebaju login i home strana za izvrsavanje cart testa
    public HomePage homePage;
    public CartPage cartPage;
    String acceptedCartTextString = "YOUR CART";

    @Test
    public void verifyCartbutton(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        cartPage.verifyCartPage(acceptedCartTextString);
}
}