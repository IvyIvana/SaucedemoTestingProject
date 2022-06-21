package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;// sve metode iz loginPage klase ce nam biti ovde dostupne

public class LoginTests extends BaseTest{
    
    public LoginPage loginPage; //definisem ove promenljive jer mi trebaju login i home strana za izvrsavanje login testa
    public HomePage homePage;
    
    String productTitle = "PRODUCTS";
    
    String lockedUsername = "locked_out_user";
    String error_message = "Epic sadface: Sorry, this user has been locked out.";

    String invalidUsername = "unstandard_user";// sta god ovde zelis da uneses
    String error_message_iu = "Epic sadface: Username and password do not match any user in this service";

    String invalidPassword = "secret_sauc";
    String error_message_ip = "Epic sadface: Username and password do not match any user in this service";

    String emptyUsername = "";
    String error_message_emUser = "Epic sadface: Username is required";

    String emptyPassword = "";
    String error_message_emPass = "Epic sadface: Password is required";

    @Test
    public void validLoginTest() {
        loginPage = new LoginPage(driver);  //definisemo objekte
        homePage = new HomePage(driver);

        loginPage.basePage();
        loginPage.login(validUsername, validPassword);
        homePage.verifyLogin(productTitle); //kad nema def promenjivu pise se ("")

        try {   // nacin d saznamo da li smo se ulogovali i da li se vidi homePage
            Thread.sleep(3000); 
         } catch (InterruptedException e) {   // e=error
           e.printStackTrace();
         }
    }
    @Test
    public void lockedUserTest() {
        loginPage = new LoginPage(driver);
        // homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(lockedUsername, validPassword);
        loginPage.verifyUnsuccessfullLogin(error_message);// istu metodu zoves
    }
    @Test
    public void invalidUsernameTest() {
        loginPage = new LoginPage(driver);
        // homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(invalidUsername, validPassword);
        loginPage.verifyUnsuccessfullLogin(error_message_iu);// istu metdou zoves
    }
    @Test
    public void invalidPasswordTest() {
        loginPage = new LoginPage(driver);
        // homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(validUsername, invalidPassword);
        loginPage.verifyUnsuccessfullLogin(error_message_ip);// istud metodu zovess
    }
    @Test
    public void emptyUsernameTest() {
        loginPage = new LoginPage(driver);
        // homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(emptyUsername, validPassword);
        loginPage.verifyUnsuccessfullLogin(error_message_emUser);// 
    }
    @Test
    public void emptyPasswordTest() {
        loginPage = new LoginPage(driver);
        // homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(validUsername, emptyPassword);
        loginPage.verifyUnsuccessfullLogin(error_message_emPass);// 
    }
}
