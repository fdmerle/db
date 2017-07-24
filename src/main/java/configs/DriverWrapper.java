package configs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


public class DriverWrapper {

    private WebDriver webDriver;

    public void setWebDriver(DriverTypes driverType) {
        switch (driverType) {

            case Chrome:
                System.setProperty("webdriver.chrome.driver", Paths.get("src\\main", "resources", "chromedriver.exe").toString());
                webDriver = new ChromeDriver();
                implicitDelay(webDriver,10);

                break;
            case FireFox:
                webDriver = new FirefoxDriver();
                implicitDelay(webDriver,10);

                break;
            case IE:
                webDriver = new InternetExplorerDriver();
                break;
            default:
                webDriver = null;
        }

    }
    private void implicitDelay(WebDriver webDriver,int delay){
        webDriver.manage().timeouts().implicitlyWait(delay, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

    }


    public boolean waitElementToBeVisible(String webElementXpath,int timeOut){
        WebDriverWait wait = new WebDriverWait(getWebDriver(),timeOut);
        try {
            wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.xpath(webElementXpath))));
            return true;
        }catch (Exception e){
            System.out.println("Netu: "+webElementXpath);
            return false;
        }
    }


    public void waitElementToBeActive(String webElementXpath,int timeOut){
        WebDriverWait wait = new WebDriverWait(getWebDriver(),timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementXpath)));
    }

    public void waitElementToBecomeInvisible(String webElementXpath, int timeOut){
        WebDriverWait wait = new WebDriverWait(getWebDriver(),timeOut);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(webElementXpath)));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }


}
