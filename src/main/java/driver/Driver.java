package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.DriverFactory.*;

import java.time.Duration;

import static driver.Browsers.chrome;

public class Driver {

    private static ThreadLocal<WebDriver> drivers=new ThreadLocal<>();
    private static ThreadLocal<Browsers> browsers=new ThreadLocal<>();
    private static WebDriverWait  wait;

    public static WebDriver getDriver(){
        if (browsers.get()==null) {
            browsers.set(chrome);
        }
        return getDriver(chrome);
    }


    public static WebDriver getDriver(Browsers browser){
        browsers.set(browser);

        if (drivers.get()==null) {

            switch (browser){

                case frifox:
                    drivers.set(createFrefox());
                    drivers.get().manage().window().maximize();
                    break;
                default:
                    drivers.set(createChrome());
            }
        }
        wait=new WebDriverWait(drivers.get(), Duration.ofMillis(15_000));
        return drivers.get();

    }

    public static void quitDriver(){
        if (drivers.get() != null) {
            drivers.get().quit();
        }
    }

    public static WebDriverWait getWait(){
        return wait;
    }
}
