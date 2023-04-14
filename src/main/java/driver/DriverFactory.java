package driver;

import Readers.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver createChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        for (String s : PropertyReader.read().get("chrome.options").split(",")) {
            options.addArguments(s.trim());
        }
        return new ChromeDriver(options);
    }

    public static WebDriver createFrefox(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options=new FirefoxOptions();
        for (String s : PropertyReader.read().get("frefox.options").split(",")) {
            options.addArguments(s.trim());
            System.out.println(s.trim());
        }
        return new FirefoxDriver(options);
    }
}
