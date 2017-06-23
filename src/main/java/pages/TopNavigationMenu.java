package pages;


import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

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
    private List<Button> listTopNavigationButton;

    @Name("Строка_поиска")
    @FindBy(xpath = ".//input[@for = 'search']")
    private TextInput searchTextInput;

    @Name("Кнопка_искать")
    @FindBy(xpath = ".//input[@type = 'submit']")
    private Button searchButton;

    public boolean checkNameOfItemTopMenu(List<String> listNamesOfItemTopMenu){
        List<String> actualListNamesOfItemTopMenu = listTopNavigationButton.stream().
                map(x -> x.getText()).collect(Collectors.toList());

        boolean flag = false;

        if (actualListNamesOfItemTopMenu.size() == listNamesOfItemTopMenu.size()) {
            for (int i = 0; i < actualListNamesOfItemTopMenu.size(); i++) {
                flag = actualListNamesOfItemTopMenu.get(i).equals(listNamesOfItemTopMenu.get(i));
            }
        }
        return flag;
    }
}
