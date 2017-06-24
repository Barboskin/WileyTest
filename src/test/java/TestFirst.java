import blocks.LeftMenu;
import blocks.ResourcesList;
import blocks.SignUpBlock;
import blocks.TopNavigationMenu;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;
import pages.StudentsPage;
import rules.WatcherRule;
import utils.AlertHelper;
import utils.ListHelper;
import utils.WindowHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Женя on 23.06.2017.
 */
public class TestFirst {

    @Rule
    public WatcherRule watcherRule = new WatcherRule();

    private WebDriver webDriver;

    //TestData
    private List<String> namesOfItemTopMenu;
    private List<String> titlesSubmenu;
    private List<String> titlesLeftMenu;
    private String textAlertEmptyEmail;
    private String textAlertNotValidEmail;
    private String notValidEmail;
    private String textForSearch;
    private String urlStudentsPage;
    private String urlInstitutionsPage;

    @Before
    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", Parameters.getWebdriverChromeDriver());
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Parameters.getImplicityWait(), TimeUnit.SECONDS);
        webDriver.get(Parameters.getBaseUrl());
        webDriver.manage().window().maximize();
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
        titlesLeftMenu.add("Societies");
        titlesLeftMenu.add("Corporate Partners");

        textAlertEmptyEmail = "Please enter email address";
        textAlertNotValidEmail = "Invalid email address.";
        notValidEmail = "email";
        textForSearch = "for dummies";
        urlInstitutionsPage = "https://edservices.wiley.com/";
        urlStudentsPage = "http://eu.wiley.com/WileyCDA/Section/id-404702.html";
    }

    @Test
    public void firstTest(){

        //Step 1
        HomePage homePage = new HomePage(webDriver);
        TopNavigationMenu topNavigationMenu = homePage.getTopNavigationMenu();
        Assert.assertTrue("Названия кнопок в верхнем меню на главной странице не соответсвуют ожидаемым",
                topNavigationMenu.checkNameOfItemTopMenu(namesOfItemTopMenu));

        //Step 2
        ResourcesList resourcesList = homePage.getResourcesList();
        Assert.assertEquals("Количество элементов подменю на главной странице не соответствует ожидаемому",
                9, resourcesList.getCountItem());
        Assert.assertTrue("Названия кнопок в верхнем меню на главной странице не соответствуют ожидаемым",
                resourcesList.checkTitles(titlesSubmenu));

        //Step 3
        resourcesList.clickItem("Students");
        StudentsPage studentsPage = new StudentsPage(webDriver);
        Assert.assertEquals("Адрес страницы [Students] не соответствует ожидаемому",
                urlStudentsPage, webDriver.getCurrentUrl());
        Assert.assertTrue("Заголовок страницы [Students] не отображен на странице",
                 studentsPage.isDisplayedHeader());

        //Step 4
        LeftMenu leftMenu = studentsPage.getLeftMenu();
        Assert.assertEquals("Количество элементов левого меню на странице [Students] не соответствует ожидаемому",
                7, leftMenu.getCountItem());
        Assert.assertTrue("", leftMenu.checkTitles(titlesLeftMenu));

        //Step 5
        Assert.assertTrue("В левом меню на странице [Students] пункт [Students] не является выбранным",
                leftMenu.checkItemSelected("Students"));
        Assert.assertFalse("В левом меню на странице [Students] пункт [Students] является кликабельным",
                leftMenu.checkItemClickable("Students"));

        //Step 6
        topNavigationMenu = studentsPage.getTopNavigationMenu();
        topNavigationMenu.clickItem("Home");
        homePage = new HomePage(webDriver);

        //Step 7
        SignUpBlock signUpBlock = homePage.getSignUpBlock();
        signUpBlock.clickNext();
        Alert alert = AlertHelper.getAlert(webDriver);
        Assert.assertNotEquals("Алерт не появился на странице [Home]", null, alert);
        Assert.assertEquals("Текст алерта на странице [Home] не соответствует ожидаемому",
                textAlertEmptyEmail, alert.getText());
        alert.accept();

        //Step 8
        signUpBlock.typeEmail(notValidEmail);
        signUpBlock.clickNext();
        alert = AlertHelper.getAlert(webDriver);
        Assert.assertNotEquals("Алерт не появился на странице [Home]", null, alert);
        Assert.assertEquals("Текст алерта на странице [Home] не соответствует ожидаемому",
                textAlertNotValidEmail, alert.getText());
        alert.accept();

        //Step 9
        topNavigationMenu = homePage.getTopNavigationMenu();
        topNavigationMenu.typeSearchInput(textForSearch);
        topNavigationMenu.clickSearch();
        SearchPage searchPage = new SearchPage(webDriver);
        Assert.assertFalse("Список результов поиска на отобразился на странице [Search]",
                ListHelper.isEmpty(searchPage.getListResultItems()));

        //Step 10
        String name = searchPage.clickOnRandomResultItem();
        ProductPage productPage = new ProductPage(webDriver);
        Assert.assertTrue("Заголовок страницы [Product] не соответствует заданному",
                productPage.checkNameOfProduct(name));

        //Step 11
        topNavigationMenu = searchPage.getTopNavigationMenu();
        topNavigationMenu.clickItem("Home");

        //Step 12
        homePage = new HomePage(webDriver);
        resourcesList = homePage.getResourcesList();
        WindowHelper.saveCurrentWindows(webDriver);
        resourcesList.clickItem("Institutions");
        boolean isNewWindow = WindowHelper.switchNewWindow(webDriver);
        Assert.assertTrue("Страница не открылась в новой вкладке", isNewWindow);
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals("URL страницы [Institutions] не соответствует ожидаемому",
                urlInstitutionsPage, currentUrl);
    }

    @After
    public void quitWebDriver(){
        webDriver.quit();
    }
}
