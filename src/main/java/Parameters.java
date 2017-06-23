/**
 * Created by Женя on 23.06.2017.
 */
public class Parameters {

    private static final String BASE_URL = System.getProperty("base.url", "http://eu.wiley.com/WileyCDA/");

    private static final String WEBDRIVER_CHROME_DRIVER = System.getProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

    private static final String IMPLICITY_WAIT = System.getProperty("implicity_wait", "10");


    //getters

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getWebdriverChromeDriver() {
        return WEBDRIVER_CHROME_DRIVER;
    }

    public static int getImplicityWait() {
        return Integer.parseInt(IMPLICITY_WAIT);
    }
}
