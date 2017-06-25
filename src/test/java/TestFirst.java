import blocks.LeftMenu;
import blocks.ResourcesList;
import blocks.SignUpBlock;
import blocks.TopNavigationMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
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
        topNavigationMenu.checkNameOfItemTopMenu(dataForTest.getNamesOfItemTopMenu());

        //Step 2
        ResourcesList resourcesList = homePage.getResourcesList();
        resourcesList.checkCountItem(9);
        resourcesList.checkTitles(dataForTest.getTitlesSubmenu());

        //Step 3
        resourcesList.clickItem("Students");
        StudentsPage studentsPage = new StudentsPage(webDriver);
        AssertHelper.checkCurrentUrl(webDriver, dataForTest.getUrlStudentsPage());
        studentsPage.isDisplayedHeader();

        //Step 4
        LeftMenu leftMenu = studentsPage.getLeftMenu();
        leftMenu.checkCountItem(7);
        leftMenu.checkTitles(dataForTest.getTitlesLeftMenu());

        //Step 5
        leftMenu.checkItemSelected("Students");
        leftMenu.checkItemNotClickable("Students");

        //Step 6
        topNavigationMenu = studentsPage.getTopNavigationMenu();
        topNavigationMenu.clickItem("Home");
        homePage = new HomePage(webDriver);

        //Step 7
        SignUpBlock signUpBlock = homePage.getSignUpBlock();
        signUpBlock.clickNext();
        Alert alert = AlertHelper.getAlert(webDriver);
        AlertHelper.checkAlert(alert);
        AlertHelper.checkAlertText(alert, dataForTest.getTextAlertEmptyEmail());
        AlertHelper.confirmAlert(alert);

        //Step 8
        signUpBlock.typeEmail(dataForTest.getNotValidEmail());
        signUpBlock.clickNext();
        alert = AlertHelper.getAlert(webDriver);
        AlertHelper.checkAlert(alert);
        AlertHelper.checkAlertText(alert, dataForTest.getTextAlertNotValidEmail());
        AlertHelper.confirmAlert(alert);

        //Step 9
        topNavigationMenu = homePage.getTopNavigationMenu();
        topNavigationMenu.typeSearchInput(dataForTest.getTextForSearch());
        topNavigationMenu.clickSearch();
        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.checkListResultsIsNotEmpty();

        //Step 10
        String name = searchPage.clickOnRandomResultItem();
        ProductPage productPage = new ProductPage(webDriver);
        productPage.checkHeaderText(name);

        //Step 11
        topNavigationMenu = searchPage.getTopNavigationMenu();
        topNavigationMenu.clickItem("Home");

        //Step 12
        homePage = new HomePage(webDriver);
        resourcesList = homePage.getResourcesList();
        WindowHelper.saveCurrentWindows(webDriver);
        resourcesList.clickItem("Institutions");
        WindowHelper.switchNewWindow(webDriver);
        AssertHelper.checkCurrentUrl(webDriver, dataForTest.getUrlInstitutionsPage());
    }

    @After
    public void quitWebDriver(){
        webDriver.quit();
    }
}
