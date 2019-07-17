package lesson_jdi;

import com.epam.jdi.light.driver.get.DriverData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lesson_jdi.entities.Defaults;
import lesson_jdi.entities.MetalsAndColorsInput;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class JdiSiteTest {

    public static final String TEST_DATA_SETS_JSON_PATH = ".\\src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "MetalsAndColorsDataProvider")
    public Object[] MetalsAndColorsDataProvider() {

        Map<String, MetalsAndColorsInput> inputDataSets = new HashMap<>();
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(TEST_DATA_SETS_JSON_PATH));
            Type type = new TypeToken<Map<String, MetalsAndColorsInput>>() {
            }.getType();
            inputDataSets = gson.fromJson(br, type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return inputDataSets.values().toArray();
    }

    @BeforeClass
    public void beforeClass() {
        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions cap = new ChromeOptions();
            cap.addArguments("--start-maximized");
            return cap;
        };
        initElements(JdiSite.class);
    }


    @Test(dataProvider = "MetalsAndColorsDataProvider")
    public void testScenario(MetalsAndColorsInput inputData) {

        JdiSite.homePage.driver().manage().deleteAllCookies();
        JdiSite.open();
        JdiSite.homePage.login(Defaults.DEFAULT_USER);
        JdiSite.homePage.assertLoggedIn(Defaults.DEFAULT_USER);
        JdiSite.homePage.goToMetalAndColorsPage();
        JdiSite.metalsAndColorsPage.submitData(inputData);
        JdiSite.metalsAndColorsPage.assertResultSection(inputData);
    }

    @AfterClass
    public void afterClass() {
        killAllSeleniumDrivers();
    }
}
