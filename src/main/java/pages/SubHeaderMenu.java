package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import utils.ListHelper;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Женя on 23.06.2017.
 */
@Name("Подменю")
@FindBy(xpath = "//div[@id = 'homepage-resources']")
public class SubHeaderMenu extends HtmlElement {

    @Name("Список_кнопок_подменю")
    @FindBy(xpath = ".//li")
    private List<WebElement> listSubmenuButton;

    public int getCountItemSubmenu(){
        return listSubmenuButton.size();
    }

    public boolean checkTitlesSubmenu(List<String> exceptedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listSubmenuButton);

        boolean flag = ListHelper.compareListStringByContent(actualList, exceptedList);
        return flag;
    }

    public void clickItems(String itemText){
        WebElement item = ListHelper.getWebElementByText(listSubmenuButton, itemText);
        item.click();
    }

}
