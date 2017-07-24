package pages;

import configs.DriverWrapper;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;


public class dbMain {
    DriverWrapper driver;


    public String searchFieldXpath = ".//*[@id='searchbox']";
    public String addNewButton = ".//*[@id='add']";
    public String filterByNameButton = ".//*[@id='searchsubmit']";
    public String searchResult = "//*[text()='%s']";
    public String compNameField = ".//*[@id='name']";
    public String introDateField = ".//*[@id='introduced']";
    public String discDateField = ".//*[@id='discontinued']";
    public String companyDropDown = ".//*[@id='company']";
    public String saveThis = ".//*[@value='Create this computer']";
    public String saveButton =".//*[@value='Save this computer']";
    public String deleteThisComp = ".//input[@value = 'Delete this computer']";

    public WebElement searchField;
    public WebElement addNew;
    public WebElement filterByName;
    public WebElement search;
    public WebElement compName;
    public WebElement introDate;
    public WebElement discDate;
    public WebElement company;
    public WebElement saveThisButton;


    public dbMain(DriverWrapper driverWrapper) {

        driver = driverWrapper;
        searchField = driver.getWebDriver().findElement(By.xpath(searchFieldXpath));
        filterByName = driver.getWebDriver().findElement(By.xpath(filterByNameButton));
        addNew = driver.getWebDriver().findElement(By.xpath(addNewButton));

    }

    public void pressNew() {
        addNew.click();
    }

    public void fillCompForm(DataTable data) {

        compName = driver.getWebDriver().findElement(By.xpath(compNameField));
        introDate = driver.getWebDriver().findElement(By.xpath(introDateField));
        discDate = driver.getWebDriver().findElement(By.xpath(discDateField));
        company = driver.getWebDriver().findElement(By.xpath(companyDropDown));


        Map<String,String>dataToFill = data.asMap(String.class, String.class);
        compName.clear();
        compName.sendKeys(dataToFill.get("computerName"));
        introDate.clear();
        introDate.sendKeys(dataToFill.get("IntroDate"));
        discDate.clear();
        discDate.sendKeys((dataToFill.get("DiscDate")));
        company.sendKeys((dataToFill.get("CompName")));


    }

    public void pressCreate() {
        saveThisButton = driver.getWebDriver().findElement(By.xpath(saveThis));
        saveThisButton.click();
    }

    public void enterNameToSearch(String compName) {
        driver.getWebDriver().findElement(By.xpath(searchFieldXpath)).sendKeys(compName);
    }

    public void pressOnRow(String arg) {

        search = driver.getWebDriver().findElement(By.xpath(String.format(searchResult, arg)));
        search.click();


    }

    public void varifyValues(DataTable data) {
        Map<String,String>dataToFill = data.asMap(String.class, String.class);
        Select select = new Select(driver.getWebDriver().findElement(By.xpath(companyDropDown)));
        Assert.assertEquals( driver.getWebDriver().findElement(By.xpath(compNameField)).getAttribute("value"), dataToFill.get("computerName"));
        Assert.assertEquals(driver.getWebDriver().findElement(By.xpath(introDateField)).getAttribute("value"), dataToFill.get("IntroDate"));
        Assert.assertEquals(driver.getWebDriver().findElement(By.xpath(discDateField)).getAttribute("value"), dataToFill.get("DiscDate"));
        Assert.assertEquals(select.getFirstSelectedOption().getText(), dataToFill.get("CompName"));


    }

    public void pressSave() {
        WebElement saveButtonObj =driver.getWebDriver().findElement(By.xpath(saveButton));
        saveButtonObj.click();
    }

    public void pressDelete() {
        WebElement deleteButton = driver.getWebDriver().findElement(By.xpath(deleteThisComp));
        deleteButton.click();


    }


    public void iPressFilterByNameButton() {
        driver.getWebDriver().findElement(By.xpath(filterByNameButton)).click();


    }

    public void listIsEmpty(String arg) {

        driver.getWebDriver().findElements(By.xpath(String.format(searchResult, arg)));

    }
}
