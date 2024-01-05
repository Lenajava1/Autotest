package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class QuoteForm extends Page {

    Actions actions = new Actions(getDriver());

    public QuoteForm() {

        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    //fields
    @FindBy(name = "username")
  private WebElement  username;
    @FindBy (name = "email")
    private WebElement email;

    @FindBy (name = "password")
    private WebElement password;

    @FindBy (name = "confirmPassword")
    private WebElement confirmPassword;

    //name dialog

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "middleName")
    private WebElement middleName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacyPolicy;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;

    //optional fields
    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(id = "dateOfBirth")
    private WebElement dateOfBirth;

    @FindBy(xpath = "//*[@class='ui-datepicker-month']")
    private WebElement month;

    @FindBy(xpath = "//*[@class='ui-datepicker-year']")
    private WebElement year;

    @FindBy(css = ".ui-state-default")
    private WebElement datePick;

    @FindBy(name = "countryOfOrigin")
    private WebElement countryOfOrigin;

   @FindBy(xpath = "//input[@name='gender'][@value='female']")
    private WebElement genderFemale;

   @FindBy(xpath = "//input[@name='gender'][@value='male']")
    private WebElement genderMale;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(name = "carMake")
    private WebElement carMake;

    @FindBy(name = "allowedToContact")
    private WebElement allowedToContact;

   // @FindBy(xpath = "//label[text()='"+ text + "']")
    //private WebElement label;

    @FindBy(name = "additionalInfo")
    private WebElement additionalInfoIframe;

    @FindBy(id = "contactPersonName")
    private WebElement contactPersonalName;

    @FindBy(id = "contactPersonPhone")
    private WebElement contactPersonalPhone;


    //methods

    public void iFillContactInfo(String name, String phone){
        getDriver().switchTo().frame(additionalInfoIframe);
        contactPersonalName.sendKeys(name);
        contactPersonalPhone.sendKeys(phone);
        getDriver().switchTo().defaultContent();
    }

    public WebElement getLableByText(String text){
        return getDriver().findElement(By.xpath("//label[text()='"+ text + "']"));
    }
    public void fillUserName(String text){

        username.sendKeys(text);

    }

    public void fillEmail(String text){

        email.sendKeys(text);

    }

    public void fillPasswordFields(String text, String textValue){

        password.sendKeys(text);
        confirmPassword.sendKeys(textValue);

    }

    public void fillName(String firstNameValue, String lastNameValue){

        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();

    }

    public void fillName(String firstNameValue, String lastNameValue, String middleNameValue){

        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        middleName.sendKeys(middleNameValue);
        saveButton.click();

    }

    public  void acceptedPrivacyPolicy(){

        if (!privacyPolicy.isSelected())
            privacyPolicy.click();
    }

    public  void declinePrivacyPolicy(){

        if (privacyPolicy.isSelected())
        privacyPolicy.click();
    }
    public void submit(){
        submitButton.click();

    }

    public void iFillPhone(String phoneNumber){

        phone.sendKeys(phoneNumber);
    }

    public void iSelectDateOfBirthField(){
        dateOfBirth.click();
    }

    public void iFillDateOfBirth(String monthValue, String dayValue, String yearValue){

        actions.moveToElement(month).click();
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText(monthValue);

        actions.moveToElement(year).click();
        Select selectYear = new Select(year);
        selectYear.selectByValue(yearValue);

        actions.moveToElement(datePick.findElement(By.xpath("//a[contains(text(),'" + dayValue + "')]"))).click().perform();

    }

    public void iSelectCountryOfOrigin(String countryValue){

        countryOfOrigin.click();
        Select selectCountry = new Select(countryOfOrigin);
        selectCountry.selectByValue(countryValue);

    }

    public void iSelectGender(String genderValue) {

        if (genderValue.contains("female")||genderValue.contains("Female")) {
            genderFemale.click();
        } else {
            genderMale.click();
        }
    }

    public void iFillAddress(String addressValue){

        address.sendKeys(addressValue);
    }

    public void iSelectCarMake(String carValue){

        Select selectCar = new Select(carMake);
        selectCar.selectByValue(carValue);

    }

    public void iSelectAllowToContact(){
       allowedToContact.click();
    }
}
