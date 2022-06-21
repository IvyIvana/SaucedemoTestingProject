package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {  //konstruktor
        super(driver);
    }

    // def se promenljive i lokatori
    By usernameBy = By.id("user-name");  //promenljiva tipa By, naziva usernameBy ima vrednost user=name
    By passwordBy = By.id("password");  //vrednost dodeljena po ID (expect element)
    By loginButtonBy = By.id("login-button");
    By errorMessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
    By textLogoutBy = By.xpath("//*[@id='login_credentials']/h4");

    // By errorMessageInvUser = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
    // By errorMessageInvPass = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    String baseURL = "https://www.saucedemo.com/";  //definisem sajt koji testiram

    public LoginPage basePage(){// kreiram metodu koja ce da mi otvori sajt i metoda vraca LoginPage objekat
        driver.get(baseURL);
        return this;        // this omogucavanja vezivanje metoda
    }

    public LoginPage login (String username, String password){
        writeText(usernameBy, username);  //pozivam writetext metodu iz BasePage i prosledjujem vrednost za promenljive
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }
    
    public LoginPage verifyUnsuccessfullLogin ( String expectedText) {
        String error = readText(errorMessage);
        assertStringEquals(error, expectedText);
        return this;
    }
 
    public LoginPage verifyLogout ( String expectedText) {  //novo test i metoda
    String acceptedText = readText(textLogoutBy);
    assertStringEquals(acceptedText, expectedText);
    return this;     // homepage

    // public LoginPage verifyInvalidUserTest ( String expectedText) {
    //     String errorIU = readText(errorMessageInvUser);
    //     assertStringEquals(errorIU, expectedTxt);
    //     return this;
    // }

}
}