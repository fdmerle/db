package step_definitions;

import configs.DriverTypes;
import configs.DriverWrapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.dbMain;

public class MainTest {
    public DriverWrapper driver = new DriverWrapper();
    dbMain dbMain;
    String bolUrl = "http://computer-database.herokuapp.com/";
    public static DriverTypes driverTypes;

    @BeforeTest
   public void initializeBolPage() {
        driver.setWebDriver(driverTypes.FireFox);
        driver.getWebDriver().get(bolUrl);
        dbMain = new dbMain(driver);


    }

    @AfterTest
    public void clean(){

        driver.getWebDriver().close();

    }
}
