package stepDefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Config;
import utilities.Driver;

import java.util.List;


public class stepDefs {

    HomePage homepage = new HomePage();

    @Given("User will navigate to HomePage")
    public void user_will_navigate_to_HomePage() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "WebstaurantStore: Restaurant Supplies & Foodservice Equipment");

    }

    @When("User is on the home page")
    public void user_is_on_the_home_page() {
        BrowserUtils.verifyElementDisplayed(homepage.pageBanner);
    }

    @Then("User will see searchbox")
    public void user_will_see_searchbox() {
        BrowserUtils.verifyElementDisplayed(homepage.searchBox);
    }

    @When("User will type {string}")
    public void user_will_type(String string) {
        BrowserUtils.inputToTextBox(homepage.searchBox, string);
    }

    @When("User will click on search button")
    public void user_will_click_on_search_button() {
        BrowserUtils.clickToElement(homepage.searchButton);

    }
    @Then("User will verify every product item has the word {string} in its title.")
    public void user_will_verify_every_product_item_has_the_word_in_its_title(String string) {
        for (int i = 1; i < 9; i++) {
            BrowserUtils.clickToElement(homepage.paginationNext);
            List<String> products = BrowserUtils.getElementsText(homepage.productList);
            for (int j = 1; j < products.size() - 1; j++) {
                System.out.println("product text: " + products.get(j) + "  - " + products.get(j).contains("Table")  );
                Assert.assertTrue(products.get(j).contains("Table"));
            }
        }
    }

    @Then("user wiil add last found item on the cart")
    public void user_wiil_add_last_found_item_on_the_cart() {
        BrowserUtils.scrollByPage();
        BrowserUtils.clickToElement((homepage.addToCartButtonElementList.
                get(homepage.addToCartButtonElementList.size() - 1)));
    }

    @Then("user will empty the cart")
    public void user_will_empty_the_cart() {
        BrowserUtils.clickToElement(homepage.viewCartCloseButton);
        BrowserUtils.clickToElement(homepage.viewCartIcon);
        BrowserUtils.clickToElement(homepage.deleteProductIcon);

    }


}
