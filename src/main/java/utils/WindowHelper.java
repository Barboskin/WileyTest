package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by Женя on 24.06.2017.
 */
public class WindowHelper {

    private static Set<String> windows;

    public static void saveCurrentWindows(WebDriver driver){
        windows = driver.getWindowHandles();
    }

    public static boolean switchNewWindow(WebDriver driver){
        Set<String> newWindows = driver.getWindowHandles();
        newWindows.removeAll(windows);
        if (newWindows.isEmpty()){
            return false;
        }
        String newWindow = newWindows.iterator().next();
        driver.switchTo().window(newWindow);
        return true;
    }
}
