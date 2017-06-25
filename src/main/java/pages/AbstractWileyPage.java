package pages;

import blocks.LeftMenu;
import blocks.TopNavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.logging.Logger;

/**
 * Created by Женя on 23.06.2017.
 */
public abstract class AbstractWileyPage {

    private static Logger log = Logger.getLogger(AbstractWileyPage.class.getName());

    private TopNavigationMenu topNavigationMenu;
    private LeftMenu leftMenu;

    @Name("Заголовок")
    @FindBy(xpath = "//h1")
    private TextBlock header;

    public boolean isDisplayedHeader(){
        log.info(String.format("Проверяем наличие заголовка на текущий странице"));
        boolean flag = header.isDisplayed();
        Assert.assertTrue("Заголовок не отображен на текущей странице",
                flag);
        return flag;
    }

    public boolean checkHeaderText(String expectedName){
        String actualName = header.getText();
        log.info(String.format("Проверяем значение заголовка продукта. Ожидаемое: [%s]. Актуальное: [%s]",
                expectedName, actualName));
        boolean flag = actualName.equals(expectedName);
        Assert.assertTrue("Заголовок текущей страницы не соответствует заданному",
                flag);
        return flag;
    }


    //getters
    public TopNavigationMenu getTopNavigationMenu() {
        return topNavigationMenu;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }
}
