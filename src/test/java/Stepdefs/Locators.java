package Stepdefs;
import org.openqa.selenium.By;

import java.text.MessageFormat;

public interface Locators {
    String url="https://www.saucedemo.com/";

    String loginInput="//input[@placeholder=\"{0}\"]";

    By loginButton=By.xpath("//input[@name=\"login-button\"]");

    default By xpath(String locator, String text){
        return By.xpath(MessageFormat.format(locator,text));
    }
    default By xpath(By locator){
        return locator;
    }
}
