package blocks;

import custom_type.LeftMenuButton;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import utils.ListHelper;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Женя on 23.06.2017.
 */
@Name("Левое_меню")
@FindBy(xpath = "//div[@class = 'autonav']")
public class LeftMenu extends HtmlElement {

    private static Logger log = Logger.getLogger(LeftMenu.class.getName());

    @Name("Список_кнопок_левого_меню")
    @FindBy(xpath = ".//ul[@class = 'autonavLevel1']/li")
    private List<LeftMenuButton> listLeftMenuButton;

    public int checkCountItem(int expected){
        int actual = listLeftMenuButton.size();
        log.info(String.format("Проверяем количество элементов левого меню. Ожидаемое: [%d]. Актуальные: [%d]",
                expected, actual));
        Assert.assertEquals("Количество элементов левого меню не соответствует ожидаемому",
                expected, actual);
        return actual;
    }

    public boolean checkTitles(List<String> expectedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listLeftMenuButton);
        log.info(String.format("Проверяем значения кнопок левого меню. Ожидаемые: [%s]. Актуальные: [%s]",
                expectedList.toString(), actualList.toString()));
        boolean flag = ListHelper.compareListStringByContent(actualList, expectedList);
        Assert.assertTrue("Названия кнопок левого меню не соответсвуют ожидаемым", flag);
        return flag;
    }

    public boolean checkItemSelected(String itemText) {
        log.info(String.format("Проверяем является ли элемент с текстом [%s] текущим выбранным",
                itemText));
        TypifiedElement item = ListHelper.getTypifiedElementByText(listLeftMenuButton, itemText);
        boolean flag = item.isSelected();
        Assert.assertTrue(String.format("В левом меню пункт c текстом [%s] не является выбранным", itemText),
                flag);
        return flag;
    }

    public boolean checkItemNotClickable(String itemText){
        log.info(String.format("Проверяем является ли элемент с текстом [%s] некликабельным",
                itemText));
        LeftMenuButton item = (LeftMenuButton) ListHelper.getTypifiedElementByText(listLeftMenuButton, itemText);
        boolean flag = item.isClickable();
        Assert.assertFalse(String.format("В левом меню пункт c текстом [%s] является кликабельны", itemText),
                flag);
        return flag;
    }
}
