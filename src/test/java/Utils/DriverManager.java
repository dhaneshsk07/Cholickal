package Utils;


import org.openqa.selenium.WebDriver;

//This class created for ScreenshotUtils to Thread-safe DriverManager (REQUIRED)
public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void unload() {
        driver.remove();
    }
}
