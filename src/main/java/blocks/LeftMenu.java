package blocks;

import custom_type.LeftMenuButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import utils.ListHelper;

import java.util.List;

/**
 * Created by Женя on 23.06.2017.
 */
@Name("Левое_меню")
@FindBy(xpath = "//div[@class = 'autonav']")
public class LeftMenu extends HtmlElement {

    @Name("Список_кнопок_левого_меню")
    @FindBy(xpath = ".//ul[@class = 'autonavLevel1']/li")
    private List<LeftMenuButton> listLeftMenuButton;

    public int getCountItem(){
        return listLeftMenuButton.size();
    }

    public boolean checkTitles(List<String> exceptedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listLeftMenuButton);
        boolean flag = ListHelper.compareListStringByContent(actualList, exceptedList);
        return flag;
    }

   public boolean checkItemSelected(String itemText){
        TypifiedElement item = ListHelper.getTypifiedElementByText(listLeftMenuButton, itemText);
        return item.isSelected();
    }

    public boolean checkItemClickable(String itemText){
        LeftMenuButton item = (LeftMenuButton) ListHelper.getTypifiedElementByText(listLeftMenuButton, itemText);
        return item.isClickable();
    }
}
