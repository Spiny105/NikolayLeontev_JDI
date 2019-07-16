package lesson_jdi;

import com.epam.jdi.light.driver.get.DriverData;
import lesson_jdi.entities.Defaults;
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
        JdiSite.homePage.login(Defaults.DEFAULT_USER);
        JdiSite.homePage.assertLoggedIn(Defaults.DEFAULT_USER);
        JdiSite.homePage.goToMetalAndColorsPage();
        JdiSite.metalsAndColorsPage.submitData(Defaults.METAL_AND_COLORS_DEFAULT_INPUT);
        JdiSite.metalsAndColorsPage.assertResultSection(Defaults.METAL_AND_COLORS_DEFAULT_INPUT);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
