package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import pages.Converter;
import pages.QuoteForm;
import pages.UpsLanding;

import static support.TestContext.*;

public class CommonStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "quote":
                System.out.println("https://skryabin.com/market/quote.html");
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "usps":
                getDriver().get("https://usps.com");
                break;
            case "converter":
                new Converter().open();
                break;
            case "ups":
                getDriver().get("https://ups.com");
                break;
            case "google":
            case "yahoo":
            case "bing":
                System.out.println("https://" + page + ".com");
                getDriver().get("https://" + page + ".com");
                break;
            default:
                throw new Error("Unknown page: " + page);

        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        // String url = getDriver().getTitle();
        //System.out.println(url);
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
        System.out.println(getDriver().getPageSource());

        Dimension windowSize = new Dimension(400, 800);
        getDriver().manage().window().setSize(windowSize);

    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {

        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() {

        LogEntries logEntries = getDriver().manage().logs().get("browser");

        System.out.println();

        for (LogEntry logEntry : logEntries) {
            System.out.println("These are browser logs: " + logEntry);
        }

    }

    @And("I change resolution to phone")
    public void iChangeResolutionToPhone() {

        getDriver().manage().window().setSize(new Dimension(400, 768));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("I change resolution to desktop")
    public void iChangeResolutionToDesktop() {

        getDriver().manage().window().setSize(new Dimension(1024, 768));
    }


    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {

        //  QuoteForm form = new QuoteForm ();

        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;
            case "ups":
                new UpsLanding().open();
                break;
            default:
                throw new Error("Unknown page: " + page);

        }
    }
}



