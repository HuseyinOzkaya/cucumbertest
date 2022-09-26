package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.TestShopingPage;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.ConfigReader.getProperty;
import static utilities.Driver.closeDriver;
import static utilities.Driver.getDriver;

public class Day03_DataProvider {

    TestShopingPage testShopingPage = new TestShopingPage();

    @When("user visit to application page")
    public void user_visit_to_application_page() {
        getDriver().get(getProperty("test_url"));

    }

    @When("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        testShopingPage.signButton.click();
    }

    @When("user enters login_username and login_password")
    public void user_enters_login_username_and_login_password(DataTable dataTable) {
        List<String> userCredential = dataTable.row(1);
        String email = userCredential.get(0);
        String password = userCredential.get(1);
        testShopingPage.emailBox.sendKeys(email);
        testShopingPage.passwordBox.sendKeys(password + Keys.ENTER);

    }

    @Then("verifies username is displayed")
    public void verifies_username_is_displayed() {
        assertTrue(testShopingPage.userName.isDisplayed());

    }

    @Then("user close the test page")
    public void user_close_the_test_page() {
        closeDriver();
    }

    @And("user clicks on add new address")
    public void userClicksOnAddNewAddress() {
        testShopingPage.addNewAddress.click();
    }

    String addressName = "";
    @And("enters all required fields")
    public void entersAllRequiredFields(DataTable dataTable) throws InterruptedException {
        List<String> addressDetails = dataTable.row(1);
        testShopingPage.firstNameBox.sendKeys(addressDetails.get(0));
        testShopingPage.lastNameBox.sendKeys(addressDetails.get(1));
        testShopingPage.companyBox.sendKeys(addressDetails.get(2));
        testShopingPage.addressBox.sendKeys(addressDetails.get(3));
        testShopingPage.cityBox.sendKeys(addressDetails.get(4));

        Select stateDropDown = new Select(testShopingPage.stateDropBox);
        stateDropDown.selectByVisibleText(addressDetails.get(5));

        testShopingPage.postcodeBox.sendKeys(addressDetails.get(6));

        Select countryDropDown = new Select(testShopingPage.countryDropBox);
        countryDropDown.selectByVisibleText(addressDetails.get(7));

        testShopingPage.phoneBox.sendKeys(addressDetails.get(8));
        testShopingPage.phoneMobileBox.sendKeys(addressDetails.get(9));
        String addressName = addressDetails.get(10)+(int)(Math.random()*1000);
        testShopingPage.addressName.clear();
        testShopingPage.addressName.sendKeys(addressName);
    }

    @Then("click on Save Button")
    public void clickOnSaveButton() {
        testShopingPage.submitAddressButton.click();
    }

    @And("user clicks on my addresses")
    public void userClicksOnMyAddresses() {
        testShopingPage.myAddressesButton.click();
    }
}
