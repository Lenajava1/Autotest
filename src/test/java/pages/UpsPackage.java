package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static support.TestContext.getDriver;

public class UpsPackage extends Page {

    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    Actions actions = new Actions(getDriver());
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    public UpsPackage() {

        url = "https://www.ups.com/ship/guided/package";
        title = "UPS Shipping";
    }

    @FindBy(id = "nbsPackagePackagingTypeDropdown0")
    private WebElement packagingType;

    @FindBy(xpath = "//input[@id='nbsPackagePackageWeightField0']")
    private WebElement weightField;

    @FindBy(xpath = "//div[@class='ups-shipping_schedule_grid']")
    private List<WebElement> deliveryOptions;


    @FindBy(id = "ups-footerWrap")
    private WebElement footer;


    public void selectPackagingType(String packageValue) {

        new Select(packagingType).selectByVisibleText(packageValue);

    }

    public void fillWeight(String weightValue) {

        WebElement checkMark = getDriver().findElement(By.xpath("//span[@class='icon ups-icon-check']"));
        weightField.click();
        weightField.sendKeys(weightValue);
        wait.until(ExpectedConditions.visibilityOf(checkMark));


    }


    public void selectDeliveryOption() throws InterruptedException {

        for (int i = 0; i < deliveryOptions.size(); i++){

         if (deliveryOptions.get(i).getText().contains("Lowest Cost")) {
               actions.scrollToElement(getDriver().findElement(By.xpath("//p[contains(text(), 'Lowest Cost')]"))).click();

            }

        }
        Thread.sleep(1000);
    }




}
