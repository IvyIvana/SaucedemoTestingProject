package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends BaseTest{
    
    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;

    int numberOfAllItems = 6;

    String prvi = "ALL ITEMS";
    String drugi = "ABOUT";
    String treci = "LOGOUT";
    String acceptedTextString = "Accepted usernames are:";
    String cartTitle = "YOUR CART";

    @Test
    public void checkNumberOfItemsOnHomePage() {

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        
        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.validateNumberOfProducts(numberOfAllItems);
    }
    @Test
    public void chekMenuButtonsTitles() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.openMenu();
        homePage.verifyMenuTitles(prvi, drugi, treci);
    }   
    @Test //novo
    public void verifyLogoutbutton (){

       loginPage = new LoginPage(driver);
       homePage = new HomePage(driver);
       
       loginPage.basePage();
       loginPage.login(validUsername, validPassword);
       homePage.openMenu();
       homePage.openLogout(); 
       loginPage.verifyLogout(acceptedTextString);

         try {
            Thread.sleep(3000); 
         } catch (InterruptedException exception) {
            exception.printStackTrace();
         }
}
    
@Test
    public void verifyCartbutton(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.openCartButton();
        
        

    }
}


