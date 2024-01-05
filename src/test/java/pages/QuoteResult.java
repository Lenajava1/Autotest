package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult extends Page {

    public QuoteResult() {

        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }
    @Override
    public void open(){
        throw new Error("Can't navigate to this page via url. Accessible after submission");
    }
//fields

    @FindBy(xpath = "//*[@id='quotePageResult']//section")
        private WebElement resultSection;
        @FindBy (xpath = "//b[@name = 'email']")
        private WebElement email;

    @FindBy (xpath = "//b[@name = 'username']")
        private WebElement username;

    @FindBy (xpath = "//b[@name = 'password']")
        private WebElement password;

        //name dialog

        @FindBy(id = "name")
        private WebElement name;

        @FindBy(id = "firstName")
        private WebElement firstName;

        @FindBy(id = "lastName")
        private WebElement lastName;

        @FindBy(xpath = "//span[text()='Save']")
        private WebElement saveButton;

        @FindBy(name = "agreedToPrivacyPolicy")
        private WebElement privacyPolicy;

        @FindBy(id = "formSubmit")
        private WebElement submitButton;

        //optional field

    @FindBy(xpath = "//b[@name='phone']")
    private WebElement phone;

    @FindBy(xpath = "//b[@name='dateOfBirth']")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//b[@name='countryOfOrigin']")
    private WebElement countryOfOrigin;

    @FindBy(xpath = "//b[@name='gender']")
    private WebElement gender;

    @FindBy(xpath = "//b[@name='address']")
    private WebElement address;

    @FindBy(xpath = "//b[@name= 'carMake']")
    private WebElement carMake;

    @FindBy(xpath = "//b[@name= 'allowedToContact']")
    private WebElement allowedToContact;




        //methods

    public String getResults(){
        return resultSection.getText();
    }

    public String getPassword(){
        return password.getText();
    }

    public boolean iAgreedToPrivatePolicy(){
        return Boolean.parseBoolean(privacyPolicy.getText());
    }

    public boolean iSelectAllowToContact(){
        return Boolean.parseBoolean(allowedToContact.getText());
    }

    }


