import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import utils.Sleeper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Женя on 23.06.2017.
 */
public class TestFirst {

    WebDriver webDriver;

    //TestData
    List<String> namesOfItemTopMenu;
    List<String> titlesSubmenu;
    List<String> titlesLeftMenu;

    @Before
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", Parameters.getWebdriverChromeDriver());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Parameters.getImplicityWait(), TimeUnit.SECONDS);
        webDriver.get(Parameters.getBaseUrl());
    }

    @Before
    public void setUpTestData(){
        namesOfItemTopMenu = new ArrayList<>();
        namesOfItemTopMenu.add("Home");
        namesOfItemTopMenu.add("Subjects");
        namesOfItemTopMenu.add("About Wiley");
        namesOfItemTopMenu.add("Contact Us");
        namesOfItemTopMenu.add("Help");

        titlesSubmenu = new ArrayList<>();
        titlesSubmenu.add("Students");
        titlesSubmenu.add("Authors");
        titlesSubmenu.add("Instructors");
        titlesSubmenu.add("Librarians");
        titlesSubmenu.add("Societies");
        titlesSubmenu.add("Conferences");
        titlesSubmenu.add("Booksellers");
        titlesSubmenu.add("Corporations");
        titlesSubmenu.add("Institutions");

        titlesLeftMenu = new ArrayList<>();
        titlesLeftMenu.add("Authors");
        titlesLeftMenu.add("Librarians");
        titlesLeftMenu.add("Booksellers");
        titlesLeftMenu.add("Instructors");
        titlesLeftMenu.add("Students");
        titlesLeftMenu.add("Government Employees");
        titlesLeftMenu.add("Societies");
        titlesLeftMenu.add("Corporate Partners");
    }

    @Test
    public void firstTest(){

        //Step 1
        HomePage homePage = new HomePage(webDriver);
        TopNavigationMenu topNavigationMenuFromHomePage = homePage.getTopNavigationMenu();
        Assert.assertTrue("Названия кнопок в верхнем меню на главной странице не соответсвуют ожидаемым",
                topNavigationMenuFromHomePage.checkNameOfItemTopMenu(namesOfItemTopMenu));

        //Step 2
        SubHeaderMenu subHeaderMenu = homePage.getSubHeaderMenu();
        Assert.assertEquals("Количество элементов подменю на главной странице не соответствует ожидаемому",
                9, subHeaderMenu.getCountItemSubmenu());
        Assert.assertTrue("Названия кнопок в верхнем меню на главной странице не соответствуют ожидаемым",
                subHeaderMenu.checkTitlesSubmenu(titlesSubmenu));

        //Step 3
        subHeaderMenu.clickItems("Students");
        StudentsPage studentsPage = new StudentsPage(webDriver);
        Assert.assertEquals("Адрес страницы [Students] не соответствует ожидаемому",
                "http://eu.wiley.com/WileyCDA/Section/id-404702.html", webDriver.getCurrentUrl());
        Assert.assertTrue("Заголовок страницы [Students] не отображен на странице",
                 studentsPage.isDisplayedHeader());

        //Step 4
        LeftMenu leftMenu = studentsPage.getLeftMenu();
        System.out.println("!!!!!!!!!!!! " + leftMenu);
        Sleeper.sleep(3);
        Assert.assertEquals("", 8, leftMenu.getCountItemSubmenu());
        //Assert.assertTrue("", leftMenu.checkTitlesSubmenu(titlesLeftMenu));

    }

    @After
    public void after(){
        webDriver.close();
    }
}
