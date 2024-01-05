package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static support.TestContext.getDriver;

public class UpsDestination extends Page{

    public UpsDestination() {

        url = "https://www.ups.com/ship/guided/destination";
        title = "UPS Shipping";
    }

    @FindBy(id = "destination-cac_country")
    public WebElement country;


    @FindBy(id = "destination-cac_singleLineAddress")
    public WebElement address;

    @FindBy(css = ".dropdown-item")
    private List<WebElement> addressSuggestions;

    @FindBy(id = "destination-cac_email")
    public WebElement email;

    @FindBy(id = "destination-cac_companyOrName")
    public WebElement name;

    @FindBy(id = "destination-cac_contactName")
    private WebElement destinationContact;

    @FindBy(id = "destination-cac_phone")
    public WebElement phone;

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement butContinue;

    public void iSelectCountry(String value){

        new Select(country).selectByVisibleText(value);

    }
    @Override
    public void open(){
       getDriver().get(url);
    }

    public void iFillName(String text){
        name.sendKeys(text);
    }

    public void iFillContactName(String text){destinationContact.sendKeys(text);
    }
    public void iFillEmail(String text){
        email.sendKeys(text);
    }

    public void iFillPhone(String text){
        phone.sendKeys(text);
    }

    public void iFillAddress(String value) throws InterruptedException {
        address.sendKeys(value);
        WebElement topSuggestions = addressSuggestions.get(0);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(addressSuggestions));

        wait.until(ExpectedConditions.elementToBeClickable(topSuggestions));
        topSuggestions.click();
        Thread.sleep(500);
    }




}
