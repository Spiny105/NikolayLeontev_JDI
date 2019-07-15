package lesson_jdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import lesson_jdi.entities.Users;
import lesson_jdi.enums.HeaderItems;
import lesson_jdi.forms.HeaderItemsSection;
import lesson_jdi.forms.LoginForm;
import org.hamcrest.Matchers;

@Url("index.html")
@Title("Home Page")
public class JdiHomePage extends WebPage {

    private LoginForm loginForm;
    private HeaderItemsSection headerItemsForms;

    public void login(Users user) {
        loginForm.login(user);
    }

    public void assertLoggedIn(Users user) {
        loginForm.getUserName().shouldBe().text(Matchers.equalTo(user.getFullName()));
    }

    public void goToMetalAndColorsPage() {
        headerItemsForms.clickOnItem(HeaderItems.METALS_AND_COLORS);
    }
}
