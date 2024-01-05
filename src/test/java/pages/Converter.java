package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class Converter extends Page {

    public Converter() {

        url = "https://www.unitconverters.net";
        title = "Unit Converter";
    }

    @FindBy(partialLinkText = "Temperature" )
    private WebElement temperature;

    @FindBy(partialLinkText = "Weight" )
    private WebElement weight;

    @FindBy(partialLinkText = "Length" )
    private WebElement length;

    @FindBy(id = "fromVal" )
    private WebElement fromVal;

    @FindBy(xpath = "//select[@id='calFrom']" )
    private WebElement calFrom;

    @FindBy(xpath = "//select[@id='calTo']" )
    private WebElement calTo;

    @FindBy(id = "calResults")
    private WebElement results;


    public void iClickOnTab(String tab){


        switch (tab){
            case "Temperature":
                temperature.click();
                break;
            case "Weight":
                weight.click();
                break;
            case "Length":
                length.click();
                break;
            default:
                throw new Error("Unknown tab: " + tab);
        }
    }


    public void iSetFromTo(String fromSection, String toSection){

        Select select = new Select(calFrom);
        Select select1 = new Select(calTo);

        select.selectByVisibleText(fromSection);
        select1.selectByVisibleText(toSection);

    }

    public void iSendValue(String value){

        fromVal.sendKeys(value);
    }

    public String getResult(){

       return results.getText();


    }


}
