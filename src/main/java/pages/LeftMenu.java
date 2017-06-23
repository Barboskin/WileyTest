package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import utils.ListHelper;

import java.util.List;

/**
 * Created by Женя on 23.06.2017.
 */
@Name("Левое_меню")
@FindBy(xpath = "//div[@id = 'sidebar']")
public class LeftMenu {

    @Name("Список_кнопок_левого_меню")
    @FindBy(xpath = ".//ul[@class = 'autonavLevel1']/li")
    private List<WebElement> listLeftMenuButton;

    public int getCountItemSubmenu(){
        return listLeftMenuButton.size();
    }

    public boolean checkTitlesSubmenu(List<String> exceptedList){
        List<String> actualList = ListHelper.getListStringFromListWebElement(listLeftMenuButton);

        boolean flag = ListHelper.compareListStringByContent(actualList, exceptedList);
        return flag;
    }
}
