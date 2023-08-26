package tek.capstone.framework.steps;

import tek.capstone.framework.utilities.CommonUtility;
import tek.capstone.framework.utilities.DataGenerator;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import tek.capstone.framework.pages.PoMFactory;

public class RetailAccountSteps extends CommonUtility {
	PoMFactory factory = new PoMFactory();

// updateInfo
	@And("User click on Account option")
	public void UserClickOnAccountoption() {
		click(factory.retailAccountPage().accountLink);
		logger.info("Account button is clicked successfully.");
	}

	@And("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String phoneNumber) {
		factory.retailAccountPage().nameInputField.clear();
		sendText(factory.retailAccountPage().nameInputField, name);
		logger.info("Name was entered successfully. ");
		factory.retailAccountPage().phoneNoInputField.clear();
		sendText(factory.retailAccountPage().phoneNoInputField, DataGenerator.getPhoneNumber());
		logger.info("User name and Phone number are entered successfully.");
	}

	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.retailAccountPage().accountUpdateBtn);
		logger.info("update button is clicked successfully.");
	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.retailAccountPage().personalInfoUpdateMsg);
		Assert.assertTrue(factory.retailAccountPage().personalInfoUpdateMsg.isDisplayed());
		logger.info("Account information was updated successfully");
	}

// addPayment
	@And("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.retailAccountPage().addPaymentlink);
		logger.info("Add Payment link clicked successfully.");
	}

	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < cardInfo.size(); i++) {
			sendText(factory.retailAccountPage().cardNumberField, DataGenerator.getCardNumber());
			sendText(factory.retailAccountPage().nameOnCardField, cardInfo.get(0).get("nameOnCard"));
			sendText(factory.retailAccountPage().expMonthInput, cardInfo.get(0).get("expirationMonth"));
			sendText(factory.retailAccountPage().expYearInput, cardInfo.get(0).get("expirationYear"));
			sendText(factory.retailAccountPage().securityCodeInput, cardInfo.get(0).get("securityCode"));
		}
		logger.info("Card information entered successfully.");

	}

	@And("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.retailAccountPage().paymentSubmitBtn);
		logger.info("Add card button clicked successfully");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String message) {
		message = factory.retailAccountPage().paymentAddedMsg.getText();
		waitTillPresence(factory.retailAccountPage().paymentAddedMsg);
		Assert.assertTrue(factory.retailAccountPage().paymentAddedMsg.isDisplayed());
		logger.info("Message displayed successfully: " + message);
	}

// editPayment
	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(factory.retailAccountPage().firstPaymentCard);
		click(factory.retailAccountPage().editPaymentCard);
		logger.info("Payment edit button clicked successfully.");
	}

	@And("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < cardInfo.size(); i++) {
			factory.retailAccountPage().cardNumberField.clear();
			sendText(factory.retailAccountPage().cardNumberField, DataGenerator.getCardNumber());
			factory.retailAccountPage().nameOnCardField.clear();
			sendText(factory.retailAccountPage().nameOnCardField, cardInfo.get(0).get("nameOnCard"));
			sendText(factory.retailAccountPage().expMonthInput, cardInfo.get(0).get("expirationMonth"));
			sendText(factory.retailAccountPage().expYearInput, cardInfo.get(0).get("expirationYear"));
			factory.retailAccountPage().securityCodeInput.clear();
			sendText(factory.retailAccountPage().securityCodeInput, cardInfo.get(0).get("securityCode"));

		}
		logger.info("Payment information updated");
	}

	@And("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.retailAccountPage().updatePaymentBtn);
		logger.info("update payment button clicked successfully");
	}

	@Then("update message should be displayed {string}")
	public void UpdateMessageShouldBeDisplayed(String actualMsg) {
		waitTillPresence(factory.retailAccountPage().updatePaymentSuccessMsg);
		String expectedMsg = "Payment Method updated sucessfully";
		if (actualMsg == expectedMsg) {
			Assert.assertTrue(factory.retailAccountPage().updatePaymentSuccessMsg.isDisplayed());
			logger.info("payment success message displayed successfully.");
		}
	}

// removeCard
	@And("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.retailAccountPage().paymentList);
		click(factory.retailAccountPage().cardRemoveBtn);
		logger.info("card remove button clicked successfully");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(factory.retailAccountPage().addCardHeader.isDisplayed());
		logger.info("payment card removed successfully.");
	}

//add Address
	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		scrollPageDownWithJS();
		click(factory.retailAccountPage().addAddressLink);
		logger.info("add address link clicked.");
	}

	@And("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < addressInfo.size(); i++) {
			sendText(factory.retailAccountPage().countryDropdown, addressInfo.get(0).get("country"));
			sendText(factory.retailAccountPage().fullNameInput, addressInfo.get(0).get("fullName"));
			sendText(factory.retailAccountPage().phoneNumberInput, DataGenerator.getPhoneNumber());
			sendText(factory.retailAccountPage().streetInput, addressInfo.get(0).get("streetAddress"));
			sendText(factory.retailAccountPage().apartmentInput, addressInfo.get(0).get("apt"));
			sendText(factory.retailAccountPage().cityInput, addressInfo.get(0).get("city"));
			sendText(factory.retailAccountPage().stateField, addressInfo.get(0).get("state"));
			sendText(factory.retailAccountPage().zipCodeInput, DataGenerator.getZipCode());

		}
		logger.info("Address form filled");
	}

	@And("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.retailAccountPage().addressBtn);
		logger.info("Add address button clicked successfully");
	}

	@Then("address message should be displayed {string}")
	public void addressMessageShouldBeDisplayed(String message) {
		waitTillPresence(factory.retailAccountPage().addAddressSuccessMsg);
		Assert.assertEquals(message,factory.retailAccountPage().addAddressSuccessMsg.getText());
		logger.info("Address Added Successfully message displayed");
	}

//edit address
	@And("User click on edit address option")
	public void userClickOnEditAddressOption() {
		click(factory.retailAccountPage().editAddressLink);
		logger.info("address edit link clicked successfully");

	}

	@And("user fill new address form with below informations")
	public void userFillNewAddressFormWithBelowInformations(DataTable dataTable) {

		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		for (int i = 0; i < addressInfo.size(); i++) {
			sendText(factory.retailAccountPage().countryDropdown, addressInfo.get(0).get("country"));
			clearTextUsingSendKeys(factory.retailAccountPage().fullNameInput);
			sendValueUsingJS(factory.retailAccountPage().fullNameInput, addressInfo.get(0).get("fullName"));
			clearTextUsingSendKeys(factory.retailAccountPage().phoneNumberInput);
			sendValueUsingJS(factory.retailAccountPage().phoneNumberInput, DataGenerator.getPhoneNumber());
			clearTextUsingSendKeys(factory.retailAccountPage().streetInput);
			sendValueUsingJS(factory.retailAccountPage().streetInput, addressInfo.get(0).get("streetAddress"));
			clearTextUsingSendKeys(factory.retailAccountPage().apartmentInput);
			sendValueUsingJS(factory.retailAccountPage().apartmentInput, addressInfo.get(0).get("apt"));
			clearTextUsingSendKeys(factory.retailAccountPage().cityInput);
			sendValueUsingJS(factory.retailAccountPage().cityInput, addressInfo.get(0).get("city"));
			sendValueUsingJS(factory.retailAccountPage().stateField, addressInfo.get(0).get("state"));
			clearTextUsingSendKeys(factory.retailAccountPage().zipCodeInput);
			sendValueUsingJS(factory.retailAccountPage().zipCodeInput, DataGenerator.getZipCode());
		}
		logger.info("new address form filled successfully");
	}

	@And("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		scrollPageDownWithJS();
		click(factory.retailAccountPage().updateAddressBtn);
		logger.info("update address button clicked successfully");
	}

	@And("update address message should be displayed {string}")
	public void updateAddressMessageShouldBeDisplayed(String message) {
		waitTillPresence(factory.retailAccountPage().addressUpdateSuccessMsg);
		Assert.assertEquals(message,factory.retailAccountPage().addressUpdateSuccessMsg.getText());
		logger.info("update address message displayed");
	}

//remove address
	@And("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		scrollPageDownWithJS();
		click(factory.retailAccountPage().RemoveAddressBtn);
		logger.info("remove address button clicked");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		if (!isElementDisplayed(factory.retailAccountPage().addressBox)) {
			logger.info("address details removed");
		}
	}

}
