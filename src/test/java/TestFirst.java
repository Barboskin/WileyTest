import blocks.LeftMenu;
import blocks.ResourcesList;
import blocks.SignUpBlock;
import blocks.TopNavigationMenu;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;
import pages.StudentsPage;
import rules.WatcherRule;
import test_data.DataForTest;
import utils.*;

/**
 * Created by Женя on 23.06.2017.
 */
public class TestFirst {

    @Rule
    public WatcherRule watcherRule = new WatcherRule();

    private WebDriver webDriver;
    private DataForTest dataForTest;

    @Before
    public void setUpDriver(){
        webDriver = DriverManager.getInstance();
        webDriver.manage().window().maximize();
        webDriver.get(Parameters.getBaseUrl());
    }

    @Before
    public void setUpTestData(){
        dataForTest = new DataForTest();
    }

    @Test
    public void firstTest(){

        //Step 1
        HomePage homePage = new HomePage(webDriver);
        TopNavigationMenu topNavigationMenu = homePage.getTopNavigationMenu();
        Assert.assertTrue("Названия кнопок в верхнем меню на главной странице не соответсвуют ожидаемым",
                topNavigationMenu.checkNameOfItemTopMenu(dataForTest.getNamesOfItemTopMenu()));

        //Step 2
        ResourcesList resourcesList = homePage.getResourcesList();
        Assert.assertEquals("Количество элементов подменю на главной странице не соответствует ожидаемому",
                9, resourcesList.getCountItem());
        Assert.assertTrue("Названия кнопок в верхнем меню на странице [Home] не соответствуют ожидаемым",
                resourcesList.checkTitles(dataForTest.getTitlesSubmenu()));

        //Step 3
        resourcesList.clickItem("Students");
        StudentsPage studentsPage = new StudentsPage(webDriver);
        Assert.assertEquals("Адрес страницы [Students] не соответствует ожидаемому",
                dataForTest.getUrlStudentsPage(), webDriver.getCurrentUrl());
        Assert.assertTrue("Заголовок страницы [Students] не отображен на странице",
                 studentsPage.isDisplayedHeader());

        //Step 4
        LeftMenu leftMenu = studentsPage.getLeftMenu();
        Assert.assertEquals("Количество элементов левого меню на странице [Students] не соответствует ожидаемому",
                7, leftMenu.getCountItem());
        Assert.assertTrue("Названия кнопок в левом меню на странице [Students] не соответствуют ожидаемым",
                leftMenu.checkTitles(dataForTest.getTitlesLeftMenu()));

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
                dataForTest.getTextAlertEmptyEmail(), alert.getText());
        alert.accept();

        //Step 8
        signUpBlock.typeEmail(dataForTest.getNotValidEmail());
        signUpBlock.clickNext();
        alert = AlertHelper.getAlert(webDriver);
        Assert.assertNotEquals("Алерт не появился на странице [Home]", null, alert);
        Assert.assertEquals("Текст алерта на странице [Home] не соответствует ожидаемому",
                dataForTest.getTextAlertNotValidEmail(), alert.getText());
        alert.accept();

        //Step 9
        topNavigationMenu = homePage.getTopNavigationMenu();
        topNavigationMenu.typeSearchInput(dataForTest.getTextForSearch());
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
                dataForTest.getUrlInstitutionsPage(), currentUrl);
    }

    @After
    public void quitWebDriver(){
        webDriver.quit();
    }
}
