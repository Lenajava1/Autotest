package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UpsOptions extends Page{

    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public UpsOptions() {

        url = "https://www.ups.com/ship/guided/options";
        title = "";
    }

    @FindBy(id = "nbsShipmentDescription")
    public WebElement description;

    @FindBy(id = "nbsDirectDeliveryOnlyOptionBaseOptionSwitch")
    public WebElement directDelivery;


    public void setDescription(String value) {

        description.sendKeys(value);
    }
public void checkDirectDelivery(){

        actions.scrollToElement(directDelivery).click();
}


}
