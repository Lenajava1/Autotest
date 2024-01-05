package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Condition;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.QuoteForm;
import pages.QuoteResult;
import support.TestContext;


import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class QuoteStepDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        //getDriver().findElement(By.xpath("//*[@name='']"))
        //Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("john@example.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("john@example.com");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("john@example.com");
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Snow");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @When("I fill out optional fields")
    public void iFillOutOptionalFields() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("1213232424");
        getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']/option[@value='Russia']")).click();
        getDriver().findElement(By.xpath("//input[@name='gender'][@value='female']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("2344 Budapest Andrassy 122, 2/A");
        getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='BMW']")).click();
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
        getDriver().findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='2']")).click();
        getDriver().findElement(By.xpath("//select[@data-handler='selectYear']/option[@value='1993']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'16')]")).click();

    }

    @And("I switch to iframe, alert and new window")
    public void iSwitchToIframeAlertAndNewWindow() {

        getDriver().findElement(By.xpath("//button[@onclick='thirdPartyAlert()']")).click();
        getDriver().switchTo().alert().accept();
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys("Elena");
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys("+354564756765");
        getDriver().switchTo().parentFrame();
        getDriver().findElement(By.xpath("//a[@name='link']")).click();
        getDriver().navigate().to("https://skryabin.com/market/new_window.html");
        String newPageName = getDriver().getTitle();
        System.out.println("\n\n" + newPageName + " ");
        getDriver().navigate().back();

    }


    @And("I submit the form")
    public void iSubmitTheForm() throws InterruptedException {
        Thread.sleep(2000);

        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify fields saved correctly")
    public void iVerifyFieldsSavedCorrectly() {
        String savedValue = getDriver().findElement(By.xpath("//div[@id='quotePageResult']//section")).getText();
        String agreedFieldValue = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        String allowedToContactValue = getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText();
        String thirdParty = getDriver().findElement(By.xpath("//b[@name='thirdPartyAgreement']")).getText();

        // if (!agreedFieldValue.equals("true")){
        // throw new Error("value does not equal "+ agreedFieldValue);
        //}

        //assertEquals(agreedFieldValue,"true");
        //assertTrue(agreedFieldValue.equals("false"));
        //assertTrue(agreedFieldValue.contains("jdoe"));
        assertThat(savedValue).contains("jdoe");
        assertThat(agreedFieldValue).isEqualTo("true");
        assertThat(savedValue).contains("john@example.com");
        assertThat(savedValue).contains("[entered]");
        assertThat(savedValue).contains("John Snow");
        assertThat(savedValue).contains("1213232424");
        assertThat(savedValue).contains("John");
        assertThat(savedValue).contains("Snow");
        assertThat(savedValue).contains("Russia");
        assertThat(savedValue).contains("BMW");
        assertThat(savedValue).contains("female");
        assertThat(savedValue).contains("2344 Budapest Andrassy 122, 2/A");
        assertThat(savedValue).contains("03/16/1993");
        assertThat(savedValue).contains("Elena");
        assertThat(savedValue).contains("+354564756765");
        assertThat(allowedToContactValue).isEqualTo("true");
        assertThat(thirdParty).isEqualTo("accepted");


    }

    @When("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        switch (action) {
            case "accept" -> getDriver().switchTo().alert().accept();
            case "decline" -> getDriver().switchTo().alert().dismiss();
            default -> throw new Error("Incorrect action" + action);
        }
        Thread.sleep(2000);
    }

    @And("I verify third party agreement {string}")
    public void iVerifyThirdPartyAgreement(String expectStatus) {

        String actualStatus = getDriver().findElement(By.xpath("//span[@id='thirdPartyResponseMessage']")).getText();
        switch ((expectStatus)) {
            case "accept" -> assertThat(actualStatus).contains("accepted");
            case "decline" -> assertThat(actualStatus).contains("did not accept");
            default -> throw new Error("Incorrect action" + actualStatus);
        }
    }

    @When("I pass {string} and phone number {string}")
    public void iPassAndPhoneNumber(String arg0, String arg1) throws InterruptedException {
        WebElement frame = getDriver().findElement(By.xpath("//iframe[@name='additionalInfo']"));
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(arg0);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(arg1);
        getDriver().switchTo().defaultContent();
        Thread.sleep(2000);

    }

    @When("I open related documents")
    public void iOpenRelatedDocuments() {

        getDriver().findElement(By.xpath("//button[contains(text(),'Related documents (click)')]")).click();
        System.out.println(getDriver().getWindowHandles());

    }

    @And("I verify {string}")
    public void iVerify(String arg0) throws InterruptedException {

        String[] windowHandles = getDriver().getWindowHandles().toArray(new String[]{});
        System.out.println(windowHandles[windowHandles.length - 1].toString());

        getDriver().switchTo().window(windowHandles[windowHandles.length - 1].toString());

        String documents = getDriver().findElement(By.xpath("//ul")).getText();
        assertThat(documents).contains(arg0);
        Thread.sleep(2000);

        getDriver().switchTo().window(windowHandles[0].toString());
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String fieldName) {

        if (getDriver().findElements(By.xpath("//label[@id='" + fieldName + "-error']")).size() > 0) {
            assertThat(getDriver().findElement(By.xpath("//label[@id='" + fieldName + "-error']")).isDisplayed()).isFalse();
        } else {
            assertThat(getDriver().findElements(By.xpath("//label[@id='" + fieldName + "-error']"))).hasSize(0);
        }

    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String fieldName, String errorMessage) {

        String resultElement = getDriver().findElement(By.xpath("//label[@id='" + fieldName + "-error']")).getText();

        assertThat(getDriver().findElement(By.xpath("//label[@id='" + fieldName + "-error']")).isDisplayed()).isTrue();
        assertThat(resultElement).isEqualTo(errorMessage);

    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String fieldName, String value) {

        getDriver().findElement(By.xpath("//input[@name='" + fieldName + "']")).clear();
        getDriver().findElement(By.xpath("//input[@name='" + fieldName + "']")).sendKeys(value);


    }

    @When("I fill out required fields oop")
    public void iFillOutRequiredFieldsOop() {

        Map<String,String> user = TestContext.getDataFromFile("user");
        form.fillUserName(user.get("jdoe"));
        form.fillEmail(user.get("jdoe@example.com"));
        form.fillName(user.get("John"), user.get("Snow"));
        form.fillPasswordFields(user.get("welcome"), user.get("welcome"));
        form.acceptedPrivacyPolicy();
    }

    @And("I submit the form oop")
    public void iSubmitTheFormOop() {

        form. submit();
    }

    @Then("I verify fields saved correctly oop")
    public void iVerifyFieldsSavedCorrectlyOop() {

        Map<String,String> user = TestContext.getDataFromFile("user");

        assertThat(result.getResults()).contains(user.get("jdoe"));
        assertThat(result.getResults()).contains(user.get("jdoe@example.com"));
        assertThat(result.getResults()).contains(user.get("John Snow"));
        assertThat(result.getPassword()).doesNotContain(user.get("welcome"));
        assertThat(result.iAgreedToPrivatePolicy()).isTrue();

        //optional fields
        assertThat(result.getResults()).contains("2221708288");
        assertThat(result.getResults()).contains("04/02/1996");
        assertThat(result.getResults()).contains("4970 El Camino Real, Los Altos, CA 94022");
        assertThat(result.getResults()).contains("Canada");
        assertThat(result.getResults()).contains("male");
        assertThat(result.getResults()).contains("BMW");
        assertThat(result.iSelectAllowToContact()).isTrue();



    }

    @When("I fill out optional fields oop")
    public void iFillOutOptionalFieldsOop() {

        form.iFillPhone("2221708288");
        form.iSelectDateOfBirthField();
        form.iFillDateOfBirth("Apr","2", "1996");
        form.iSelectCountryOfOrigin("Canada");
        form.iSelectGender("male");
        form.iFillAddress("4970 El Camino Real, Los Altos, CA 94022");
        form.iSelectCarMake("BMW");
        form.iSelectAllowToContact();


            }

    @Then("label {string} has required asterisk")
    public void labelHasRequiredAsterisk(String text) {
        form.getLableByText(text);
    }

    @Then("label {string} is not required asterisk")
    public void labelIsNotRequiredAsterisk(String arg0) {
    }

    @When("I pass {string} and phone number {string} oop")
    public void iPassAndPhoneNumberOop(String name, String phone) {
        form.iFillContactInfo(name, phone);
    }
}



