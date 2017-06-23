import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Женя on 23.06.2017.
 */
public class TestFirst {

    WebDriver webDriver;

    //TestData
    List<String> listNamesOfItemTopMenu;

    @Before
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", Parameters.WEBDRIVER_CHROME_DRIVER);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(Parameters.BASE_URL);
    }

    @Before
    public void setUpTestData(){
        listNamesOfItemTopMenu = new ArrayList<>();
        listNamesOfItemTopMenu.add("Home");
        listNamesOfItemTopMenu.add("Subjects");
        listNamesOfItemTopMenu.add("About Wiley");
        listNamesOfItemTopMenu.add("Contact Us");
        listNamesOfItemTopMenu.add("Help");
    }

    @Test
    public void firstTest(){
        HomePage homePage = new HomePage(webDriver);
        Assert.assertTrue("Названия кнопок в верхнем меню на главной странице не соответсвуют ожидаемым",
                homePage.getTopNavigationMenu().checkNameOfItemTopMenu(listNamesOfItemTopMenu));
    }

    @After
    public void after(){
        webDriver.close();
    }
}
