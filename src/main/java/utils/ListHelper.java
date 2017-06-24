package utils;

import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Женя on 23.06.2017.
 */
public class ListHelper {

    public static List<String> getListStringFromListWebElement(List<? extends TypifiedElement> webElements){
        List<String> result =  webElements.stream().map(x -> x.getText()).collect(Collectors.toList());
        return result;
    }

    public static boolean compareListStringByContent(List<String> list1, List<String> list2){
        boolean flag = false;

        if (list1.size() == list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                flag = list1.get(i).equals(list2.get(i));
            }
        }
        return flag;
    }

    public static TypifiedElement getTypifiedElementByText(List<? extends TypifiedElement> webElements, String text){
        List<TypifiedElement> findElements = webElements.stream().filter(x -> x.getText().equals(text)).collect(Collectors.toList());
        if (findElements.size() > 0){
            return findElements.get(0);
        } else {
            throw new RuntimeException(String.format("В заданном списке нет элемента с текстом [%s]", text));
        }
    }

    public static boolean isEmpty(List<? extends Object> list){
        if (list == null){
            return false;
        }
        return list.isEmpty();
    }

}
