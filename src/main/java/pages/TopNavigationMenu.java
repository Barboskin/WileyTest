package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.ListHelper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Женя on 23.06.2017.
 */

@Name("Верхнее_меню")
@FindBy(xpath = "//div[@id = 'links-site']")
public class TopNavigationMenu extends HtmlElement {

    @Name("Список_кнопок_верхнего_меню")
    @FindBy(xpath = ".//li")
    private List<WebElement> listTopNavigationMenuButton;

    @Name("Строка_поиска")
    @FindBy(xpath = ".//input[@for = 'search']")
    private TextInput searchTextInput;

    @Name("Кнопка_искать")
    @FindBy(xpath = ".//input[@type = 'submit']")
    private Button searchButton;

    public boolean checkNameOfItemTopMenu(List<String> exceptedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listTopNavigationMenuButton);

        boolean flag = ListHelper.compareListStringByContent(actualList, exceptedList);
        return flag;
    }
}
