package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.Driver.getDriver;

public class Hooks {
    @Before
    public void setUp() {
        System.out.println("This is hooks before method");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            // TakesScreenshot is an interface of selenium that takes the screenshot
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            // full path to the screenshot location
            String target = "target/test-output/Screenshots/" + "Screenshoot"
                    + date + ".png";
            File finalDestination = new File(target);
            // save the screenshot to the path given
            FileUtils.copyFile(source, finalDestination);


            //This part includes images in to report (gets image and add to report)
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/pmg", "Screenshot");
        }


    }
}
