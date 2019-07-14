package lesson_jdi;

import com.epam.jdi.light.driver.get.DriverData;
import lesson_jdi.entities.MetalsAndColorsInput;
import lesson_jdi.entities.Users;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class JdiSiteTest {
    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }

    @Test
    public void testScenario() {
        JdiSite.open();
        JdiSite.homePage.login(Users.PETER);
        JdiSite.homePage.assertLoggedIn(Users.PETER);
        JdiSite.homePage.goToMetalAndColorsPage();
        JdiSite.metalsAndColorsPage.submitData(MetalsAndColorsInput.TESTDATA1);
        JdiSite.metalsAndColorsPage.assertResultSection(MetalsAndColorsInput.TESTDATA1);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
