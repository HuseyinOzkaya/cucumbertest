package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.GooglePage;

import static java.lang.System.getProperties;
import static org.junit.Assert.assertTrue;
import static utilities.ConfigReader.getProperty;
import static utilities.Driver.closeDriver;
import static utilities.Driver.getDriver;

public class Day01_BasicGoogleSearchDefinitions {
    GooglePage googlePage = new GooglePage();

    @Given("user is on the google page")
    public void userIsOnTheGooglePage() {
        getDriver().get(getProperty("google_url"));
    }

    @And("user search for iPhone")
    public void userSearchForIPhone() {
        googlePage.searchBox.sendKeys("iPhone" +Keys.ENTER);
    }

    @Then("verify the result has iPhone")
    public void verifyTheResultHasIPhone() {
        String title = getDriver().getTitle();
        assertTrue(title.contains("iPhone"));
    }

    @Then("close the application")
    public void closeTheApplication() {
        closeDriver();
    }

    @And("user search for teapot")
    public void userSearchForTeapot() {
        googlePage.searchBox.sendKeys("teapot" + Keys.ENTER);
    }

    @Then("verify the result has teapot")
    public void verifyTheResultHasTeapot() {
        String title = getDriver().getTitle();
        assertTrue(title.contains("teapot"));
    }

    @And("user search for tesla")
    public void userSearchForTesla() {
        googlePage.searchBox.sendKeys("tesla" + Keys.ENTER);
    }

    @Then("verify the result has tesla")
    public void verifyTheResultHasTesla() {
        String title = getDriver().getTitle();
        assertTrue(title.contains("tesla"));
    }
}
