package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Converter;
import pages.Page;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;


public class ConverterStepsDefs {

    Converter pageConverter = new Converter();


    @When("I click on {string}")
    public void iClickOn(String tab) {

     pageConverter.iClickOnTab(tab);
    }

    @And("I set {string} to {string}")
    public void iSetTo(String fromSection, String toSection) {

         pageConverter.iSetFromTo(fromSection, toSection);

    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String value, String result) {

        pageConverter.iSendValue(value);
        assertThat(pageConverter.getResult()).contains(result);



            }

    @Then("convert to outline with the following values:")
    public void convertToOutlineWithTheFollowingValues() {
    }
}
