package pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {// kreiramo promenljive
    public WebDriver driver;  //driver = browser
    public WebDriverWait wait;

    public BasePage (WebDriver driver){  //konstruktor basePage sa parametrom driver
        this.driver = driver;  //definisani driver i wait unutar konstruktora
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //explicitni wait, max vreme cekanja 10sek
    }                                                                      //zbog expected condt.
    public void waitVisibility (By elementBy){  //prametar tip By promeljive by
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    public void click(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }
    public void writeText (By elementBy, String text) {// elementBy nad elementom koji smo locirali
        waitVisibility(elementBy);  //cekam da el bude vidljiv, da se polje za unos texta pojavi
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }
    public String readText(By elementBy) {
        waitVisibility(elementBy);  //lokator 
        return driver.findElement(elementBy).getText();
    }
    public void assertStringEquals (String string, String expectedText) {
        Assert.assertEquals(string, expectedText);
    }
    public void assertIntegerEquals (int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }
    public List<WebElement> locateElements(By elementBy){
        waitVisibility(elementBy);
        return driver.findElements(elementBy);
    }
}
