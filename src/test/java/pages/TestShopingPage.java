package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestShopingPage {
    public TestShopingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (linkText = "Sign in")
    public WebElement signButton;

    @FindBy (id = "email")
    public WebElement emailBox;

    @FindBy (id = "passwd")
    public WebElement passwordBox;

    @FindBy (css = "a[title='View my customer account'] span")
    public WebElement userName;

    @FindBy (xpath = "//span[normalize-space()='My addresses']")
    public WebElement myAddressesButton;

    @FindBy(xpath = "//span[normalize-space()='Add a new address']")
    public WebElement addNewAddress;

    @FindBy (id = "firstname")
    public WebElement firstNameBox;

    @FindBy (id = "lastname")
    public WebElement lastNameBox;

    @FindBy (id = "company")
    public WebElement companyBox;

    @FindBy (id = "address1")
    public WebElement addressBox;

    @FindBy (id = "city")
    public WebElement cityBox;

    @FindBy (id = "id_state")
    public WebElement stateDropBox;

    @FindBy (id = "postcode")
    public WebElement postcodeBox;

    @FindBy (id = "id_country")
    public WebElement countryDropBox;

    @FindBy (id = "phone")
    public WebElement phoneBox;

    @FindBy (id = "phone_mobile")
    public WebElement phoneMobileBox;

    @FindBy (id = "submitAddress")
    public WebElement submitAddressButton;

    @FindBy(id ="alias")
    public WebElement addressName;










}
