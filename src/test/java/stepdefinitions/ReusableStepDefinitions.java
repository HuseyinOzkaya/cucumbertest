package stepdefinitions;

import io.cucumber.java.en.Then;
import utilities.ReusableMethods;

import java.io.IOException;

public class ReusableStepDefinitions {
    @Then("Take screenshoot")
    public void take_screenshoot() throws IOException {
        ReusableMethods.getScreenshot("Screenshot");

    }
}
