package blocks;

import custom_type.LeftMenuButton;
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

    public int getCountItem(){
        log.info(String.format("Получаем количество элементов списка кнопок левого меню"));
        return listLeftMenuButton.size();
    }

    public boolean checkTitles(List<String> expectedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listLeftMenuButton);
        log.info(String.format("Проверяем значения кнопок левого меню. Ожидаемые: [%s]. Актуальные: [%s]",
                expectedList.toString(), actualList.toString()));
        boolean flag = ListHelper.compareListStringByContent(actualList, expectedList);
        return flag;
    }

   public boolean checkItemSelected(String itemText){
       log.info(String.format("Проверяем является ли элемент с текстом [%s] текущим выбранным",
               itemText));
        TypifiedElement item = ListHelper.getTypifiedElementByText(listLeftMenuButton, itemText);
        return item.isSelected();
    }

    public boolean checkItemClickable(String itemText){
        log.info(String.format("Проверяем является ли элемент с текстом [%s] кликабельным",
                itemText));
        LeftMenuButton item = (LeftMenuButton) ListHelper.getTypifiedElementByText(listLeftMenuButton, itemText);
        return item.isClickable();
    }
}
