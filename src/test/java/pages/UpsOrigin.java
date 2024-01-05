package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static support.TestContext.getDriver;

public class UpsOrigin extends Page {

    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    WebDriverWait driverWait;

    public UpsOrigin() {
        url = "https://www.ups.com/ship/guided/origin";
        title = "UPS Shipping";
    }

    @FindBy(id = "origin-cac_country")
    public WebElement country;


    @FindBy(id = "origin-cac_singleLineAddress")
    public WebElement address;

    @FindBy(css = ".dropdown-item")
    private List<WebElement> addressSuggestions;

    @FindBy(id = "origin-cac_email")
    public WebElement email;

    @FindBy(id = "origin-cac_companyOrName")
    public WebElement name;

    @FindBy(id = "origin-cac_phone")
    public WebElement phone;

    @FindBy(className = "modal-content")
    private WebElement modalPopup;

    @FindBy(css = ".ups-lever_switch_yes")
    public WebElement residentialAddressYes;

    @FindBy(css = ".ups-lever_switch_no")
    public WebElement residentialAddressNo;


    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement addressClassificationContinue;


    public void selectCountry(String text) throws InterruptedException {

        Thread.sleep(1000);

        new Select(country).selectByVisibleText(text);
    }

    public void iFillName(String text) {
        name.sendKeys(text);
    }

    public void iFillEmail(String text) {
        email.sendKeys(text);
    }

    public void iFillPhone(String text) {
        phone.sendKeys(text);
    }

    public void iFillAddress(String value) throws InterruptedException {
        address.sendKeys(value);
        WebElement topSuggestions = addressSuggestions.get(0);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfAllElements(addressSuggestions));

        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(topSuggestions));
        actions.moveToElement(topSuggestions).click().perform();
    }


    public void enableResidentialAddress() {
        if (residentialAddressYes.isDisplayed()) {
            residentialAddressYes.click();
        }
    }

    public void disableResidentialAddress() {
        if (residentialAddressNo.isDisplayed()) {
            residentialAddressNo.click();
        }
    }

    public void confirmResidentialAddress(){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(modalPopup));
        addressClassificationContinue.click();
    }


}
