package tek.capstone.framework.steps;

import tek.capstone.framework.utilities.CommonUtility;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.*;
import tek.capstone.framework.pages.PoMFactory;

public class RetailOrderSteps extends CommonUtility {
	PoMFactory factory = new PoMFactory();

//add Item
	@And("User change the category to {string}")
	public void userChangeTheCategoryToSmartHome(String category) {
		click(factory.retailOrderPage().allDepartmentOption);
		selectByVisibleText(factory.retailOrderPage().allDepartmentOption, category);
		logger.info("Category is changed to Smart Home successfully");
	}

	@And("User search for an item {string}")
	public void userSearchForAnItem(String item) {
		sendText(factory.retailOrderPage().searchBox, item);
		logger.info("search for kasa outdoor smart plug");
	}

	@And("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.retailOrderPage().searchIcon);
		logger.info("search button clicked successfully");
	}

	@And("User click on item")
	public void userClickOnItem() {
		click(factory.retailOrderPage().kasa);
		logger.info("item clicked successfully");
	}

	@And("User select quantity {string}")
	public void userSelectQuantity(String quantity) {
		click(factory.retailOrderPage().quantityOption);
		selectByVisibleText(factory.retailOrderPage().quantityOption, quantity);
		logger.info("Quantity(2) is selected");
	}

	@And("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.retailOrderPage().addToCartBtn);
		logger.info("Add to cart button clicked successfully");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String quantity) {
		if (factory.retailOrderPage().quantityOption.equals(quantity)) {
		}
		logger.info("quantity is 2");
	}

//add address on order

	@And("User changes the category to the {string}")
	public void userChangesTheCategoryToThe(String category) {
		click(factory.retailOrderPage().allDepartmentOption);
		selectByVisibleText(factory.retailOrderPage().allDepartmentOption, category);
		logger.info("Category changed to Electronincs successfully");
	}

	@And("User searchs for an item {string}")
	public void userSearchsForAnItem(String item) {
		sendText(factory.retailOrderPage().searchBox, item);
		logger.info("search for an item");
	}

	@And("User clicks on Search icon")
	public void userClicksOnSearchIcon() {
		clickElementWithJS(factory.retailOrderPage().searchIcon);
		logger.info("search button clicked successfully");
	}

	@And("User clicks on item")
	public void userClicksOnItem() {
		click(factory.retailOrderPage().ApexLegends);
		logger.info("item clicked successfully");
	}

	@And("User selects quantity {string}")
	public void userSelectsQuantity(String quantity) {
		click(factory.retailOrderPage().quantityOption);
		selectByValue(factory.retailOrderPage().quantityOption, quantity);
		logger.info("Quantity selected");
	}

	@And("User clicks add to Cart button")
	public void userClicksAddToCartButton() {
		click(factory.retailOrderPage().addToCartBtn);
		logger.info("add to cart button clicked successfully");
	}

	@And("the carts icon quantity should change to {string}")
	public void theCartsIconQuantityShouldChangeTo(String quantity) {
		if (factory.retailOrderPage().quantityOption.equals(quantity)) {
			logger.info("quantity is 5");
		}
	}

	@And("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.retailOrderPage().cartBtn);
		logger.info("Cart option clicked successfully");
	}

	@And("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.retailOrderPage().proceedCheckoutBtn);
		logger.info("check out option clicked successfully");
	}

	@And("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.retailOrderPage().placeOrderBtn);
		logger.info("place order button was clicked successfully");
	}

	@Then("a confirmation message should be displayed {string}") 
	public void aConfirmationMessageShouldBeDisplayed(String string) {
		waitTillPresence(factory.retailOrderPage().orderPlacedSuccessMsg);
		Assert.assertTrue(factory.retailOrderPage().orderPlacedSuccessMsg.isDisplayed());
		logger.info("confirmation Message displayed");
	}

//order cancellation
	@And("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.retailOrderPage().orderLink);
		logger.info("order link clicked successfully.");
	}

	@And("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		click(factory.retailOrderPage().ItemsShowDetails);
		logger.info("first order in list clicked");
	}

	@And("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.retailOrderPage().orderCancelBtn);
		logger.info("cancel order button clicked");
	}

	@And("User select the cancelation Reason 'Bought wrong item'")
	public void userSelectTheCancelationReason() {
		clickElementWithJS(factory.retailOrderPage().cancelationReason);
		selectByIndex(factory.retailOrderPage().cancelationReason, 1);
		logger.info("cancelation reason selected");
	}

	@And("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.retailOrderPage().cancelOrder);
		logger.info("cancel order button clicked");
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String cancellationMsg) {
		waitTillPresence(factory.retailOrderPage().orderCancelationMsg);
		Assert.assertEquals(cancellationMsg, factory.retailOrderPage().orderCancelationMsg.getText());
		logger.info("cancelation message displayed");
	}

//return order
	@And("User clicks on Orders section")
	public void userClicksOnOrdersSection() {
		click(factory.retailOrderPage().orderLink);
		logger.info("order link clicked successfully.");
	}

	@And("User clicks on first order in list")
	public void userClicksOnFirstOrderInList() {
		click(factory.retailOrderPage().ItemsShowDetails);
		logger.info("first order in list clicked");
	}

	@And("User clicks on Return Items button")
	public void userClicksOnReturnItemsButton() {
		click(factory.retailOrderPage().orderReturnBtn);
		logger.info("order return button clicked");
	}

	@And("User selects the Return Reason {string}")
	public void userSelectsTheReturnReason(String reason) {
		selectByVisibleText(factory.retailOrderPage().cancelationReason, reason);
		logger.info("cancellation reason Bought wrong item.");
	}

	@And("User selects the drop off service {string}")
	public void userSelectsTheDropOffService(String category) {
		selectByVisibleText(factory.retailOrderPage().dropOffService, category);
		logger.info("drop off service selected.");
	}

	@And("User clicks on Return Order button")
	public void userClicksOnReturnOrderButton() {
		click(factory.retailOrderPage().orderReturnAndSubmitBtn);
		logger.info("order return clicked successfuly.");
	}

	@Then("the cancelation message should be displayed {string}")
	public void theCancelationMessageShouldBeDisplayed(String message) {
		Assert.assertTrue(factory.retailOrderPage().orderReturnSuccessMsg.isDisplayed());
		logger.info("Return message was displayed successfuly");
	}

//add review

	@And("User click on the Orders section")
	public void userClickOnTheOrdersSection() {
		click(factory.retailOrderPage().orderLink);
		logger.info("order link clicked successfully.");
	}

	@And("User click on the first order in list")
	public void userClickOnTheFirstOrderInList() {
		click(factory.retailOrderPage().ItemsShowDetails);
		logger.info("first order in list clicked");
	}

	@And("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.retailOrderPage().reviewBtn);
		logger.info("Review button clicked");
	}

	@And("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String headline, String comment) {
		headline = "Amazing product";
		comment = " I dont know what to say :) ";
		sendText(factory.retailOrderPage().headlineInputField, headline);
		sendText(factory.retailOrderPage().commentField, comment);
		logger.info("headline and comment added ");
	}

	@And("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.retailOrderPage().addReviewBtn);
		logger.info("Review button clicked");
	}

	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayed(String message) {
		message = "Your review was added successfully"; 
		waitTillPresence(factory.retailOrderPage().reviewAddedSuccessMsg);
		Assert.assertTrue(factory.retailOrderPage().reviewAddedSuccessMsg.isDisplayed());
		logger.info("Review success message displayed");
	}

}
