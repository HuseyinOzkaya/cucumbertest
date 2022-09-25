package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import pages.TestShopingPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.ConfigReader.getProperty;
import static utilities.Driver.closeDriver;
import static utilities.Driver.getDriver;

public class Day02_ParameterizedGoogleSearchDefinitions {
    GooglePage googlePage = new GooglePage();
    TestShopingPage testShopingPage = new TestShopingPage();


    @And("user search for {string}")
    public void userSearchFor(String toSearch) {
        googlePage.searchBox.sendKeys(toSearch+Keys.ENTER);
    }

    @Then("verify the result has {string}")
    public void verifyTheResultHas(String toSearch) {
        assertTrue(getDriver().getTitle().contains(toSearch));

    }

    @When("user is on the application page")
    public void userIsOnTheApplicationPage() {
        getDriver().get(getProperty("test_url"));
    }

    @And("user enters manager credentials {string} and {string}")
    public void userEntersManagerCredentialsAnd(String email, String password) {
        testShopingPage.emailBox.sendKeys(email);
        testShopingPage.passwordBox.sendKeys(password + Keys.ENTER);
    }

    @When("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        testShopingPage.signButton.click();
    }
    

    @Then("verify <{string}> is displayed")
    public void verifyIsDisplayed(String username) {
        assertTrue(testShopingPage.userName.isDisplayed());
    }

    @Then("close the test page")
    public void closeTheTestPage() {
        closeDriver();
    }

}
