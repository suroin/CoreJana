package DriverSupplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    public static final Supplier<WebDriver> chromeSupplier= () -> {
        System.setProperty("webdriver.chrome.driver","/home/sflpro.local/suren.gharagyozyan/IdeaProjects/CoreJava/src/main/resources/chromedriver");
        return new ChromeDriver();
    };

    public static final Supplier<WebDriver> firefoxSupplier= () -> {
        System.setProperty("webdriver.gecko.driver","path");
        return new ChromeDriver();
    };

    private static final Map<String,Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome",chromeSupplier);
        MAP.put("firefox",firefoxSupplier);
    }

    public static WebDriver getDriver(String browser){
        return MAP.get(browser).get();
    }
}
