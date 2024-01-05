package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UpsPayment extends Page{

    Actions actions = new Actions(getDriver());

    public UpsPayment() {

        url = "https://www.ups.com/ship/guided/payment";
    }

    @FindBy(xpath ="//label[@class='ups-radio-custom-label ups-payment_type_content ng-star-inserted']")
    private WebElement radioButtonPayPal;


    public void selectPaypal(){

        radioButtonPayPal.click();
    }


}
