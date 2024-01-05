package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.data.Percentage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//import static support.TestContext.getDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static support.TestContext.*;
import static org.assertj.core.api.Assertions.*;

public class UspsStepDefs {

    Actions actions = new Actions(getDriver());
    WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
    @Then("I validate {string} zip code is present in result")
    public void iValidateZipCodeIsPresentInResult(String zip) throws InterruptedException {
        //getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText();

        //Thread.sleep(1000);

        WebElement element = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(element, zip));

        String resultContainer = element.getText();

        assertThat(resultContainer).contains(zip);

        getDriver().findElement(By.xpath("//div[@class='zip-code-result']"));

        //validate each row contains zip
        //List<WebElement> resultRows = getDriver().findElements(By.xpath("//div[@class='zip-code-result']"));

        //for (WebElement row : resultRows){

        //  assertThat(row.getText()).contains(zip);
        // }

    }

    @And("I submit ZIP Code by Address form")
    public void iSubmitZIPCodeByAddressForm() {

        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @When("I navigate to Look Up a ZIP Code by Address")
    public void iNavigateToLookUpAZIPCodeByAddress() {
        // getDriver().findElement(By.xpath("//*[@id='mail-ship-width']")).click();
        //getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction!')]")).click();


        WebElement sendMenu = getDriver().findElement(By.xpath("//*[@id='mail-ship-width']"));
        WebElement lookupZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//a"));
        actions.moveToElement(sendMenu).click(lookupZip).perform();

        getDriver().findElement(By.xpath("//a[contains(@href, 'byaddress')][contains(@class, 'zip-code-home')][contains(@class, 'btn-primary')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        // getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();

        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='tState']"));

        Select stateDropDown = new Select(stateElement);

        stateDropDown.selectByValue(state);

        // getDriver().findElement(By.xpath("//select[@id='tState']/option[@value=' " + state + "']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {

        getDriver().findElement(By.xpath("//input[@class='btn btn-pcalc btn-default']")).click();


        String total = getDriver().findElement(By.xpath("//div[@id='total']")).getText();

        assertThat(total).isEqualTo(cost);


    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {

        getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']")).click();

        getDriver().findElement(By.xpath("//img[contains(@alt, 'Calculate a Price Icon')]")).click();

    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String postCard) {

        //getDriver().findElement(By.xpath("//select[@id='CountryID']")).click();
        // getDriver().findElement(By.xpath("//select[@id='CountryID']//option[@value='10054'][contains(text(), '" + country+ "')]")).click();

        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='CountryID']"));

        Select dropDown = new Select(stateElement);

        dropDown.selectByVisibleText(country);

        getDriver().findElement(By.xpath("//input[@value='" + postCard + "']")).click();

    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {

        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).click();
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);


    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchString) {

        WebElement searchIcon = getDriver().findElement(By.xpath("//li[contains(@class, 'nav-search')]"));
        WebElement searchField = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));

        WebElement button = getDriver().findElement(By.xpath("//label[@for='global-header--search-track-search']/../input[@value='Search']"));

        actions.moveToElement(searchIcon).sendKeys(searchField, searchString).click(button).perform();


    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {

        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        webDriverWait.until(ExpectedConditions.invisibilityOf(spinner));
        getDriver().findElement(By.xpath("//label[contains(text(), '" + filter + "')]")).click();
        webDriverWait.until(ExpectedConditions.invisibilityOf(spinner));


    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String result) {

        String resultRecord = getDriver().findElement(By.xpath("//span[contains(text(), '" + result + " results found for')]")).getText();

        assertThat(resultRecord).contains(result);

        int count = 0;

        List<WebElement> elementList = getDriver().findElements(By.xpath("//li[@class=' col-gl-12 col-md-12 result-item']"));

        for (WebElement element : elementList) {
            count++;
        }

        assertThat(String.valueOf(count)).isEqualTo(result);


    }

    @When("I select {string} in results")
    public void iSelectInResults(String str) {

        getDriver().findElement(By.xpath("//span[contains(text(),'" + str + "')]")).click();

        String [] windowHandles = getDriver().getWindowHandles().toArray(new String[]{});

        getDriver().switchTo().window(windowHandles[windowHandles.length-1].toString());



    }

    @And("I click {string} button")
    public void iClickButton(String button) {

        getDriver().findElement(By.xpath("//a[@class='button--primary']")).click();

        String[] webElements = getDriver().getWindowHandles().toArray(new String[]{});

        getDriver().switchTo().window(webElements[webElements.length - 1].toString());

    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {

        WebElement webElement1 = getDriver().findElement(By.xpath("//button[@id='btn-submit']"));

        actions.moveToElement(getDriver().findElement(By.xpath("//button[@id='btn-submit']"))).click((webElement1)).perform();

        WebElement webElement = getDriver().findElement(By.xpath("//img[@id='login-ajax-loading-1']"));
        webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));

        boolean isRequiredFields = getDriver().findElement(By.xpath("//div[@id='sign-in-wrap']//span[@class='required']")).isDisplayed();
        Assert.assertTrue(isRequiredFields);

    }

    @And("I select a region")
    public void iSelectARegion() throws InterruptedException {
       Dimension winSize = new Dimension(1200, 400);
       getDriver().manage().window().setSize(winSize);
       getDriver().findElement(By.xpath("//a[@data-map='ups-svg-oceania']")).click();

       WebElement africaMenu =  getDriver().findElement(By.xpath("//a[@data-map='ups-svg-africa']"));

      executor.executeScript("arguments[0].click();", africaMenu);

       Thread.sleep(5000);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenu, String menu) {
        WebElement menuElement = getDriver().findElement(By.xpath("//li[@class='menuheader']/a[text()='" + menu + "']"));
        WebElement subMenuElement = getDriver().findElement(By.xpath("//a[text()='" + subMenu + "']"));
        actions.moveToElement(menuElement).click(subMenuElement).perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String searchString) {

        getDriver().findElement(By.id("cityOrZipCode")).sendKeys(searchString);
        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click();

        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        webDriverWait.until(ExpectedConditions.invisibilityOf(spinner));



    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String table) {
     getDriver().findElement(By.className("table-view-img")).click();

    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {

getDriver().findElement(By.xpath("//input[@id='select-all-checkboxes']")).click();


    }

    @And("I close modal window")
    public void iCloseModalWindow() {

   WebElement close = getDriver().findElement(By.xpath("//div[@id='drop-off-location-modal']//a[@class='close']"));
   webDriverWait.until(ExpectedConditions.elementToBeClickable(close));
   close.click();

    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws InterruptedException {

        List <WebElement> list = getDriver().findElements(By.xpath("//td[9]"));
        int originalSize = 0;
        do{
            originalSize = list.size();
            actions.moveToElement(list.get(originalSize - 1)).perform();
            Thread.sleep(500);
            list = getDriver().findElements(By.xpath("//td[9]"));

        } while (originalSize!= list.size());

       // calculating total sum
        double calculatedCost = 0;
        for (WebElement costElement : list){
            String costString = costElement.getText();
            costString = costString.substring(1);
            double cost = Double.parseDouble(costString);
            calculatedCost+= + cost;
        }

        System.out.println(calculatedCost);
        WebElement approximateCostElement = getDriver().findElement(By.id("approximateCost"));
        String approximateCost = approximateCostElement.getText();
        double approximateCostDouble = Double.parseDouble(approximateCost.substring(1));

        System.out.println(calculatedCost);
        System.out.println(approximateCostDouble);
        assertThat(calculatedCost).isCloseTo(approximateCostDouble, Percentage.withPercentage(0.5));

    }


}
