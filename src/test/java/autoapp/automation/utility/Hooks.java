package autoapp.automation.utility;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends BaseUtil{

    private BaseUtil baseUtil;

    public Hooks(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
        this.driver = baseUtil.driver;
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        baseUtil.driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        baseUtil.driver.quit();
    }

    private String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }
}
