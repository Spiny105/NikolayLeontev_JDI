package lesson_jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import lesson_jdi.pages.JdiHomePage;

@JSite("https://epam.github.io/JDI/")
public class JdiSite {
    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage homePage;

    public static void open() {
        homePage.open();
    }
}
