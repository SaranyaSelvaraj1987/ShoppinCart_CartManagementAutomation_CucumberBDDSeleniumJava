package org.shoppingcart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.cartManagement.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cartManagementStepDef {
    //Define object for the classes you want to connect here
    private WebDriver driver;
    private pages pagesObj;
    //Hooks
    @Before
    public void setup() {
        driver = new ChromeDriver();

    }
    @After
    public void tearDown()
    {
        if(driver!=null) {
            driver.quit();
        }
    }
    @Given("I want to add items to the cart")
    public void i_want_to_add_items_to_the_cart()
    {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        pagesObj = new pages(driver);
    }
    @When("I click on Add Item to Cart button for {string}")
    public void I_click_on_Add_Item_to_Cart_button_for(String item) {
        pagesObj.addToCart(item);
    }

    @Then("I should be able to see the added {string} at the cart page")
    public void I_should_be_able_to_see_the_added_at_the_cart_page(String item) {
        pagesObj.viewCart(item);
        pagesObj.itemAdded(item);
    }


}
