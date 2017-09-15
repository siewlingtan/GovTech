package Steps;

import BaseUtil.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hook extends Base{

    public Base base;

    public Hook(Base base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(){

        System.setProperty("webdriver.gecko.driver","C:\\\\Libs\\\\geckodriver.exe");
        base.Driver = new FirefoxDriver();
        base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Chrome driver
        /*System.setProperty("webdriver.chrome.driver","C:\\\\Libs\\\\chromedriver.exe");
        base.Driver = new ChromeDriver();
        base.Driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/

    }

    @After
    public void TearDownTest(){

        //base.Driver.quit();
    }
}
