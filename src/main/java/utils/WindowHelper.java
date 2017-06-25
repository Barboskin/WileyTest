package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by Женя on 24.06.2017.
 */
public class WindowHelper {

    private static Logger log = Logger.getLogger(WindowHelper.class.getName());

    private static Set<String> windows;

    public static void saveCurrentWindows(WebDriver driver){
        log.info(String.format("Сохраняем текущий спискок окон"));
        windows = driver.getWindowHandles();
    }

    public static boolean switchNewWindow(WebDriver driver){
        log.info(String.format("Выполняем переключение в новое окно"));
        Set<String> newWindows = driver.getWindowHandles();
        newWindows.removeAll(windows);
        boolean flag = false;
        if (!newWindows.isEmpty()){
            String newWindow = newWindows.iterator().next();
            driver.switchTo().window(newWindow);
            flag = true;
        }
        Assert.assertTrue("Страница не открылась в новой вкладке", flag);
        return flag;
    }
}
