package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import support.TestContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class UpsStepsDef {

    UpsLanding ups = new UpsLanding();
    UpsOrigin originPage = new UpsOrigin();
    UpsResult resultUps = new UpsResult();
    UpsDestination destination = new UpsDestination();

    UpsPackage upsPackage = new UpsPackage();
    UpsOptions shipingOptions = new UpsOptions();

    UpsPayment upsPayment = new UpsPayment();
    UpsCommonButtons upsCommonButtons = new UpsCommonButtons();

    Map<String, String> originData = TestContext.getDataFromFile("origin");

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        ups.clickShipMenu();

    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {

        originPage.selectCountry(originData.get("country"));
        originPage.iFillName(originData.get("name"));
        originPage.iFillEmail(originData.get("email"));
        originPage.iFillAddress(originData.get("address"));
        originPage.iFillPhone(originData.get("phone"));
        Thread.sleep(500);


    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {

        upsCommonButtons.iHitContinueButton();
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String confirm) {


        switch (confirm) {
            case "confirm":
               originPage.enableResidentialAddress();
                break;
            case "deny":
               originPage.disableResidentialAddress();
                break;
            default:
                throw new Error("Unknown action:");

        }

        originPage.confirmResidentialAddress();

    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {


        assertThat(resultUps.getResult()).contains(
                        originData.get("countryLine"),
                        originData.get("name"),
                        originData.get("address"),
                        originData.get("email"),
                        originData.get("phone"));


    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() throws InterruptedException {

        destination.iSelectCountry(originData.get("destinationCountry"));
        destination.iFillName(originData.get("destinationName"));
        destination.iFillContactName(originData.get("destinationContact"));
        destination.iFillAddress(originData.get("destinationAddress"));
        destination.iFillEmail(originData.get("destinationEmail"));
        destination.iFillPhone(originData.get("destinationPhone"));

    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {

        upsPackage.selectPackagingType(originData.get("packagingType"));
        upsPackage.fillWeight(originData.get("packagingWeight"));


    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() throws InterruptedException {

        assertThat(resultUps.getTotalCharge()).isEqualTo(originData.get("cheapDeliveryCost"));
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {
        upsPackage.selectDeliveryOption();
    }

    @And("I click on submit")
    public void iClickOnSubmit() {
        upsCommonButtons.pickUpPageScroll();
    }

    @And("I set description and check Saturday Delivery type if available")
    public void iSetDescriptionAndCheckSaturdayDeliveryTypeIfAvailable() {

        shipingOptions.setDescription(originData.get("descriptionOfShiping"));
    }

    @And("I check Deliver only to receiver's address")
    public void iCheckDeliverOnlyToReceiverSAddress() {

        shipingOptions.checkDirectDelivery();

    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() throws InterruptedException {

        assertThat(resultUps.getTotalCharge()).isNotEqualTo(originData.get("cheapDeliveryCost"));
    }

    @When("I submit the shipment options page")
    public void iSubmitTheShipmentOptionsPage() {
        upsCommonButtons.clickOnContinue();

    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {

        upsPayment.selectPaypal();
    }

    @And("I submit the payment form")
    public void iSubmitThePaymentForm() {
        upsCommonButtons.clickReviewButton();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {

        assertThat(resultUps.getReviewPageContent()).contains(
                originData.get("countryLine"),
                originData.get("country"),
                originData.get("name"),
                originData.get("address"),
                originData.get("email"),
                originData.get("phone")
               //originData.get("destinationCountry"),
                //originData.get("destinationName"),
                //originData.get("destinationContact"),
                ////originData.get("destinationAddress"),
                //originData.get("destinationEmail"),
                //originData.get("destinationPhone"),
                //originData.get("packagingWeight"),
                //originData.get("descriptionOfShiping")


        );

        //assertThat(resultUps.getReviewPageContent()).contains("Deliver only to receiver's address");
        //assertThat(resultUps.getReviewPageContent()).contains("PayPal");



    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {

        upsCommonButtons.clickCancel();


    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {

       upsCommonButtons.clickYes();
      assertThat(getDriver().getCurrentUrl()).contains("origin");

    }
}
