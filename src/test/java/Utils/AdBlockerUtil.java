package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AdBlockerUtil {

    public static void removeGoogleAds(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll(" +
            "'iframe[id^=\"google_ads_iframe\"], iframe[src*=\"googlesyndication\"]'" +
            ").forEach(e => e.remove());"
        );
    }
}

