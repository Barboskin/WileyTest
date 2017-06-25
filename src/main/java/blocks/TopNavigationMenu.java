package blocks;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import utils.ListHelper;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Женя on 23.06.2017.
 */

@Name("Верхнее_меню")
@FindBy(xpath = "//div[@id = 'links-site']")
public class TopNavigationMenu extends HtmlElement {

    private static Logger log = Logger.getLogger(TopNavigationMenu.class.getName());

    @Name("Список_кнопок_верхнего_меню")
    @FindBy(xpath = ".//li")
    private List<Button> listTopNavigationMenuButton;

    @Name("Строка_поиска")
    @FindBy(xpath = ".//input[@for = 'search']")
    private TextInput searchTextInput;

    @Name("Кнопка_искать")
    @FindBy(xpath = ".//input[@type = 'submit']")
    private Button searchButton;

    public boolean checkNameOfItemTopMenu(List<String> expectedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listTopNavigationMenuButton);
        log.info(String.format("Проверяем значения списка кнопок верхнего меню. Ожидаемые: [%s]. Актуальные: [%s]",
                expectedList.toString(), actualList.toString()));
        boolean flag = ListHelper.compareListStringByContent(actualList, expectedList);
        return flag;
    }

    public void clickItem(String itemText){
        log.info(String.format("Выполняем нажатие на элемент с текстом [%s] из списка кнопок верхнего меню",
                itemText));
        TypifiedElement item = ListHelper.getTypifiedElementByText(listTopNavigationMenuButton, itemText);
        item.click();
    }

    public void typeSearchInput(String text){

        log.info(String.format("Заполняем поле Search текстом [%s]", text));
        searchTextInput.sendKeys(text);
    }

    public void clickSearch(){
        log.info(String.format("Выполняем нажатие на кнопку Искать в верхнем меню"));
        searchButton.click();
    }
}
