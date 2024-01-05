package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static support.TestContext.getDriver;

public class UpsCommonButtons extends Page{

    public UpsCommonButtons() {

        url = "";
        title = "";
    }

    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    Actions actions = new Actions(getDriver());

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement popupCancel;

    @FindBy(id = "nbsCancelShipmentWarningYes")
    private WebElement cancelShipmentYes;

    @FindBy(id = "nbsCancelShipmentWarningNo")
    private WebElement cancelShipmentNo;

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    public WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationReviewPrimaryButton")
    private WebElement reviewButton;


    public void clickOnContinue() {

        js.executeScript("window.scrollTo(0,500)");
        continueButton.click();

    }

    public void pickUpPageScroll() {

        js.executeScript("window.scrollTo(0,1445)");
        continueButton.click();

    }



    public void iHitContinueButton() throws InterruptedException {

        Thread.sleep(500);

        actions.scrollToElement(continueButton);

        WebElement banner = getDriver().findElement(By.xpath("//button[@class='close_btn_thick']"));


        if (banner.isDisplayed()) {
            banner.click();
            continueButton.click();
        } else {
            continueButton.click();
        }
    }

        public void clickReviewButton(){
           // actions.scrollToElement(reviewButton).click();
            js.executeScript("window.scrollTo(0,550)");
            reviewButton.click();


        }



    public void clickCancel(){

        actions.scrollToElement(cancelShipmentButton).click();
    }

    public void clickYes(){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(popupCancel));
        cancelShipmentYes.click();

    }

    public void clickNo(){


        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(popupCancel));
        cancelShipmentNo.click();

    }
}
