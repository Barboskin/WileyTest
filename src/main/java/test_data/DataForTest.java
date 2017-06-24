package test_data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Женя on 24.06.2017.
 */
public class DataForTest {

    private List<String> namesOfItemTopMenu;
    private List<String> titlesSubmenu;
    private List<String> titlesLeftMenu;
    private final String textAlertEmptyEmail = "Please enter email address";
    private final String textAlertNotValidEmail = "Invalid email address.";
    private final String notValidEmail = "email";
    private final String textForSearch = "for dummies";
    private final String urlInstitutionsPage = "https://edservices.wiley.com/";
    private final String urlStudentsPage = "http://eu.wiley.com/WileyCDA/Section/id-404702.html";

    public List<String> getNamesOfItemTopMenu() {
        namesOfItemTopMenu = new ArrayList<>();
        namesOfItemTopMenu.add("Home");
        namesOfItemTopMenu.add("Subjects");
        namesOfItemTopMenu.add("About Wiley");
        namesOfItemTopMenu.add("Contact Us");
        namesOfItemTopMenu.add("Help");
        return namesOfItemTopMenu;
    }

    public List<String> getTitlesSubmenu() {
        titlesSubmenu = new ArrayList<>();
        titlesSubmenu.add("Students");
        titlesSubmenu.add("Authors");
        titlesSubmenu.add("Instructors");
        titlesSubmenu.add("Librarians");
        titlesSubmenu.add("Societies");
        titlesSubmenu.add("Conferences");
        titlesSubmenu.add("Booksellers");
        titlesSubmenu.add("Corporations");
        titlesSubmenu.add("Institutions");
        return titlesSubmenu;
    }

    public List<String> getTitlesLeftMenu() {
        titlesLeftMenu = new ArrayList<>();
        titlesLeftMenu.add("Authors");
        titlesLeftMenu.add("Librarians");
        titlesLeftMenu.add("Booksellers");
        titlesLeftMenu.add("Instructors");
        titlesLeftMenu.add("Students");
        titlesLeftMenu.add("Societies");
        titlesLeftMenu.add("Corporate Partners");
        return titlesLeftMenu;
    }

    public String getTextAlertEmptyEmail() {
        return textAlertEmptyEmail;
    }

    public String getTextAlertNotValidEmail() {
        return textAlertNotValidEmail;
    }

    public String getNotValidEmail() {
        return notValidEmail;
    }

    public String getTextForSearch() {
        return textForSearch;
    }

    public String getUrlInstitutionsPage() {
        return urlInstitutionsPage;
    }

    public String getUrlStudentsPage() {
        return urlStudentsPage;
    }
}
