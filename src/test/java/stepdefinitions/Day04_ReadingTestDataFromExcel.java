package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.TestShopingPage;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

import static utilities.ConfigReader.getProperty;
import static utilities.Driver.getDriver;

public class Day04_ReadingTestDataFromExcel {

    ExcelUtil excelUtil;
    TestShopingPage testShopingPage = new TestShopingPage();

    @When("user enters manager credentials from excel")
    public void user_enters_manager_credentials_from_excel() {
        String path = "src/test/resources/excelfiles/userdataexcelfile.xls";
        String sheetName = "Sheet1";
        excelUtil = new ExcelUtil(path, sheetName);
        String username = excelUtil.getCellData(1, 0);
        String password = excelUtil.getCellData(1, 1);
        testShopingPage.emailBox.sendKeys(username);
        testShopingPage.passwordBox.sendKeys(password + Keys.ENTER);


    }


    private void setup() {
        getDriver().get(getProperty("test_url"));
        testShopingPage.signButton.click();
    }

    @And("user enters manager credentials from excel {int}")
    public void userEntersManagerCredentialsFromExcel(int arg0) {
        List<Map<String, String>> testData = excelUtil.getDataList();
        System.out.println(testData);
        for (Map<String, String> eachData : testData) {
            setup();
            testShopingPage.emailBox.sendKeys(eachData.get("username"));
            testShopingPage.passwordBox.sendKeys(eachData.get("password") + Keys.ENTER);
        }
    }
}
