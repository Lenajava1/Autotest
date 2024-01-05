package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsLanding extends Page {

    public UpsLanding() {
        url = "https://www.ups.com/us/en/Home.page";
       title = "Global Shipping & Logistics Services | UPS - United States";
    }


@FindBy(id = "tabs_0_tab_2")
    private WebElement ship;

    public void clickShipMenu(){

        ship.click();
    }

}
