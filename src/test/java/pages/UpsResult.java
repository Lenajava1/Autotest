package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class UpsResult extends Page {

    public UpsResult() {
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

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    public WebElement continueButton;

    @FindBy(className = "modal-content")
    private WebElement modalPopup;

    @FindBy(id = "vm.residentialAddressControlId")
    public WebElement checkboxResidentialAddress;


    @FindBy(id = "nbsAddressClassificationContinue")
    private WebElement addressClassificationContinue;

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement originShip;

    @FindBy(id = "nbsBalanceBarTotalCharges")
    private WebElement totalCharge;

    @FindBy(id = "nbsBalanceBarExpandButton")
    private WebElement buttonExpand;

    @FindBy(xpath = "//div[@class='ups-form_wrap ups-wrap ups-application_wrapper ups-app_nbs']")
    private WebElement reviewPage;

    @FindBy(id = "origin_showSummaryAddress")
    private WebElement shipFromValidate;


    public String getResult() {

      return originShip.getText();


    }

    public String getTotalCharge() throws InterruptedException {
        Thread.sleep(2000);

        String [] text = totalCharge.getText().split(" ");
        String totalResult = "";

        for (int i = 0; i < text.length; i++){
           totalResult = text[text.length-1];

        }
        return totalResult;


    }

    public String getReviewPageContent(){


        return shipFromValidate.getText();

    }


}



