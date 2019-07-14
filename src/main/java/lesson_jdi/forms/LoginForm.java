package lesson_jdi.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Label;
import com.epam.jdi.light.ui.html.common.TextField;
import lesson_jdi.entities.Users;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<Users> {
    @FindBy(css = "#name")
    private TextField login;

    @FindBy(css = "#password")
    private TextField password;

    @FindBy(css = "#login-button")
    private Button submit;

    @Css("#user-name")
    private Label userName;

    @Css(".profile-photo")
    private Button profilePhoto;

    @Override
    public void login(Users user) {
        profilePhoto.click();
        login.input(user.getLogin());
        password.input(user.getPassword());

        submit.click();
    }

    public Label getUserName() {
        return userName;
    }
}
