package step_definitions;


import configs.DriverTypes;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.dbMain;


public class MyStepdefs extends MainTest {


    @Given("^I open db page in \"([^\"]*)\"$")
    public void iOpenDbPageIn(DriverTypes arg0) {
        driver.setWebDriver(arg0);
        driver.getWebDriver().get(bolUrl);
        dbMain = new dbMain(driver);
    }

    @When("^Press to the Add a new computer button$")
    public void pressToTheAddANewComputerButton() {
        dbMain.pressNew();

    }

    @And("^Filled the data fields with the values:$")
    public void filledTheDataFieldsWithTheValues(DataTable dataToFill) {
        dbMain.fillCompForm(dataToFill);

    }

    @And("^Press Create Computer button$")
    public void pressCreateComputerButton() {
        dbMain.pressCreate();

    }

    @And("^I type  computer name in Filter by computer name field$")
    public void iTypeComputerNameInFilterByComputerNameField(DataTable compName) {
        dbMain.enterNameToSearch(compName.asList(String.class).get(0));
    }

    @And("^Press on computer name in appeared row$")
    public void pressOnComputerNameInAppearedRow(DataTable compName) {

        dbMain.pressOnRow(compName.asList(String.class).get(0));

    }

    @Then("^in open window I have to be able to see values:$")
    public void inOpenWindowIHaveToBeAbleToSeeValues(DataTable data) {
        dbMain.varifyValues(data);
    }


    @And("^Press Save this computer button$")
    public void pressSaveThisComputerButton(){

        dbMain.pressSave();
    }

    @And("^Press Delete This Computer button$")
    public void pressDeleteThisComputerButton(){
       dbMain.pressDelete();
    }

    @Then("^There is should not be row with deleted computer$")
    public void thereIsShouldNotBeRowWithDeletedComputer(DataTable data){
        dbMain.listIsEmpty(data.asList(String.class).get(0));

    }

    @And("^I press Filter By Name button$")
    public void iPressFilterByNameButton(){
        dbMain.iPressFilterByNameButton();
    }
}
