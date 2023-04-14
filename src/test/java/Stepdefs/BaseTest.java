package Stepdefs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.Driver.getDriver;
import static driver.Driver.getWait;

public class BaseTest {

    WebDriver driver= getDriver();
    WebDriverWait wait= getWait();

    WebElement element;
    By locator;


    public  BaseTest $(WebElement element){
        this.element=element;
        return this;
    }

    public BaseTest $(By locator){
        this.locator=locator;
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    public  BaseTest click(){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        return this;
    }

    public BaseTest sendKeys(CharSequence... text){
        element.sendKeys(text);
        return this;
    }

    public BaseTest open(String url){
        driver.get(url);
        return this;
    }
}
