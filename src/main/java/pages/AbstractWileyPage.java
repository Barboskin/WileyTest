package pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * Created by Женя on 23.06.2017.
 */
public abstract class AbstractWileyPage {

    private TopNavigationMenu topNavigationMenu;
    private SubHeaderMenu subHeaderMenu;
    private LeftMenu leftMenu;

    @Name("Заголовок")
    @FindBy(xpath = "//h1")
    private TextBlock header;

    public boolean isDisplayedHeader(){
        return header.isDisplayed();
    }


    //getters
    public TopNavigationMenu getTopNavigationMenu() {
        return topNavigationMenu;
    }

    public SubHeaderMenu getSubHeaderMenu() {
        return subHeaderMenu;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }
}
