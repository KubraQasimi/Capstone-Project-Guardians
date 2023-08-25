package tek.capstone.framework.steps;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import tek.capstone.framework.pages.PoMFactory;
import tek.capstone.framework.utilities.CommonUtility;
import tek.capstone.framework.utilities.DataGenerator;

public class SignInSteps extends CommonUtility {
	PoMFactory factory = new PoMFactory();

// sign in
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		Assert.assertTrue(factory.homePage().tekTitle.isDisplayed());
		logger.info("TEKSCHOOL logo is displayed.");
	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homePage().signInLink);
		logger.info("Sign in button is clicked");
	}

	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.retailSignInPage().emailField, email);
		sendText(factory.retailSignInPage().passwordField, password);
		logger.info("Email and password entered successfully");
	}

	@And("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.retailSignInPage().loginBtn);
		logger.info("Login button clicked");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(factory.retailAccountPage().accountLink.isDisplayed());
		logger.info("user is logged in");
	}

//create account
	@And("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.retailSignInPage().newAccountBtn);
		logger.info("Create new account button clicked successfully.");
	}

	@And("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> accountInfo = dataTable.asMaps(String.class, String.class);
		sendText(factory.retailSignInPage().accountnameInput, accountInfo.get(0).get("name"));
		sendText(factory.retailSignInPage().accountemailInput, DataGenerator.emailGenerator());
		sendText(factory.retailSignInPage().accountpasswordInput, accountInfo.get(0).get("password"));
		sendText(factory.retailSignInPage().confirmPasswordInput, accountInfo.get(0).get("confirmPassword"));
		logger.info("Information was successfully entered");
	}

	@And("User click on SignUp button")
	public void userClickOnSignUpButton() {
		click(factory.retailSignInPage().signupBtn);
		logger.info("Signup button clicked Successfully");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(factory.retailAccountPage().yourProfile.isDisplayed());
		logger.info("Account page displayed");
	}

}