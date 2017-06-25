package utils;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

/**
 * Created by Женя on 25.06.2017.
 */
public class AssertHelper {

    private static Logger log = Logger.getLogger(AssertHelper.class.getName());

    public static void checkCurrentUrl(WebDriver driver, String expected){
        String actual = driver.getCurrentUrl();
        log.info(String.format("Проверяем текущий URL. Ожидаемый: [%s]. Актуальный: [%s]", expected, actual));
        Assert.assertEquals("Текущий URL не соответствует ожидаемому",
                expected, actual);
    }
}
